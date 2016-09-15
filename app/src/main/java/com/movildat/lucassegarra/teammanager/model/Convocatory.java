package com.movildat.lucassegarra.teammanager.model;


import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by lucas.segarra on 05/08/2016.
 */
public class Convocatory implements Serializable {
    private ArrayList<Player> convocados;

    public Convocatory(){
        convocados=new ArrayList<Player>();
    }
    public Convocatory(ArrayList<Player> jugadores){
        convocados=jugadores;
    }

    public void addTo(Player player){
        convocados.add(player);
    }
    public void removeFrom(Player player){
        convocados.remove(player);
    }
    public int getCount(){return  convocados.size();}
    public ArrayList<Player> getPlayers(){
        return convocados;
    }
}
