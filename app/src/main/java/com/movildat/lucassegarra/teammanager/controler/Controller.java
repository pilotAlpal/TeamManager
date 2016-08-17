package com.movildat.lucassegarra.teammanager.controler;
import android.text.format.Time;
import com.movildat.lucassegarra.teammanager.model.Convocatory;
import com.movildat.lucassegarra.teammanager.model.DatabaseHandler;
import com.movildat.lucassegarra.teammanager.model.Match;
import com.movildat.lucassegarra.teammanager.model.Player;
import com.movildat.lucassegarra.teammanager.model.PlayerStats;
import com.movildat.lucassegarra.teammanager.model.Sesion;
import com.movildat.lucassegarra.teammanager.model.Team;
import com.movildat.lucassegarra.teammanager.model.TeamStats;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by lucas.segarra on 05/08/2016.
 */
public class Controller implements Serializable{

    private Sesion mySesion;


    public Controller() {
        mySesion=new Sesion();
    }

    /**
     * permite cambiar la posicion del jugador en sesion y bd
     */
    public void changeMyPos() {
    }
    /**
     * permite cambiar la foto en bd y jugador
     */
    public void changePic() {
        mySesion.changePic();
    }

    /**
     * permite cambiar equipo en bd y sesion
     */
    public void changeTeam() {
    }

    public void createConvocatory(String idPartido){
        Convocatory c=new Convocatory(idPartido,mySesion.getTeamId());
        mySesion.createConvocatory(c);
    }

    /**
     * Crea un usuario con esos datos si no existia ya uno con ese nombre
     * @param pName
     * @param pPass
     * @param pTel
     * @param pos
     * @return si no existia un usuario con ese nombre y se ha registrado al jugador
     */
    public  boolean createPlayer(String pName,String pPass,String pTel,String pos) {

        Player jugador=new Player(pName,pPass,pTel,pos);
        return mySesion.insertPlayer(jugador,mySesion.getTeamId());
    }

    /**
     * Crea un nuevo equipo con ese teléfono y esa lista de jugadores si no existía ya un equipo con ese nombre
     * @param teamName
     * @param initPlayers
     * @return si se ha podido crear el equipo
     */
    public boolean createTeam(String teamName, ArrayList<String> initPlayers){
        Team equipo=new Team(teamName,initPlayers);
        return mySesion.createTeam(equipo);
    }

    /**
     * permite al usuario borrar su perfil
     */
    public void deleteProfile() {
    }

    /**
     *
     * @return Las estadísticas asociadas a mi jugador
     */
    public PlayerStats getMyplayerStats(){
        return getPlayerStats(getPlayerId());
    }

    public  String[] getEvents(int eventsShown) {
        return mySesion.getEvents(eventsShown);
    }

    public String[] getMyTeams() {
        return mySesion.getMyTeams();
    }

    public TeamStats getMyTeamStats(){
        return getTeamStats(getTeamId());
    }

    /**
     *
     * @return Lista convocados proximo partido
     */
    public ArrayList<String> getNextConvocatory() {
        return mySesion.getNextConvocatory();
    }


    public ArrayList<String> getPartners() {
        return mySesion.getPartners();
    }

    public String getPlayerId() {
        return mySesion.getPlayerId();
    }

    public PlayerStats getPlayerStats(String s) {
        return mySesion.getPlayerStats(s);
    }


    public String getTeamId(){
        return mySesion.getTeamId();
    }

    public TeamStats getTeamStats(String teamId){
        return mySesion.getTeamStats(teamId);
    }

    /**
     *  Carga en el modelo los datos correspondientes al usuario asociado a ese nombre,
     *  si dicho usuario existe y si pass es su contraseña.
     * @param nombre
     * @param pass
     * @return si se ha podido identificar a un usuario con esas credenciales y cargar los datos
     */
    public boolean validLogin(String nombre, String pass) {
        return mySesion.validLogin(nombre,pass);
    }

}
