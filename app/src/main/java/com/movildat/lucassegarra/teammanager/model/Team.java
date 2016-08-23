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
    private ArrayList<Match> listaProximos, listaUltimos;
    private Match proxPartido;
    private ArrayList<Events> teamEvents;
    private HashMap<String,PlayerStats> playerStats;

//equipo ya existente
    public Team(String myTeamid,ArrayList<String> myTeamPlayers,TeamStats ts,Convocatory nextConvocated,String nextRivalId,
                ArrayList<Events> eventos,ArrayList<Match> ultimos,ArrayList<Match> proximos){
        myId=myTeamid;
        players= myTeamPlayers;
        myTeamStats=ts;
        proxPartido=new Match(nextRivalId,nextConvocated);
        teamEvents=eventos;
        listaProximos=proximos;
        listaUltimos =ultimos;
    }
    //equipo recien creado
    public Team(String tName,ArrayList<String> tPlayers){
        myId=tName;
        players=tPlayers;
        myTeamStats=new TeamStats();
        proxPartido=new Match();
        teamEvents=new ArrayList<>();
        listaProximos=new ArrayList<>();
        listaUltimos =new ArrayList<>();
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

    public TeamStats getTeamStats(String teamId) {
        return myTeamStats;
    }
}
