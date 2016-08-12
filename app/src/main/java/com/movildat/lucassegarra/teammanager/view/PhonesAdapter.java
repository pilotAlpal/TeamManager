package com.movildat.lucassegarra.teammanager.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.movildat.lucassegarra.teammanager.R;

import java.util.ArrayList;

/**
 * Created by lucas.segarra on 03/08/2016.
 */
public class PhonesAdapter extends RecyclerView.Adapter<PhonesAdapter.ViewHolder> {
    private ArrayList<String> matesPhones;

    PhonesAdapter(String[] data){
        matesPhones=new ArrayList<String>();
        if(data!=null) {
            for(int i=0;i<data.length;i++){
                matesPhones.add(i,data[i]);
            }
        }
    }
    PhonesAdapter(){
        matesPhones=new ArrayList<String>();
    }

    public void clear() {
        matesPhones=new ArrayList<String >();
        notifyDataSetChanged();
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
        holder.phoneTV.setText(matesPhones.get(pos));
        final int aux=pos;
        holder.removeButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                matesPhones.remove(aux);
                notifyDataSetChanged();
            }
        });
    }
    @Override
    public int getItemCount(){
        return matesPhones.size();
    }

    public void addItem(String number){
        matesPhones.add(matesPhones.size(),number);
        notifyDataSetChanged();
    }

    public ArrayList<String> getValues(){
        return matesPhones;
    }


}
