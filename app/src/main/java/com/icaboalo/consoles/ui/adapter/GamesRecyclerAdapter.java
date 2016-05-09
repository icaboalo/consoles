package com.icaboalo.consoles.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.icaboalo.consoles.io.model.GameApiModel;

import java.util.ArrayList;

/**
 * Created by icaboalo on 6/05/16.
 */
public class GamesRecyclerAdapter extends RecyclerView.Adapter<GamesRecyclerAdapter.GamesViewHolder> {

    Context mContext;
    ArrayList<GameApiModel> mGameList;
    LayoutInflater mInflater;

    public GamesRecyclerAdapter(Context context, ArrayList<GameApiModel> gameList) {
        mContext = context;
        mGameList = gameList;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public GamesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(android.R.layout.simple_list_item_1, parent, false);
        return new GamesViewHolder(view, android.R.id.text1);
    }

    @Override
    public void onBindViewHolder(GamesViewHolder holder, int position) {
        GameApiModel game = mGameList.get(position);
        holder.mGame.setText(game.getName());
    }

    @Override
    public int getItemCount() {
        return mGameList.size();
    }

    class GamesViewHolder extends RecyclerView.ViewHolder{

        TextView mGame;

        public GamesViewHolder(View itemView, int textId) {
            super(itemView);
            mGame = (TextView) itemView.findViewById(textId);
        }
    }
}
