package com.movildat.lucassegarra.teammanager.model;

import com.movildat.lucassegarra.teammanager.controler.Controller;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by lucas.segarra on 05/08/2016.
 */
public class Convocatory implements Serializable {
    private String id_partido;
    private String id_equipo;
    private ArrayList<Player> convocados;

    public Convocatory(String partido, String equipo){
        id_partido=partido;
        id_equipo=equipo;
        convocados=new ArrayList<Player>();
    }
    public Convocatory(String partido, String equipo,ArrayList<Player> jugadores){
        id_partido=partido;
        id_equipo=equipo;
        convocados=jugadores;
    }

    public Convocatory(String id) {
        id_equipo=id;
        id_partido="no hay partidos";
        convocados=new ArrayList<>();
    }

    public void convoca(Player player){
        convocados.add(player);
    }
    public void desconvoca(Player player){
        convocados.remove(player);
    }
    public String getMatchId(){return id_partido;}
    public String getTeamId(){return id_equipo;}
    public int getCount(){return  convocados.size();}
}
