package com.movildat.lucassegarra.teammanager.view;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.movildat.lucassegarra.teammanager.R;
import com.movildat.lucassegarra.teammanager.controler.Controller;
import com.movildat.lucassegarra.teammanager.model.Sesion;

import java.util.Observable;

/**
 * Created by lucas.segarra on 15/07/2016.
 */
public class TeamStatsFragment extends Fragment implements Sesion.Observador{

    private RecyclerView myRV;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v= inflater.inflate(R.layout.team_stats_view,container,false);
        myRV=(RecyclerView) v.findViewById(R.id.rv_all_players_layout);
        myRV.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager=new LinearLayoutManager(getActivity());
        myRV.setLayoutManager(mLayoutManager);
        //cargar estadisticas del equipo
        //cargar jugadores de mi equipo y pasarselos al adapter
        String[] titulares=getResources().getStringArray(R.array.equipo_fantasma);
        String[] suplentes=getResources().getStringArray(R.array.equipo_fantasma_suplentes);
        String[] todos=new String[titulares.length+suplentes.length];
        for (int i=0;i<titulares.length;i++)
            todos[i]=titulares[i];
        for(int k=titulares.length;k<todos.length;k++)
            todos[k]=suplentes[k-titulares.length];
        RecyclerView.Adapter adapter=new TeamPlayersAdapter(todos);
        myRV.setAdapter(adapter);
        return v;
    }

    @Override
    public void update(Observable observable, Object o) {
        return;
    }

    @Override
    public void setController(Controller controller) {

    }
}
