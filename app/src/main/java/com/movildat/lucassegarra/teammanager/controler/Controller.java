package com.movildat.lucassegarra.teammanager.controler;
import com.movildat.lucassegarra.teammanager.model.Agenda;
import com.movildat.lucassegarra.teammanager.model.Convocatory;
import com.movildat.lucassegarra.teammanager.model.Events;
import com.movildat.lucassegarra.teammanager.model.Player;
import com.movildat.lucassegarra.teammanager.model.PlayerStats;
import com.movildat.lucassegarra.teammanager.model.TeamRecords;
import com.movildat.lucassegarra.teammanager.model.Result;
import com.movildat.lucassegarra.teammanager.model.Sesion;
import com.movildat.lucassegarra.teammanager.model.Team;
import com.movildat.lucassegarra.teammanager.model.TeamStats;

import java.io.Serializable;
import java.util.ArrayList;

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
     * permite cambiar equipo en sesion
     */
    public void changeTeam() {
        mySesion.changeTeam();
    }

    public void createConvocatory(String idPartido){
        Convocatory c=new Convocatory(idPartido,mySesion.getTeamId());
        mySesion.createConvocatory(c);
    }

    public void createEvent() {
    }

    /**
     * Crea un usuario con esos datos si no existia ya uno con ese nombre
     * @param pName
     * @param pPass
     * @param pTel
     * @param pos
     * @return si no existia un usuario con ese telefono y se ha registrado al jugador
     */
    public  boolean createPlayer(String pName,String pPass,String pTel,String pos) {
        Player jugador=new Player(pName,pPass,pTel,pos);
        return mySesion.createPlayer(jugador);
    }

    /**
     * Crea un nuevo equipo con ese teléfono y esa lista de jugadores si no existía ya un equipo con ese nombre
     * @param teamName
     * @param initPlayers
     * @return si se ha podido crear el equipo
     */
    public boolean createTeam(String teamName, ArrayList<String> initPlayers){
        Agenda agenda=new Agenda();
        TeamStats ts=new TeamStats();
        TeamRecords recordEquipo=getTeamRecords(teamName);
        Team equipo=new Team(teamName,initPlayers,ts,agenda,recordEquipo);
        return mySesion.createTeam(equipo);
    }



    /**
     * permite al usuario borrar su perfil
     */
    public void deleteProfile() {
    }

    //permite al usuario inscribirse en un equipo
    public boolean enrollTeam(String teamName){
        return mySesion.enrollTeam(teamName);
    }

    /**
     *
     * @return Las estadísticas asociadas a mi jugador
     */
    public PlayerStats getMyplayerStats(){
        return getPlayerStats(mySesion.getMyPlayerId());
    }

    private String getNextMatchId(String teamName) {
        return mySesion.getNextMatchId(teamName);
    }

    public ArrayList<Events> getEvents(String teamId) {
        return mySesion.getEvents(teamId);
    }

    public String getMyPlayerId(){return mySesion.getMyPlayerId();}

    public String[] getMyTeams() {
        return mySesion.getMyTeams();
    }

    public TeamStats getMyTeamStats(){
        return getTeamStats(getTeamId());
    }

    public TeamRecords getMyTeamRecords() {
        return getTeamRecords(getTeamId());
    }

    /**
     *
     * @return Lista convocados proximo partido
     * @param teamId
     */
    public ArrayList<Player> getNextConvocatory(String teamId) {
        return mySesion.getNextConvocated(teamId);
    }



    public ArrayList<String> getPartners() {
        return mySesion.getPartners();
    }

    public PlayerStats getPlayerStats(String playerId) {
        return mySesion.getPlayerStats(playerId);
    }

    public Result[] getResults() {
        Result[] r=new Result[1];
        r[0]=new Result();
        return r;
    }

    public String getTeamId(){
        return mySesion.getTeamId();
    }

    public TeamRecords getTeamRecords(String teamName) {
        return mySesion.getTeamRecords(teamName);
    }

    public TeamStats getTeamStats(String teamId){
        return mySesion.getTeamStats(teamId);
    }

    public void leaveTeam() {
    }

    /**
     *  Carga en el modelo los datos correspondientes al usuario asociado a ese nombre, si dicho usuario existe y si pass es su contraseña.
     * @param nombre
     * @param pass
     * @return si se ha podido identificar a un usuario con esas credenciales y cargar los datos
     */
    public boolean validLogin(String nombre, String pass) {
        return mySesion.validLogin(nombre,pass);
    }


    public void ratePlayer() {
        
    }

    public void addToNextConvocatory() {
    }

    public void removeFromNextConvocatory() {
    }


}
