package com.movildat.lucassegarra.teammanager.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.movildat.lucassegarra.teammanager.R;
import com.movildat.lucassegarra.teammanager.model.Events;

import java.util.ArrayList;

/**
 * Created by lucas.segarra on 28/07/2016.
 */
public class CalendarListAdapter extends RecyclerView.Adapter<CalendarListAdapter.ViewHolder> {
    private ArrayList<Events> myEvents;

    CalendarListAdapter(ArrayList<Events> data){
        if(data!=null)
            myEvents=data;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView tvFecha,tvRivNam;
        public ViewHolder(TextView textView){
            super(textView);
            tvFecha =textView;
        }
        public ViewHolder(View v){
            super(v);
            tvFecha =(TextView) v.findViewById(R.id.tv_fecha);
            tvRivNam=(TextView)v.findViewById(R.id.tv_nom_rival);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.event_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder,int pos){
        holder.tvRivNam.setText(myEvents.get(pos).getId());
        String date=String.valueOf(myEvents.get(pos).getEventDate());
        holder.tvFecha.setText(date);
    }

    @Override
    public int getItemCount(){
        return myEvents.size();
    }
}
