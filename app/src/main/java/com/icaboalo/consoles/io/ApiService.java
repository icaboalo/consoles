package com.icaboalo.consoles.io;

import com.icaboalo.consoles.io.model.ConsoleApiModel;
import com.icaboalo.consoles.io.model.ResultsApiModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by icaboalo on 6/05/16.
 */
public interface ApiService {

    @GET("consoles.php")
    Call<ConsoleApiModel> getConsoles();

    @GET("consoles.php")
    Call<ResultsApiModel> getConsoles(@Query("id_console") String consoleId);

    @GET("consoles.php")
    Call<ResultsApiModel> getConsoles(@Query("id_console") String consoleId, @Query("id_game")String gameId);
}
