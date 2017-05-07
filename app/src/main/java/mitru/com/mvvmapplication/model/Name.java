package mitru.com.mvvmapplication.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by ctruong on 07/05/2017.
 */

public class Name implements Serializable {
    @SerializedName("title") public String title;
    @SerializedName("first") public String first;
    @SerializedName("last") public String last;
}
