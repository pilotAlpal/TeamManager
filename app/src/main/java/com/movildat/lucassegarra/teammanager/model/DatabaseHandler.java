package com.movildat.lucassegarra.teammanager.model;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.icu.util.Freezable;
import android.support.v4.app.Fragment;
import android.text.format.Time;

import com.movildat.lucassegarra.teammanager.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by lucas.segarra on 05/08/2016.
 */
public class DatabaseHandler implements Serializable {

    /**
     * Permite identificar a un usuario
     * @param nombre nombre del usuario
     * @param pass contrasena
     * @return true si se ha identificado correctamente, false si no
     */
    public boolean validLogin(String nombre, String pass) {
        return true;
    }


    public static ArrayList<Events> getEvents(String teamId) {
        ArrayList<Events> a= new ArrayList<>();
        // Resources.getSystem().getStringArray(R.array.eventos);
        a.add(new Events("Leeds",teamId));
        a.add(new Events("Bayern",teamId));
        return a;
    }

    public Player login(String userName, String pass) {
        return new Player(userName,pass,"626992478","mediapunta");
    }

    public void createConvocatory(Convocatory c) {
    }

    public ArrayList<Player> getNextConvocatory(String teamId) {
        return new ArrayList<>();
    }

    public Team lastTeamChosen(String idJugador) {
        String team="Rayo Vaticano";
        Convocatory convocatory=new Convocatory(getNextMatchId(team),team,getNextConvocatory(team));
        Match nextMatch=new Match(getNextRivalId(team),convocatory);
        Agenda agenda=new Agenda(getNextMatches(team),getLastMatches(team),nextMatch,getEvents(team));
        TeamRecords tr=getTeamRecords(team);
        return new Team(team,getTeamPlayers(),getTeamStats(team),agenda,tr);
    }

    public ArrayList<Match> getLastMatches(String team) {
        return new ArrayList<>();
    }
    public ArrayList<Match> getNextMatches(String team){
        return new ArrayList<>();
    }

    public String getNextMatchId(String team) {
        return "Final de la Champions";
    }

    public String getNextRivalId(String team) {
        return "Bayern";
    }

    public ArrayList<String> getTeamPlayers() {
        ArrayList<String> l=new ArrayList<>();
        l.add("Cañizares");
        l.add("Palop");
        l.add("Angloma");
        l.add("Pelegrino");
        l.add("Ayala");
        l.add("Djukic");
        l.add("Carboni");
        l.add("Fabio Aurelio");
        l.add("Albelda");
        l.add("Baraja");
        l.add("Aimar");
        l.add("Angulo");
        l.add("Rufete");
        l.add("Vicente");
        l.add("Killy Gónzalez");
        l.add("Carew");
        l.add("Mista");
        return l;
    }

    public PlayerStats getPlayerStats(String playerId) {
        return new PlayerStats("mediapunta");
    }

    public TeamStats getTeamStats(String teamId) {
        return new TeamStats(100,80,10,10,10);
    }

    public void changePic(String id) {
    }

    public String[] getTeams(String id) {
        String[] ret=new String[2];
        ret[0]="Argentina";
        ret[1]="Valencia";
        return ret;
    }

    public boolean existTeam(String teamName) {
        return true;
    }

    public PlayerStats getTeamPlayerStats(String phone, String id) {
        return new PlayerStats("mediapunta");
    }

    public boolean createPlayer(Player jugador) {
        return true;
    }

    public boolean createTeam(Team equipo) {
        return true;
    }

    public TeamRecords getTeamRecords(String teamName) {
        return new TeamRecords();
    }
}
