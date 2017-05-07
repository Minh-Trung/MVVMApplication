package mitru.com.mvvmapplication.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by ctruong on 07/05/2017.
 */

public class Login implements Serializable {
    @SerializedName("username") public String userName;
}
