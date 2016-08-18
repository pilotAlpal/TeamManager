package com.movildat.lucassegarra.teammanager.model;

import java.sql.Time;

import java.util.ArrayList;
import java.util.Date;


/**
 * Created by lucas.segarra on 05/08/2016.
 */
public class Match {
    private String id;
    private String homeId,guestId;
    private Date when;
    private Time t;
    private Result resultado;
    private ArrayList<Gol> goles;


    public Match(String teamId, String idRival,boolean local, Date f, Time h) {
        homeId=teamId;
        guestId=idRival;
        when=f;
        t=h;
        resultado=new Result();
        goles=new ArrayList<>();
    }
}
