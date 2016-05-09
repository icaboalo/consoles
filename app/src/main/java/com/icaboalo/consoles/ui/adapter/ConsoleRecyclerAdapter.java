package com.icaboalo.consoles.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.icaboalo.consoles.R;
import com.icaboalo.consoles.io.model.ResultsApiModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by icaboalo on 6/05/16.
 */
public class ConsoleRecyclerAdapter extends RecyclerView.Adapter<ConsoleRecyclerAdapter.ConsoleViewHolder> {

    Context mContext;
    ArrayList<ResultsApiModel> mResultsList;
    LayoutInflater mInflater;
    OnViewHolderClick mViewHolderClick;

    public ConsoleRecyclerAdapter(Context context, ArrayList<ResultsApiModel> resultsList, OnViewHolderClick viewHolderClick) {
        mContext = context;
        mResultsList = resultsList;
        this.mInflater = LayoutInflater.from(context);
        mViewHolderClick = viewHolderClick;
    }

    @Override
    public ConsoleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View nView = mInflater.inflate(R.layout.item_console_adapter, parent, false);
        return new ConsoleViewHolder(nView, R.id.console_image, R.id.name_text, R.id.company_name, mViewHolderClick);
    }

    @Override
    public void onBindViewHolder(ConsoleViewHolder holder, int position) {
        ResultsApiModel nResult = mResultsList.get(position);
        holder.mConsoleName.setText(nResult.getName());
        holder.mConsoleCompany.setText(nResult.getCompany().getName());
        holder.setConsoleImage(nResult.getImage());
    }

    @Override
    public int getItemCount() {
        return mResultsList.size();
    }

    class ConsoleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView mConsoleImage;
        TextView mConsoleName, mConsoleCompany;
        OnViewHolderClick mViewHolderClick;

        public ConsoleViewHolder(View itemView, int consoleImageId, int consoleNameId, int consoleCompanyId, OnViewHolderClick viewHolderClick) {
            super(itemView);
            mConsoleImage = (ImageView) itemView.findViewById(consoleImageId);
            mConsoleName = (TextView) itemView.findViewById(consoleNameId);
            mConsoleCompany = (TextView) itemView.findViewById(consoleCompanyId);
            mViewHolderClick = viewHolderClick;
            itemView.setOnClickListener(this);
        }

        void setConsoleImage(String url){
            if (url !=null && !url.isEmpty()){
                Picasso.with(mContext).load(url).into(mConsoleImage);
            }
            else {
                mConsoleImage.setImageDrawable(null);
            }
        }

        @Override
        public void onClick(View v) {
            mViewHolderClick.onClick(v, getAdapterPosition());
        }
    }
}
