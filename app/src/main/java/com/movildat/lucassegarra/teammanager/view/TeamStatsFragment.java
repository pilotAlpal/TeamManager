package com.movildat.lucassegarra.teammanager.view;

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
import com.movildat.lucassegarra.teammanager.model.TeamRecords;
import com.movildat.lucassegarra.teammanager.model.TeamStats;

import java.util.ArrayList;
import java.util.Observable;

/**
 * Created by lucas.segarra on 15/07/2016.
 */
public class TeamStatsFragment extends ViewFragment {

    private TeamStats teamStats;
    private RecyclerView myRV;
    private TextView jugados,ganados,empatados,perdidos,pendientes,pichichi,asistente,maxJugados;
    private ArrayList<Player> teamPartners;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v= inflater.inflate(R.layout.team_stats_view,container,false);
        myRV=(RecyclerView) v.findViewById(R.id.rv_all_players_layout);
        myRV.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager=new LinearLayoutManager(getActivity());
        myRV.setLayoutManager(mLayoutManager);
        teamPartners=myController.getPartners();
        RecyclerView.Adapter adapter=new TeamPlayersAdapter(teamPartners);
        myRV.setAdapter(adapter);
        teamStats=myController.getMyTeamStats();
        ganados=(TextView) v.findViewById(R.id.tv_tsv_ganados);
        String aux=String.valueOf(teamStats.getWon());
        ganados.setText(aux);
        empatados=(TextView)v.findViewById(R.id.tv_tsv_empatados);
        aux=String.valueOf(teamStats.getDrawn());
        empatados.setText(aux);
        perdidos=(TextView) v.findViewById(R.id.tv_tsv_perdidos);
        aux=String.valueOf(teamStats.getLost());
        perdidos.setText(aux);
        pendientes=(TextView) v.findViewById(R.id.tv_tsv_pendientes);
        aux=String.valueOf(teamStats.getPending());
        pendientes.setText(aux);
        jugados=(TextView) v.findViewById(R.id.tv_tsv_jugados);
        aux=String.valueOf(teamStats.getPlayed());
        jugados.setText(aux);
        pichichi=(TextView) v.findViewById(R.id.tv_tsv_pichichi);
        aux=String.valueOf(teamStats.getTopScorer());
        pichichi.setText(aux);
        asistente=(TextView)v.findViewById(R.id.tv_tsv_asistente);
        aux=String.valueOf(teamStats.getTopAsistant());
        asistente.setText(aux);
        return v;
    }

    @Override
    public void update(Observable observable, Object o) {
        return;
    }

    public static TeamStatsFragment newInstance(Controller myController) {
        TeamStatsFragment teamStatsFragment=new TeamStatsFragment();
        teamStatsFragment.setController(myController);
        teamStatsFragment.setStats(myController.getMyTeamStats());
        teamStatsFragment.setMates(myController.getPartners());
        return teamStatsFragment;
    }


    private void setStats(TeamStats s) {
        teamStats = s;
    }
    private void setMates(ArrayList<Player> partners){teamPartners=partners;}

    @Override
    public void invalidCredentials() {

    }

    @Override
    public void repeatedPlayerID() {

    }

    @Override
    public void repeatedTeamName() {

    }

    @Override
    public void teamDoesNotExist() {

    }
}
