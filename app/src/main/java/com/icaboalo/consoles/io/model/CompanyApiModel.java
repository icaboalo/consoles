package com.icaboalo.consoles.io.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by icaboalo on 6/05/16.
 */
public class CompanyApiModel {

    public CompanyApiModel(String name, String apiDetailUrl) {
        mName = name;
        mApiDetailUrl = apiDetailUrl;
    }

    @SerializedName("id")
    int mId;

    @SerializedName("name")
    String mName;

    @SerializedName("api_detail_url")
    String mApiDetailUrl;

    public int getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public String getApiDetailUrl() {
        return mApiDetailUrl;
    }
}
