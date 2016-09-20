package com.movildat.lucassegarra.teammanager.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by lucas.segarra on 05/08/2016.
 */
public class Leage implements Serializable {
    private String myId;
    private ArrayList<String> teams;

    public Leage(String id){
        myId=id;
        teams=new ArrayList<String>();
    }
    public void addTeam(String teamId){
        teams.add(teamId);
    }
    public void removeTeam(String teamId){
        teams.remove(teamId);
    }
}
