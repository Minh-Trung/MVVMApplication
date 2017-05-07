package mitru.com.mvvmapplication.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by ctruong on 07/05/2017.
 */

public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.PeopleAdapterViewHolder> {
    @Override
    public PeopleAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(PeopleAdapterViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class PeopleAdapterViewHolder extends RecyclerView.ViewHolder{
        public PeopleAdapterViewHolder(View itemView) {
            super(itemView);
        }
    }
}
