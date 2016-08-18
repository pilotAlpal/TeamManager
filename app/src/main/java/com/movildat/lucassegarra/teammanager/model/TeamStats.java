package com.movildat.lucassegarra.teammanager.model;

import java.io.Serializable;

/**
 * Created by Propietario on 16/08/2016.
 */
public class TeamStats implements Serializable {
    private int jugados,ganados,empatados,perdidos,pendientes;
    private String maxGoleador,maxAsistente;

    public TeamStats(int j,int g,int e,int p,int pend,String pichichi,String asistente){
        jugados=j;
        ganados=g;
        perdidos=p;
        pendientes=pend;
        maxAsistente=asistente;
        maxGoleador=pichichi;
    }
    public TeamStats(){
        jugados=0;
        pendientes=0;
        perdidos=0;
        ganados=0;
        empatados=0;
        maxGoleador="nadie";
        maxAsistente="nadie";
    }
}
