package com.movildat.lucassegarra.teammanager.controler;
import android.text.format.Time;
import com.movildat.lucassegarra.teammanager.model.Convocatory;
import com.movildat.lucassegarra.teammanager.model.DatabaseHandler;
import com.movildat.lucassegarra.teammanager.model.Match;
import com.movildat.lucassegarra.teammanager.model.Player;
import com.movildat.lucassegarra.teammanager.model.Sesion;
import com.movildat.lucassegarra.teammanager.model.Team;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by lucas.segarra on 05/08/2016.
 */
public class Controller {

    private Sesion mySesion;

    public Controller(Sesion s){
        mySesion=s;
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

    public boolean validLogin(String nombre, String pass) {
        //guardar en algun lado id_usuario
        return mySesion.validLogin(nombre,pass);
    }

    public void login(String nombre, String pass) {
        mySesion.login(nombre,pass);
    }
}
