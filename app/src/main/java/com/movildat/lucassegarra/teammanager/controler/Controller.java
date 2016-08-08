package com.movildat.lucassegarra.teammanager.controler;

import com.movildat.lucassegarra.teammanager.model.DatabaseHandler;
import com.movildat.lucassegarra.teammanager.model.Player;
import com.movildat.lucassegarra.teammanager.model.Team;

import java.util.ArrayList;

/**
 * Created by lucas.segarra on 05/08/2016.
 */
public class Controller {

    public static void createTeam(String teamName, ArrayList<String> initPlayers){
        String id=DatabaseHandler.getNextTeamId();
        Team equipo=new Team(id,teamName,initPlayers);
        DatabaseHandler.createTeam(equipo);
    }

    public static void createPlayer(String pName,String pPass,String pTeam,String pTel,String pos) {
        String id=DatabaseHandler.getNextPlayerId();
        String teamId=DatabaseHandler.getTeamId(pTeam);
        Player jugador=new Player(id,pName,pPass,pTel,pos);
        DatabaseHandler.insertPlayer(jugador,teamId);
    }
}
