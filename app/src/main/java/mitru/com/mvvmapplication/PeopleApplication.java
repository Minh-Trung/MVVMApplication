package mitru.com.mvvmapplication;

import android.app.Application;
import android.content.Context;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import mitru.com.mvvmapplication.data.PeopleFactory;
import mitru.com.mvvmapplication.data.PeopleService;

/**
 * Created by ctruong on 07/05/2017.
 */

public class PeopleApplication extends Application {
    private PeopleService peopleService;
    private Scheduler scheduler;

    public static PeopleApplication get(Context context){
        return (PeopleApplication) context.getApplicationContext();
    }

    public static PeopleApplication create(Context context)
    {
        return PeopleApplication.get(context);
    }

    public void setPeopleService(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    public Scheduler getScheduler() {
        if (scheduler == null) scheduler = Schedulers.io();
        return scheduler;
    }

    public void setScheduler(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    public PeopleService getPeopleService() {
        if (peopleService == null) peopleService = PeopleFactory.create();
        return peopleService;
    }
}
