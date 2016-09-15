package com.movildat.lucassegarra.teammanager.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.movildat.lucassegarra.teammanager.R;
import com.movildat.lucassegarra.teammanager.controler.Controller;
import com.movildat.lucassegarra.teammanager.model.PlayerStats;

import java.util.Observable;

/**
 * Created by lucas.segarra on 15/07/2016.
 */
public class PlayerStatsFragment extends ViewFragment {

    private PlayerStats playerStats;
    private EditProfileFragment editProfileFragment;
    private TextView nombre,equipo,pos,dorsal,goles,pases,expulsiones,partidos;

    @Override public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.player_stats_view,container,false);
        View v2=v.findViewById(R.id.psl_psv);
        editProfileFragment=(EditProfileFragment) this.getChildFragmentManager().findFragmentById(R.id.edit_prof_fragment);
        editProfileFragment.setController(myController);
        editProfileFragment.setTeamAdapter();
        nombre=(TextView) v2.findViewById(R.id.tNombre);
        pos=(TextView) v2.findViewById(R.id.tv_pos);
        dorsal=(TextView) v2.findViewById(R.id.tDorsal);
        goles=(TextView)v2.findViewById(R.id.tv_goles);
        pases=(TextView)v2.findViewById(R.id.tv_asistencias);
        expulsiones=(TextView)v2.findViewById(R.id.tv_expulsiones);
        partidos=(TextView)v2.findViewById(R.id.tv_jugados);
        nombre.setText(myController.getMyPlayerId());
        pos.setText(playerStats.getPos());
        String aux= String.valueOf(playerStats.getGols());
        goles.setText(aux);
        aux=String.valueOf(playerStats.getAsistances());
        pases.setText(aux);
        aux=String.valueOf(playerStats.getExpulsiones());
        expulsiones.setText(aux);
        aux=String.valueOf(playerStats.countMatches());
        partidos.setText(aux);
        return v;
    }
    public static PlayerStatsFragment newInstance(Controller c) {
        PlayerStatsFragment pSf=new PlayerStatsFragment();
        pSf.setController(c);
        pSf.setPlayerStats(c.getMyplayerStats());
        return pSf;
    }

    private void setPlayerStats(PlayerStats pStats) {
        playerStats=pStats;
    }

    @Override
    public void update(Observable observable, Object o) {
    }

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