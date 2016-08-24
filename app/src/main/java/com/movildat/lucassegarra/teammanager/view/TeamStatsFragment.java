package com.movildat.lucassegarra.teammanager.view;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.movildat.lucassegarra.teammanager.R;
import com.movildat.lucassegarra.teammanager.controler.Controller;
import com.movildat.lucassegarra.teammanager.model.Player;
import com.movildat.lucassegarra.teammanager.model.Sesion;
import com.movildat.lucassegarra.teammanager.model.TeamStats;
import com.movildat.lucassegarra.teammanager.model.ViewFragment;

import java.util.ArrayList;
import java.util.Observable;

/**
 * Created by lucas.segarra on 15/07/2016.
 */
public class TeamStatsFragment extends ViewFragment {

    private TeamStats teamStats;
    private RecyclerView myRV;
    private TextView jugados,ganados,empatados,perdidos,pendientes,pichichi,asistente;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v= inflater.inflate(R.layout.team_stats_view,container,false);
        myRV=(RecyclerView) v.findViewById(R.id.rv_all_players_layout);
        myRV.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager=new LinearLayoutManager(getActivity());
        myRV.setLayoutManager(mLayoutManager);
        teamStats=myController.getMyTeamStats();
        ArrayList<String> teamMates=myController.getPartners();
        //pasarle teamMates al adapter
        //cargar teamStats en los textViews
        //cargar y pasar rating de cada jugador al adapter,aparecerá en la vista del item
        jugados=(TextView) v.findViewById(R.id.tv_tsv_jugados);
        ganados=(TextView) v.findViewById(R.id.tv_tsv_ganados);
        empatados=(TextView)v.findViewById(R.id.tv_tsv_empatados);
        perdidos=(TextView) v.findViewById(R.id.tv_tsv_perdidos);
        pendientes=(TextView) v.findViewById(R.id.tv_tsv_pendientes);
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

    public static TeamStatsFragment newInstance(Controller myController,TeamStats ts) {
        TeamStatsFragment teamStatsFragment=new TeamStatsFragment();
        teamStatsFragment.setController(myController);
        teamStatsFragment.setStats(ts);
        return teamStatsFragment;
    }

    private void setStats(TeamStats s) {
        teamStats = s;
    }
}
