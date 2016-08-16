package com.movildat.lucassegarra.teammanager.controler;
import android.text.format.Time;
import com.movildat.lucassegarra.teammanager.model.Convocatory;
import com.movildat.lucassegarra.teammanager.model.DatabaseHandler;
import com.movildat.lucassegarra.teammanager.model.Match;
import com.movildat.lucassegarra.teammanager.model.Player;
import com.movildat.lucassegarra.teammanager.model.PlayerStats;
import com.movildat.lucassegarra.teammanager.model.Sesion;
import com.movildat.lucassegarra.teammanager.model.Team;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by lucas.segarra on 05/08/2016.
 */
public class Controller implements Serializable{

    private Sesion mySesion;

    public Controller(Sesion s){
        mySesion=s;
    }

    public Controller() {
        mySesion=new Sesion();
    }

    public  void createTeam(String teamName, ArrayList<String> initPlayers){
        Team equipo=new Team(teamName,initPlayers);
        mySesion.createTeam(equipo);
    }


    public  void createPlayer(String pName,String pPass,String pTel,String pos) {

        Player jugador=new Player(pName,pPass,pTel,pos);
        mySesion.insertPlayer(jugador,mySesion.getTeamId());
    }

    /**
     *
     * @return Lista convocados proximo partido
     */
    public ArrayList<String> getNextConvocatory() {
        return mySesion.getNextConvocatory();
    }


    public void registerConvocatory(String idPartido){
        Convocatory c=new Convocatory(idPartido,mySesion.getTeamId());
        mySesion.createConvocatory(c);
    }

    public  String[] getEvents(int eventsShown) {
        return mySesion.getEvents(eventsShown);
    }


    public boolean login(String nombre, String pass) {
      return   mySesion.validLogin(nombre,pass);
    }

    public PlayerStats getPlayerStats(String s) {
        return mySesion.getPlayerStats(s);
    }

    public String getPlayerId() {
        return mySesion.getPlayerId();
    }
}
