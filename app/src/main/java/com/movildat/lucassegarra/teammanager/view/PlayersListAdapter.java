package com.movildat.lucassegarra.teammanager.view;


import android.content.Context;
import android.content.Intent;

import android.net.Uri;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageButton;
import android.widget.TextView;

import com.movildat.lucassegarra.teammanager.R;
import com.movildat.lucassegarra.teammanager.model.Player;

import java.util.ArrayList;

/**
 * Created by lucas.segarra on 19/07/2016.
 */
public class PlayersListAdapter extends RecyclerView.Adapter<PlayersListAdapter.ViewHolder> {
    private ArrayList<Player> mDataSet;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView mTextView;
        public ImageButton butt;
        private String number="626992478";

        public ViewHolder(View v){
            super(v);
            mTextView=(TextView)v.findViewById(R.id.tv_next_player);
            butt=(ImageButton)v.findViewById(R.id.call_but);
        }
        public void listenCallButton(final Context context){
            butt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent callIntent=new Intent(Intent.ACTION_DIAL);
                    callIntent.setData(Uri.parse("tel:"+number));
                    if (callIntent.resolveActivity(context.getPackageManager())!=null){
                        context.startActivity(callIntent);
                    }
                }
            });
        }
    }


    public PlayersListAdapter(ArrayList<Player> data){
        if(data!=null)
            mDataSet=data;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.next_match_availables_item,parent,false);
        ViewHolder vH=new ViewHolder(v);
        vH.listenCallButton(parent.getContext());
      return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder,int pos){
        holder.mTextView.setText(mDataSet.get(pos).getNombre());
        holder.number=mDataSet.get(pos).getPhone();
    }

    @Override
    public int getItemCount(){
        return mDataSet.size();
    }

}