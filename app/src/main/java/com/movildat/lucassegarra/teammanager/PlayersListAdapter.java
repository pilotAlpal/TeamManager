package com.movildat.lucassegarra.teammanager;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by lucas.segarra on 19/07/2016.
 */
public class PlayersListAdapter extends RecyclerView.Adapter<PlayersListAdapter.ViewHolder> {
    private String[] mDataSet;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView mTextView;

        public ViewHolder(TextView tView){
            super(tView);
            mTextView=tView;
        }

        public ViewHolder(View v){
            super(v);
            mTextView=(TextView)v.findViewById(R.id.tv_next_player);
        }
    }


    public PlayersListAdapter(String[] data){
        if(data!=null)
            mDataSet=data;
    }

    /*
    public void addItem(int pos){
        mDataSet[pos]=new
    }
    */

    public void fillList(String[] equipoFantasma){
        for(int i=0;i<equipoFantasma.length;i++){
            mDataSet[i]=equipoFantasma[i];
            notifyItemInserted(i);
        }

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.next_match_availables_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder,int pos){
        holder.mTextView.setText(mDataSet[pos]);
    }

    @Override
    public int getItemCount(){
        return mDataSet.length;
    }


}
