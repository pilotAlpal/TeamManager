package com.movildat.lucassegarra.teammanager.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by lucas.segarra on 05/08/2016.
 */
public class Team implements Serializable{
    private String myId;
    private ArrayList<String> players;
    private TeamStats myTeamStats;
    private Agenda agenda;
    private TeamRecords records;



    public Team(String myTeamid,ArrayList<String> myTeamPlayers,TeamStats ts,Agenda ag,TeamRecords tr){
        myId=myTeamid;
        players= myTeamPlayers;
        myTeamStats=ts;
        agenda=ag;
        records=tr;
    }

    public void addEvent(Events e){
        agenda.addEvent(e);
    }

    public void addMatch(Match m){
        agenda.addMatch(m);
    }

    public void addPlayer(String playerId){
        players.add(playerId);
    }

    public void removePlayer(String playerId){
        players.remove(playerId);
    }

    public int getCount(){return players.size();}

    public String getTeamId() {
        return myId;
    }

    public ArrayList<String> getPlayersList() {
        return players;
    }

    public TeamStats getTeamStats(String teamId) {
        return myTeamStats;
    }
}
