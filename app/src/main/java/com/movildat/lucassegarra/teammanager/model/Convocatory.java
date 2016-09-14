package com.movildat.lucassegarra.teammanager.model;

import com.movildat.lucassegarra.teammanager.controler.Controller;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by lucas.segarra on 05/08/2016.
 */
public class Convocatory implements Serializable {
    private String id_equipo;
    private ArrayList<Player> convocados;

    public Convocatory(String equipo){
        id_equipo=equipo;
        convocados=new ArrayList<Player>();
    }
    public Convocatory(String equipo,ArrayList<Player> jugadores){
        id_equipo=equipo;
        convocados=jugadores;
    }



    public void addTo(Player player){
        convocados.add(player);
    }
    public void removeFrom(Player player){
        convocados.remove(player);
    }
    public String getTeamId(){return id_equipo;}
    public int getCount(){return  convocados.size();}
}
