package com.movildat.lucassegarra.teammanager.model;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by Propietario on 24/08/2016.
 */
public class TeamRecords implements Serializable {
    private HashMap<String,Integer> goleadores;
    private HashMap<String,Integer> asistentes;
    private HashMap<String,Integer> partJugados;
    private String topScorer,topAsistant,topPlayed;

    public TeamRecords(HashMap<String,Integer>gs,HashMap<String,Integer>pas,HashMap<String,Integer>parts,
                       String pi,String pasador,String veterano){
        goleadores=gs;
        asistentes=pas;
        partJugados=parts;
        topScorer=pi;
        topAsistant=pasador;
        topPlayed=veterano;
    }

    public TeamRecords(){
        goleadores=new HashMap<>();
        asistentes=new HashMap<>();
        partJugados=new HashMap<>();
        topScorer="Carew";
        topAsistant="Aimar";
    }

    public String getTopScorer(){
        return topScorer;
    }

    public String getTopAsistant() {
        return topAsistant;
    }

    public String getTopPlayed() {
        return topPlayed;
    }
}
