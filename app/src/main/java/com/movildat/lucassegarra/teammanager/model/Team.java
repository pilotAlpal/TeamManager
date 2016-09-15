package com.movildat.lucassegarra.teammanager.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by lucas.segarra on 05/08/2016.
 */
public class Team implements Serializable{
    private String myId;
    private ArrayList<Player> players;
    private TeamStats myTeamStats;
    private Agenda agenda;

    public Team(String myTeamid,ArrayList<Player> myTeamPlayers,TeamStats ts,Agenda ag){
        myId=myTeamid;
        players= myTeamPlayers;
        myTeamStats=ts;
        agenda=ag;
    }

    public void addEvent(Events e){
        agenda.addEvent(e);
    }

    public void addMatch(Match m){
        agenda.addMatch(m);
    }

    public void addPlayer(Player player){
        players.add(player);
    }

    public void removePlayer(String playerId){
        players.remove(playerId);
    }

    public int getPlayersCount(){return players.size();}

    public String getTeamId() {
        return myId;
    }

    public ArrayList<Player> getPlayersList() {
        return players;
    }

    public TeamStats getTeamStats() {
        return myTeamStats;
    }

    public TeamRecords getTeamRecords() {
        return myTeamStats.getRecords();
    }

    public void addToNextMatch(Player j) {
        agenda.addToNextMatch(j);
    }

    public void removeFromNextMatch(Player j) {
        agenda.removeFromNextMatch(j);
    }

    public ArrayList<Match> getNextMatches() {
        return agenda.getNextMatches();
    }

    public ArrayList<Player> getNextConvocatory() {
        return agenda.getNextMatch().getConvocatory().getPlayers();
    }

    public ArrayList<Match> getLastMatches() {
        return agenda.getNextMatches();
    }

    public ArrayList<Events> getEvents() {
        return agenda.getTeamEvents();
    }

    public Player getPlayer(String playerPhone) {
        Player player=null;
        for (Player p :players){
            if(p.getPhone().equalsIgnoreCase(playerPhone))
                player=p;
        }
        return player;
    }
}
