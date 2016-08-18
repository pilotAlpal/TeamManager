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


    public static String[] getEvents(int eventsShown) {
        String a[]= new String[2];
        // Resources.getSystem().getStringArray(R.array.eventos);
        a[0]="Leeds";
        a[1]="Bayern";
        return a;
    }

    public Player login(String userName, String pass) {
        return new Player(userName,pass,"626992478","mediapunta");
    }

    public void createConvocatory(Convocatory c) {
    }

    public ArrayList<String> getNextConvocatory() {
        return new ArrayList<String>();
    }

    public Team lastTeamChosen(String idJugador) {
        String team="Rayo Vaticano";
        return new Team(team,getTeamPlayers(),getTeamStats(team));
    }

    private ArrayList<String> getTeamPlayers() {
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
        return new TeamStats(100,80,10,10,10,"Mista","Vicente");
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
}
