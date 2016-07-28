package com.movildat.lucassegarra.teammanager;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by lucas.segarra on 28/07/2016.
 */
public class CalendarListAdapter extends RecyclerView.Adapter<CalendarListAdapter.ViewHolder> {
    private String[] myEvents;

    CalendarListAdapter(String[] data){
        if(data!=null)
            myEvents=data;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView mTextView;
        public ViewHolder(TextView textView){
            super(textView);
            mTextView=textView;
        }
        public ViewHolder(View v){
            super(v);
            mTextView=(TextView) v.findViewById(R.id.tv_fecha);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.listed_event,parent,false);
        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder,int pos){
        holder.mTextView.setText(myEvents[pos]);
    }

    @Override
    public int getItemCount(){
        return myEvents.length;
    }
}
