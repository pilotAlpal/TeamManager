package com.movildat.lucassegarra.teammanager.model;

import android.media.Image;

import java.io.Serializable;

/**
 * Created by Propietario on 16/08/2016.
 */
public class PlayerStats implements Serializable {

    private float sumaValoraciones;
    private int goles,asistencias,expulsiones,patidos,valoraciones;
    private String posicion,dorsal;

    public PlayerStats(String pPos) {
        posicion=pPos;valoraciones=0;
        sumaValoraciones=0;asistencias=0;
        goles=0;expulsiones=0;
        patidos=0;valoraciones=0;
    }

    public PlayerStats(float total,int cuantos,int gols,int asis,int exps,int prtds,String pos,String number){
        sumaValoraciones=total;
        valoraciones=cuantos;
        goles=gols;
        asistencias=asis;
        expulsiones=exps;
        patidos=prtds;
        posicion=pos;
        dorsal=number;
    }

    public float getRating(){
        return sumaValoraciones/valoraciones;
    }

    public String getPos(){
        return posicion;
    }

    public void setPos(String s){
        posicion=s;
    }

    public int getGols(){
        return goles;
    }

    public int getAsistances(){return asistencias;}

    public int getExpulsiones(){return expulsiones;}

    public int countMatches(){return patidos;}

    public void getRated(int rating){
        if ((rating>=0)&&(rating<=5)){
            valoraciones++;
            sumaValoraciones+=rating;
        }
    }

    public void addGols(int gols){
        goles+=gols;
    }

    public void addMatches(int matches){
        patidos+=matches;
    }

    public void addAsists(int asists){
        asistencias+=asists;
    }

    public void addExpulsions(int expuls){
        expulsiones+=expuls;
    }

    public void changeNumber(String number) {
        dorsal=number;
    }
}
