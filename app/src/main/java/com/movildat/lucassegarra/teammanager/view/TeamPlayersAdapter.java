package com.movildat.lucassegarra.teammanager.view;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.movildat.lucassegarra.teammanager.R;
import com.movildat.lucassegarra.teammanager.controler.Controller;
import com.movildat.lucassegarra.teammanager.model.Player;

import java.util.ArrayList;

/**
 * Created by lucas.segarra on 02/08/2016.
 */
public class TeamPlayersAdapter extends RecyclerView.Adapter<TeamPlayersAdapter.ViewHolder> {
    private ArrayList<Player> list;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView image;
        public TextView name;
        public String playerPhone;

        public ViewHolder(View v){
            super(v);
            image=(ImageView) v.findViewById(R.id.iv_tmi);
            name=(TextView) v.findViewById(R.id.tv_name_tmi);
            RelativeLayout layout=(RelativeLayout) v.findViewById(R.id.view_layout);
            layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }
        public void setPlayerPhone(String t){
            playerPhone=t;
        }

        public String getPlayerPhone(){
            return playerPhone;
        }

    }

    public TeamPlayersAdapter(ArrayList<Player> partners){;
        if(partners!=null)
            list=partners;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.team_mates_item,parent,false);
        return new ViewHolder(v);
    }
     @Override
    public void onBindViewHolder(ViewHolder vH,int pos){
        Player j=list.get(pos);
         vH.name.setText(j.getNombre());
         vH.setPlayerPhone(j.getPhone());
         //cargar imagenes
     }

    @Override
    public int getItemCount(){
        return list.size();
    }
}
