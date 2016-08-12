package com.movildat.lucassegarra.teammanager.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.movildat.lucassegarra.teammanager.R;

import java.util.ArrayList;

/**
 * Created by lucas.segarra on 02/08/2016.
 */
public class TeamPlayersAdapter extends RecyclerView.Adapter<TeamPlayersAdapter.ViewHolder> {
    private ArrayList<String> list;

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
        list=new ArrayList<String>();
        if(data!=null)
            for (int i=0;i<data.length;i++)
                list.add(i,data[i]);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.team_mates_item,parent,false);
        return new ViewHolder(v);
    }
     @Override
    public void onBindViewHolder(ViewHolder vH,int pos){
        vH.name.setText(list.get(pos));
         //cargar imagenes
     }

    @Override
    public int getItemCount(){
        return list.size();
    }
}
