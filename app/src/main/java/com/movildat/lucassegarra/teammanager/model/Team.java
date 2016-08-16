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

    public Team(String id){
        myId=id;
        players=new ArrayList<String>();
    }
    public Team(String tName,ArrayList<String> tPlayers){
        myId=tName;
        if (tPlayers!=null)
            players=tPlayers;
        else
            players=new ArrayList<String>();
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
