package com.movildat.lucassegarra.teammanager.model;

import java.io.Serializable;

/**
 * Created by Propietario on 16/08/2016.
 */
public class TeamStats implements Serializable {
    private int jugados,ganados,empatados,perdidos,pendientes;
    private TeamRecords recordsEquipo;

    public TeamStats(int j,int g,int e,int p,int pend,TeamRecords recE){
        jugados=j;
        ganados=g;
        empatados=e;
        perdidos=p;
        pendientes=pend;
        recordsEquipo=recE;
    }
    public TeamStats(){
        jugados=0;
        pendientes=0;
        perdidos=0;
        ganados=0;
        empatados=0;
        recordsEquipo=new TeamRecords();
    }

    public int getPlayed(){
        return jugados;
    }

    public int getWon(){
        return ganados;
    }

    public int getDrawn(){
        return empatados;
    }

    public int getLost(){
        return perdidos;
    }

    public int getPending(){
        return pendientes;
    }

    public TeamRecords getRecords() {
        return recordsEquipo;
    }

    public String getTopAsistant() {
       return recordsEquipo.getTopAsistant();
    }

    public String getTopScorer() {
        return recordsEquipo.getTopScorer();
    }
}
