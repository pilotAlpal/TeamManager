package com.movildat.lucassegarra.teammanager.model;

import com.movildat.lucassegarra.teammanager.controler.Controller;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by lucas.segarra on 05/08/2016.
 */
public class Team implements Serializable{
    private String myId;
    private ArrayList<String> players;
    private TeamStats myTeamStats;
    private ArrayList<Match> proximosPartidos,ultimosPartidos;
    private Convocatory proxConcocatoria;
    private ArrayList<Events> teamEvents;


    public Team(String id,ArrayList<String> tPlayers,TeamStats ts,ArrayList<Player> nextConvocated){
        myId=id;
        players= tPlayers;
        myTeamStats=ts;
        //inicializar partidos,inicializar convocatoria,inicializar eventos
    }
    public Team(String tName,ArrayList<String> tPlayers){
        myId=tName;
        players=tPlayers;
        myTeamStats=new TeamStats();
        //inicializar partidos,inicializar convocatoria,inicializar eventos
    }

    public Team(TeamStats teamStats) {
    }

    public void aniadePlayer(String playerId){
        players.add(playerId);
    }
    public void removePlayer(String playerId){
        players.remove(playerId);
    }
    public String getId(){return myId;}
    public int getCount(){return players.size();}

    public String getTeamId() {
        return myId;
    }

    public ArrayList<String> getPlayersList() {
        return players;
    }
}
