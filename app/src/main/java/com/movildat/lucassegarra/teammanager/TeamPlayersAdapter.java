package com.movildat.lucassegarra.teammanager;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.Image;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by lucas.segarra on 02/08/2016.
 */
public class TeamPlayersAdapter extends RecyclerView.Adapter<TeamPlayersAdapter.ViewHolder> {
    private String list[];

    public static class ViewHolder extends RecyclerView.ViewHolder /*implements View.OnClickListener*/{
        public ImageView image;
        public TextView name;

        public ViewHolder(View v){
            super(v);
            image=(ImageView) v.findViewById(R.id.iv_tmi);
            name=(TextView) v.findViewById(R.id.tv_name_tmi);
        }
      /*  @Override
        public void onClick(View v){
            Toast.makeText(v.getContext(),name.getText().toString(),Toast.LENGTH_LONG).show();
        }*/
    }

    public TeamPlayersAdapter(String data[]){
        if(data!=null)
            list=data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.team_mates_item,parent,false);
        return new ViewHolder(v);
    }
     @Override
    public void onBindViewHolder(ViewHolder vH,int pos){
        vH.name.setText(list[pos]);
         //cargar imagenes
     }

    @Override
    public int getItemCount(){
        return list.length;
    }
}
