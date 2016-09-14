package com.movildat.lucassegarra.teammanager.model;

import java.io.Serializable;
import java.sql.Time;

import java.util.ArrayList;
import java.util.Date;


/**
 * Created by lucas.segarra on 05/08/2016.
 */
public class Match implements Serializable {
    private String id;
    private String homeId,guestId;
    private Date when;
    private Time t;
    private Result resultado;
    private ArrayList<Gol> goles;
    private Convocatory convocados;

    public Match(){};

    public Match(String rival,Convocatory nc) {
        convocados=nc;
        guestId=rival;
        homeId=convocados.getTeamId();
        resultado=new Result();
        goles=new ArrayList<>();
    }
    public void addToConvocatory(Player p){
        convocados.addTo(p);
    }
    public void removeFromConvocatory(Player p){
        convocados.removeFrom(p);
    }
}