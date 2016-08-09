package com.movildat.lucassegarra.teammanager.controler;
import android.text.format.Time;
import com.movildat.lucassegarra.teammanager.model.Convocatory;
import com.movildat.lucassegarra.teammanager.model.DatabaseHandler;
import com.movildat.lucassegarra.teammanager.model.Match;
import com.movildat.lucassegarra.teammanager.model.Player;
import com.movildat.lucassegarra.teammanager.model.Team;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by lucas.segarra on 05/08/2016.
 */
public class Controller {

    public static void createTeam(String teamName, ArrayList<String> initPlayers){
        Team equipo=new Team(teamName,initPlayers);
        DatabaseHandler.createTeam(equipo);
    }

    public static void createPlayer(String pName,String pPass,String pTeam,String pTel,String pos) {
        String teamId=DatabaseHandler.getTeamId(pTeam);
        Player jugador=new Player(pName,pPass,pTel,pos);
        DatabaseHandler.insertPlayer(jugador,teamId);
    }

    /**
     *
     * @return Lista convocados proximo partido
     */
    public static ArrayList<String> getNextConvocatory() {
        return DatabaseHandler.getNextConvocatory();
    }

    /**
     * permite registrar un partido al usuario
     * @param nRival nombre del rival
     * @param f fecha
     * @param h hora
     */
    public static void registetMatch(String nRival, Date f, Time h) {
        String idRival=DatabaseHandler.getTeamId(nRival);
        Match m=new Match(getTeamId(),idRival,f,h);
        String idPartido=DatabaseHandler.createMatch(m);
        registerConvocatory(idPartido);
    }
    public static void registerConvocatory(String idPartido){
        Convocatory c=new Convocatory(idPartido,getTeamId());
        DatabaseHandler.createConvocatory(c);
    }
    private static String getTeamId(){return null;}
    private static String getUserId(){return null;}

}
