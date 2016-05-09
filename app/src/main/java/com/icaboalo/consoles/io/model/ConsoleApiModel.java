package com.icaboalo.consoles.io.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by icaboalo on 6/05/16.
 */
public class ConsoleApiModel {

    @SerializedName("results")
    ArrayList<ResultsApiModel> mResults;

    public ArrayList<ResultsApiModel> getResults() {
        return mResults;
    }
}
