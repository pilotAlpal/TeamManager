package com.movildat.lucassegarra.teammanager;

import android.app.Fragment;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;

/**
 * Created by lucas.segarra on 18/07/2016.
 */
public class ClasificStatsFragment extends Fragment {

    private RecyclerView myRv;
    private CardView myCv;
    private final static int EQUIPOS=20;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState){
        View v= inflater.inflate(R.layout.clasification_view,viewGroup, false);
        myCv=(CardView) v.findViewById(R.id.cv_matches);
        myRv=(RecyclerView) v.findViewById(R.id.rv_teams_layout);
        RecyclerView.LayoutManager layoutManager=new GridLayoutManager(getActivity(),EQUIPOS, LinearLayoutManager.HORIZONTAL,false );
        myRv.setHasFixedSize(true);
        myRv.setLayoutManager(layoutManager);
        String[] clasificacion=getResources().getStringArray(R.array.clasificacion_mitica);
        RecyclerView.Adapter adapter=new ClasificationAdapter(clasificacion);
        myRv.setAdapter(adapter);
        return v;
    }
}
