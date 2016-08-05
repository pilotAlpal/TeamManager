package com.movildat.lucassegarra.teammanager.model;

import java.util.ArrayList;

/**
 * Created by lucas.segarra on 05/08/2016.
 */
public class Team {
    private String myId;
    private String name;
    private ArrayList<String> players;

    public Team(String id,String teamName){
        myId=id;
        name=teamName;
        players=new ArrayList<String>();
    }
    public void aniadePlayer(String playerId){
        players.add(playerId);
    }
    public void removePlayer(String playerId){
        players.remove(playerId);
    }
    public String getId(){return myId;}
    public String getName(){return name;}
    public int getCount(){return players.size();}
}
