package com.movildat.lucassegarra.teammanager.model;

import com.movildat.lucassegarra.teammanager.controler.Controller;

import java.util.ArrayList;

/**
 * Created by lucas.segarra on 05/08/2016.
 */
public class Convocatory {
    private String id_partido;
    private String id_equipo;
    private String id_convocatory;
    private ArrayList<String > convocados;

    public Convocatory(String partido, String equipo){
        id_convocatory= DatabaseHandler.getNextConvocatoryId();
        id_partido=partido;
        id_equipo=equipo;
        convocados=new ArrayList<String>();
    }
    public void convoca(String id_player){
        convocados.add(id_player);
    }
    public void desconvoca(String id_player){
        convocados.remove(id_player);
    }
    public String getMatchId(){return id_partido;}
    public String getTeamId(){return id_equipo;}
    public int getCount(){return  convocados.size();}
}
