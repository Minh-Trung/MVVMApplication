package mitru.com.mvvmapplication.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by ctruong on 07/05/2017.
 */

public class Picture implements Serializable {

    @SerializedName("large")
    public String large;

    @SerializedName("medium")
    public String medium;

    @SerializedName("thumbnail")
    public String thumbnail;
}
