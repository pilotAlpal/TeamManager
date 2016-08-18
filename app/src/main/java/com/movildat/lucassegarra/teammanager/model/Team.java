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


    public Team(String id,ArrayList<String> tPlayers,TeamStats ts){
        myId=id;
        players= tPlayers;
        myTeamStats=ts;
    }
    public Team(String tName,ArrayList<String> tPlayers){
        myId=tName;
        players=tPlayers;
        myTeamStats=new TeamStats();
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
