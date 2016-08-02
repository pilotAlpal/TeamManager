package com.movildat.lucassegarra.teammanager;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by lucas.segarra on 02/08/2016.
 */
public class ClasificationAdapter extends RecyclerView.Adapter<ClasificationAdapter.ViewHolder> {
    private String[][] clasif;
    private static final int NUM_EQUIPOS=20;
    private static final int NUM_COLUMNAS=8;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView tvName;

        public ViewHolder(View v){
            super(v);
            tvName=(TextView)v.findViewById(R.id.tv_nom_equi_ci);
        }
    }

    public ClasificationAdapter(String[][] data){
        if (data!=null)
            clasif=data;
    }

    public ClasificationAdapter(String[] s){
        clasif=new String[s.length][NUM_COLUMNAS];
        for (int i=0;i<s.length;i++)
            clasif[i][0]=s[i];
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.clasification_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder vH,int pos){
        //utilizar pos para ver clasificación de cada equipo
        vH.tvName.setText(clasif[pos][0]);
    }

    @Override
    public int getItemCount(){
        return clasif.length;
    }
}
