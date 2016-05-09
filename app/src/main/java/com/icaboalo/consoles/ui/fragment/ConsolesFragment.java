package com.icaboalo.consoles.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.icaboalo.consoles.R;
import com.icaboalo.consoles.io.ApiClient;
import com.icaboalo.consoles.io.model.ConsoleApiModel;
import com.icaboalo.consoles.io.model.ResultsApiModel;
import com.icaboalo.consoles.ui.activity.ConsoleDetailActivity;
import com.icaboalo.consoles.ui.adapter.ConsoleRecyclerAdapter;
import com.icaboalo.consoles.ui.adapter.OnViewHolderClick;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by icaboalo on 6/05/16.
 */
public class ConsolesFragment extends Fragment {

    @Bind(R.id.recycler_view)
    RecyclerView mConsoleRecycler;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycler, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getConsoles();
    }

    void setupConsoleRecycler(final ArrayList<ResultsApiModel> consoleList){
        ConsoleRecyclerAdapter nConsoleRecyclerAdapter = new ConsoleRecyclerAdapter(getActivity(), consoleList, new OnViewHolderClick() {
            @Override
            public void onClick(View v, int position) {
                Log.d("LOG", consoleList.get(position).getName());
                Intent goToConsoleDetail =new Intent(getActivity(), ConsoleDetailActivity.class);
                goToConsoleDetail.putExtra("consoleId", consoleList.get(position).getId());
                startActivity(goToConsoleDetail);
            }
        });
        LinearLayoutManager nLinearLayout = new LinearLayoutManager(getActivity());
        mConsoleRecycler.setAdapter(nConsoleRecyclerAdapter);
        mConsoleRecycler.setLayoutManager(nLinearLayout);
    }

    void getConsoles(){
        Call<ConsoleApiModel> call = ApiClient.getApiService().getConsoles();
        call.enqueue(new Callback<ConsoleApiModel>() {
            @Override
            public void onResponse(Call<ConsoleApiModel> call, Response<ConsoleApiModel> response) {
                if (response.isSuccessful()){
                    ArrayList<ResultsApiModel> resultsList = response.body().getResults();
                    setupConsoleRecycler(resultsList);
                }
            }

            @Override
            public void onFailure(Call<ConsoleApiModel> call, Throwable t) {

            }
        });
    }
}
