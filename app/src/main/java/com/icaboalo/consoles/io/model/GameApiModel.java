package com.icaboalo.consoles.io.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by icaboalo on 6/05/16.
 */
public class GameApiModel {

    public GameApiModel(String name) {
        mName = name;
    }

    @SerializedName("id")
    int mId;

    @SerializedName("name")
    String mName;

    public int getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }
}
