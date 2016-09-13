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

    public boolean validLogin(String telefono, String pass) {
        return true;
    }


    public static ArrayList<Events> getEvents(String teamId) {
        ArrayList<Events> a= new ArrayList<>();
        // Resources.getSystem().getStringArray(R.array.eventos);
        a.add(new Events("Tirol",teamId));
        a.add(new Events("Olimpique",teamId));
        a.add(new Events("Heerenveen",teamId));
        a.add(new Events("Olimpiakos",teamId));
        a.add(new Events("Manchester",teamId));
        a.add(new Events("Stum Graz",teamId));
        a.add(new Events("Panathinaikos",teamId));
        a.add(new Events("Arsenal",teamId));
        a.add(new Events("Leeds",teamId));
        a.add(new Events("Bayern",teamId));
        return a;
    }

    public Player login(String telf, String pass) {
        return new Player("Lucas",pass,telf,"mediapunta");
    }

    public void createConvocatory(Convocatory c) {
    }

    public ArrayList<Player> getNextConvocatory(String teamId) {
        ArrayList<Player> convocatoria=new ArrayList<>();
        convocatoria.add(new Player("Cañizares","a","626992478","Portero"));
        convocatoria.add(new Player("Angloma","a","626992478","Lateral"));
        convocatoria.add(new Player("Ayala","a","626992478","Central"));
        convocatoria.add(new Player("Pelegrino","a","626992478","Central"));
        convocatoria.add(new Player("Carboni","a","626992478","Lateral"));
        convocatoria.add(new Player("Mendieta","a","626992478","Centrocampista"));
        convocatoria.add(new Player("Baraja","a","626992478","Centrocampista"));
        convocatoria.add(new Player("Aimar","a","626992478","Mediapunta"));
        convocatoria.add(new Player("Killy Gónzalez","a","628665088","Extremo"));
        convocatoria.add(new Player("Angulo","a","626992478","Extremo"));
        convocatoria.add(new Player("Carew","a","626992478","Delantero"));
        convocatoria.add(new Player("Vicente","a","628665088","Extremo"));
        convocatoria.add(new Player("Juan Sánchez","a","626992478","Delantero"));
        convocatoria.add(new Player("Albelda","a","626992478","Centrocampista"));
        convocatoria.add(new Player("Djukic","a","626992478","Central"));
        return convocatoria;
    }

    public Team lastTeamChosen(String idJugador) {
        String team="Rayo Vaticano";
        Convocatory convocatory=new Convocatory(getNextMatchId(team),team,getNextConvocatory(team));
        Match nextMatch=new Match(getNextRivalId(team),convocatory);
        Agenda agenda=new Agenda(getNextMatches(team),getLastMatches(team),nextMatch,getEvents(team));
        TeamRecords tr=getTeamRecords(team);
        return new Team(team,getTeamPlayers(team),getTeamStats(team),agenda,tr);
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

    public ArrayList<Player> getTeamPlayers(String team) {
        ArrayList<Player> l=getNextConvocatory(team);
        l.add(new Player("Palop","a","626992478","Portero"));
        l.add(new Player("Marchena","a","626992478","Central"));
        l.add(new Player("Farinós","a","626992478","Centrocampista"));
        l.add(new Player("Fabio Aurelio","a","626992478","Lateral"));
        l.add(new Player("Rufete","a","626992478","Extremo"));
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

    public Player createPlayer(String n,String pss,String ph,String pos) {
        return new Player(n,pss,ph,pos);
    }

    public Team createTeam(String equipo, ArrayList<Player> players, TeamStats ts, Agenda agenda, TeamRecords recordEquipo) {
        return new Team(equipo,players,ts,agenda,recordEquipo);
    }

    public TeamRecords getTeamRecords(String teamName) {
        return new TeamRecords();
    }

    public boolean existPlayer(String playerPhone) {
        return false;
    }

    public Player getPlayer(String playerPhone) {
        return new Player("Aimar","a","626992478","Mediapunta");
    }

    public boolean createMatch(String miTeamId, String nRival, Date f, String h) {
        return true;
    }

    public boolean linkTeamAndPlayer(String pTel, String team) {
        return true;
    }

    public void changePlayerPos(String phone, String position) {
    }

    public Team getTeam(String equipo) {
        return new Team(equipo,new ArrayList<Player>(),new TeamStats(),
                new Agenda(new ArrayList<Match>(),new ArrayList<Match>(),new Match("Bayern",new Convocatory("1",equipo)),new ArrayList<Events>())
                ,new TeamRecords());
    }

    public void deleteProfile(Player jugador) {
    }

    public Player invitePlayer(String phone) {
        return new Player("Pablo","asasas",phone,"MediaPunta");
    }
}
