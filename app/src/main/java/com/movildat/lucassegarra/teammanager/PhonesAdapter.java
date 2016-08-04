package com.movildat.lucassegarra.teammanager;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
        public Button removeButt;
        public ViewHolder(View v){
            super(v);
            phoneTV=(TextView)v.findViewById(R.id.tv_phone);
            removeButt=(Button)v.findViewById(R.id.b_remove_phone);
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
        final int aux=pos;
        holder.removeButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i= aux;i<aux-1;i++)
                    matesPhones[i]=matesPhones[i+1];
                matesPhones[numElems]=null;
                numElems--;
                notifyDataSetChanged();
            }
        });
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

}
