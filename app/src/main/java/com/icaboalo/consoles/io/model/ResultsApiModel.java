package com.icaboalo.consoles.io.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by icaboalo on 6/05/16.
 */
public class ResultsApiModel {

    public ResultsApiModel(String name, String image, CompanyApiModel company) {
        mName = name;
        mImage = image;
        mCompany = company;
    }

    @SerializedName("id")
    int mId;

    @SerializedName("name")
    String mName;

    @SerializedName("image")
    String mImage;

    @SerializedName("company")
    CompanyApiModel mCompany;

    @SerializedName("description")
    String mDescription;

    @SerializedName("release")
    String mRelease;

    @SerializedName("games")
    ArrayList<GameApiModel> mGames;

    public int getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public String getImage() {
        return mImage;
    }

    public CompanyApiModel getCompany() {
        return mCompany;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getRelease() {
        return mRelease;
    }

    public ArrayList<GameApiModel> getGames() {
        return mGames;
    }
}
