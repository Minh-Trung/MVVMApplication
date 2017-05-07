package mitru.com.mvvmapplication.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import mitru.com.mvvmapplication.model.People;

/**
 * Created by ctruong on 07/05/2017.
 */

public class PeopleResponse {
    @SerializedName("results") private List<People> peopleList;

    public List<People> getPeopleList() {
        return peopleList;
    }

    public void setPeopleList(List<People> peopleList) {
        this.peopleList = peopleList;
    }
}
