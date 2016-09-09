package com.movildat.lucassegarra.teammanager.controler;
import android.graphics.Bitmap;

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
     * @param position
     */
    public void changeMyPos(String position) {
        mySesion.changePlayerPos(position);
    }
    /**
     * permite cambiar la foto en bd y jugador
     * @param image
     */
    public void changePic(Bitmap image) {
        mySesion.changePic(image);
    }

    /**
     * permite cambiar equipo en sesion
     * @param newTeam
     */
    public void changeTeam(String newTeam) {
        mySesion.changeTeam(newTeam);
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
    public  boolean createPlayer(String pName,String pPass,String pTel,String pos,String team) {
        Player jugador=new Player(pName,pPass,pTel,pos);
        return mySesion.createPlayer(jugador)&&mySesion.linkTeamAndPlayer(pTel,team);


    }

    /**
     * Crea un nuevo equipo con ese teléfono y esa lista de jugadores si no existía ya un equipo con ese nombre
     * @param teamName
     * @param initPlayers
     * @return si se ha podido crear el equipo
     */
    public void createTeam(String teamName, ArrayList<String> initPlayers){
        Agenda agenda=new Agenda();
        TeamStats ts=new TeamStats();
        TeamRecords recordEquipo=getTeamRecords(teamName);
        ArrayList<Player> players=new ArrayList<>();
        Player p;
        for (int i=0;i<initPlayers.size();i++){
            String playerPhone=initPlayers.get(i);
            if(existPlayer(playerPhone)){
                p=getPlayer(playerPhone);
            }
            else{
                p=new Player(initPlayers.get(i),"a","626992478","Desconocido");
                mySesion.createPlayer(p);
            }
            players.add(p);
        }
        mySesion.createTeam(teamName,players,ts,agenda,recordEquipo);
    }

    private Player getPlayer(String playerPhone) {
        return mySesion.getPlayer(playerPhone);
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

    private boolean existPlayer(String playerPhone) {
        return mySesion.existPlayer(playerPhone);
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



    public ArrayList<Player> getPartners() {
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
     * Carga de la BD la información asociada a un jugador si las credenciales de inicio de sesión son correctas.
     * @param tel numero de telefono del usuario
     * @param pass contraseña
     * @return true si la información es correcta, false si no.
     */
    public boolean validLogin(String tel, String pass) {
        return mySesion.login(tel,pass);
    }


    public void ratePlayer() {
        
    }

    public void addMeToNextConvocatory() {
    }

    public void removeMeFromNextConvocatory() {
    }


    public boolean createMatch(String nRival, Date f, String h) {
        return mySesion.createMatch(getTeamId(),nRival,f,h);
    }

    public boolean existTeam(String team) {
        return mySesion.existTeam(team);
    }
}
