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

/**
 * Created by lucas.segarra on 19/07/2016.
 */
public class PlayersListAdapter extends RecyclerView.Adapter<PlayersListAdapter.ViewHolder> {
    private String[] mDataSet;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView mTextView;
        public ImageButton butt;

        public ViewHolder(View v){
            super(v);
            mTextView=(TextView)v.findViewById(R.id.tv_next_player);
            butt=(ImageButton)v.findViewById(R.id.call_but);
        }
        public void listenCallButton(final Context context){
            butt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //hacerse con el número asociado mTextView.getText
                    String numero="626992478";
                    Intent callIntent=new Intent(Intent.ACTION_DIAL);
                    callIntent.setData(Uri.parse("tel:"+numero));
                    if (callIntent.resolveActivity(context.getPackageManager())!=null){
                        context.startActivity(callIntent);
                    }
                }
            });
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
        ViewHolder vH=new ViewHolder(v);
        vH.listenCallButton(parent.getContext());
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