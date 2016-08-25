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
    private String topScorer="Carew",topAsistant="Aimar",topPlayed;

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
