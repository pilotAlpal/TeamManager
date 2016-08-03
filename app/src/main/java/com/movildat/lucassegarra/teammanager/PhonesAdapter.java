package com.movildat.lucassegarra.teammanager;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by lucas.segarra on 03/08/2016.
 */
public class PhonesAdapter extends RecyclerView.Adapter<PhonesAdapter.ViewHolder> {
    private String[] matesPhones;
    private int numElems;
    private final static int PLAYERS_FOR_TEAM=21;

    PhonesAdapter(String[] data){
        if(data!=null) {
            matesPhones = data;
            numElems=data.length;
        }
    }
    PhonesAdapter(){
        numElems=0;
        matesPhones=new String[PLAYERS_FOR_TEAM];
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView phoneTV;
        public ViewHolder(View v){
            super(v);
            phoneTV=(TextView)v.findViewById(R.id.tv_phone);
        }
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.listed_phones_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder,int pos){
        holder.phoneTV.setText(matesPhones[pos]);
    }
    @Override
    public int getItemCount(){
        return numElems;
    }

    public void addItem(String number){
        matesPhones[numElems]=number;
        numElems++;
        notifyDataSetChanged();
    }
    public void remove(int pos){
        for(int i=pos;i<numElems-1;i++)
            matesPhones[i]=matesPhones[i+1];
        numElems--;
        notifyDataSetChanged();
    }
}
