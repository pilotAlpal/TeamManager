package com.movildat.lucassegarra.teammanager.model;

import java.io.Serializable;

/**
 * Created by Propietario on 16/08/2016.
 */
public class TeamStats implements Serializable {
    private int jugados,ganados,empatados,perdidos,pendientes;

    public TeamStats(int j,int g,int e,int p,int pend){
        jugados=j;
        ganados=g;
        perdidos=p;
        pendientes=pend;

    }
    public TeamStats(){
        jugados=0;
        pendientes=0;
        perdidos=0;
        ganados=0;
        empatados=0;
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

}
