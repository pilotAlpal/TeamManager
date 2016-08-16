package com.movildat.lucassegarra.teammanager.model;

import android.app.Activity;
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

    public Team lastTeamChosen(String nombre) {
        return new Team("Rayo Vaticano");
    }

    public PlayerStats getPlayerStats(String s) {
        return new PlayerStats();
    }
}
