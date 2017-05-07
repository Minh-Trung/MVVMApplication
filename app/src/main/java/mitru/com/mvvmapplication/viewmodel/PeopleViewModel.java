package mitru.com.mvvmapplication.viewmodel;

import android.content.Context;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.support.annotation.NonNull;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import mitru.com.mvvmapplication.PeopleApplication;
import mitru.com.mvvmapplication.R;
import mitru.com.mvvmapplication.data.PeopleFactory;
import mitru.com.mvvmapplication.data.PeopleResponse;
import mitru.com.mvvmapplication.data.PeopleService;
import mitru.com.mvvmapplication.model.People;

/**
 * Created by ctruong on 07/05/2017.
 */

public class PeopleViewModel extends Observable {
    public ObservableInt peopleProgress;
    public ObservableInt peopleRecycler;
    public ObservableInt peopleLabel;
    public ObservableField<String> messageLabel;
    List<People> peopleList;
    Context context;
    CompositeDisposable compositeDisposable = new CompositeDisposable();

    public PeopleViewModel(@NonNull Context context) {
        this.context = context;
        this.peopleList = new ArrayList<>();
        peopleProgress = new ObservableInt(View.GONE);
        peopleRecycler = new ObservableInt(View.GONE);
        peopleLabel = new ObservableInt(View.VISIBLE);
        messageLabel = new ObservableField<>(context.getString(R.string.default_loading_people));
    }

    public void onClickFabLoad(View view) {
        initialyzeViews();
        fetchPeopleList();
    }

    public void initialyzeViews() {
        peopleProgress.set(View.GONE);
        peopleRecycler.set(View.GONE);
        peopleLabel.set(View.VISIBLE);
    }

    public void fetchPeopleList() {
        PeopleApplication peopleApplication = PeopleApplication.create(context);
        PeopleService peopleService = peopleApplication.getPeopleService();

        Disposable disposable = peopleService.fetchPeople(PeopleFactory.RANDOM_USER_URL)
                .subscribeOn(peopleApplication.getScheduler())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<PeopleResponse>() {
                    @Override
                    public void accept(@io.reactivex.annotations.NonNull PeopleResponse peopleResponse) throws Exception {
                        changePeopleDataSet(peopleResponse.getPeopleList());
                        peopleProgress.set(View.GONE);
                        peopleRecycler.set(View.VISIBLE);
                        peopleLabel.set(View.GONE);
                    }
                });
    }

    public List<People> getPeopleList() {
        return peopleList;
    }

    public void changePeopleDataSet(List<People> peoples){
        peopleList.addAll(peoples);
        setChanged();
        notifyObservers();
    }

    public void unsubscribeFromObservable(){
        if (compositeDisposable != null && !compositeDisposable.isDisposed()){
            compositeDisposable.dispose();
        }
    }

    public void reset(){
        unsubscribeFromObservable();
        compositeDisposable = null;
        context = null;
    }
}
