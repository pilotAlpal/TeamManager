package com.movildat.lucassegarra.teammanager.model;

import android.text.format.Time;

import com.movildat.lucassegarra.teammanager.controler.Controller;

import java.util.Date;


/**
 * Created by lucas.segarra on 05/08/2016.
 */
public class Match {
    private String id;
    private String tournament;//leage
    private String homeId,guestId;
    private Date when;
    private Time t;
    private int homeG,guestG;

    public Match(String tournamentId,String home_id,String guest_id,Date w,int home_goals,int guest_goals){
        when=w;
        homeG=home_goals;
        guestG=guest_goals;
    }

    public Match(String teamId, String idRival, Date f, Time h) {
        homeId=teamId;
        guestId=idRival;
        when=f;
        t=h;
    }
}
