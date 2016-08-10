package com.movildat.lucassegarra.teammanager.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.movildat.lucassegarra.teammanager.R;

import java.util.ArrayList;

/**
 * Created by lucas.segarra on 28/07/2016.
 */
public class CalendarListAdapter extends RecyclerView.Adapter<CalendarListAdapter.ViewHolder> {
    private ArrayList<String> myEvents;

    CalendarListAdapter(String[] data){
        if(data!=null)
            myEvents=new ArrayList<String>();
            for (int i=0;i<data.length;i++){
                myEvents.add(i,data[i]);
            }
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
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.event_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder,int pos){
        holder.mTextView.setText(myEvents.get(pos));
    }

    @Override
    public int getItemCount(){
        return myEvents.size();
    }
}
