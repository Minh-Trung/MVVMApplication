package mitru.com.mvvmapplication.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by ctruong on 07/05/2017.
 */

public class Location implements Serializable {
    @SerializedName("street") public String street;
    @SerializedName("city") public String city;
    @SerializedName("state") public String state;
    @SerializedName("zip") public String zip;
}
