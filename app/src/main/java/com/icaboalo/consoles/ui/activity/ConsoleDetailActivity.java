package com.icaboalo.consoles.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.icaboalo.consoles.R;
import com.icaboalo.consoles.io.ApiClient;
import com.icaboalo.consoles.io.model.GameApiModel;
import com.icaboalo.consoles.io.model.ResultsApiModel;
import com.icaboalo.consoles.ui.adapter.GamesRecyclerAdapter;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConsoleDetailActivity extends AppCompatActivity {

    @Bind(R.id.console_description_text)
    TextView mDescription;

    @Bind(R.id.release_date_text)
    TextView mDate;

    @Bind(R.id.games_recycler)
    RecyclerView mGamesRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_console_detail);
        ButterKnife.bind(this);
        getConsoleDetail(getConsoleId());
    }

    String getConsoleId(){
        return "" + getIntent().getIntExtra("consoleId", 0);
    }

    void getConsoleDetail(final String consoleId){
        Call<ResultsApiModel> call = ApiClient.getApiService().getConsoles(consoleId);
        call.enqueue(new Callback<ResultsApiModel>() {
            @Override
            public void onResponse(Call<ResultsApiModel> call, Response<ResultsApiModel> response) {
                if (response.isSuccessful()){
                    ResultsApiModel console = response.body();
                    getSupportActionBar().setTitle(console.getName());
                    mDescription.setText(console.getDescription());
                    mDate.setText(console.getRelease());
                    setupGamesRecycler(console.getGames());
                }else{
                    getSupportActionBar().setTitle("ERROR NOT FOUND");
                }
            }

            @Override
            public void onFailure(Call<ResultsApiModel> call, Throwable t) {

            }
        });
    }

    void setupGamesRecycler(ArrayList<GameApiModel> gamesList){
        GamesRecyclerAdapter nGamesRecyclerAdapter = new GamesRecyclerAdapter(this, gamesList);
        GridLayoutManager nGridLayoutManager = new GridLayoutManager(this, 2);
        mGamesRecycler.setAdapter(nGamesRecyclerAdapter);
        mGamesRecycler.setLayoutManager(nGridLayoutManager);
    }
}
