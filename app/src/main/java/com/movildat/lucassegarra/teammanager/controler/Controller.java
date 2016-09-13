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

    public void createEvent(Date ini, Date fin) {
        mySesion.createEvent(ini,fin);
    }

    /**
     * Crea un usuario con esos datos si no existia ya uno con ese número. Y lo enlaza con un equipo.
     * @param pName Nombre.
     * @param pPass Contraseña.
     * @param pTel Teléfono.
     * @param pos Posición.
     * @param team Nombre del equipo
     * @return True si no existia un usuario con ese telefono y se ha registrado al jugador.
     */
    public  boolean createPlayer(String pName,String pPass,String pTel,String pos,String team) {
        return mySesion.createAndLinkPlayer(pName,pPass,pTel,pos,team);
    }

    /**
     * Crea un nuevo equipo con ese teléfono y esa lista de jugadores si no existía ya un equipo con ese nombre
     * @param teamName
     * @param initPlayers
     * @return si se ha podido crear el equipo
     */
    public void createTeam(String teamName, ArrayList<String> initPlayers){
        ArrayList<Player> players=new ArrayList<>();
        Player p;
        for (int i=0;i<initPlayers.size();i++){
            String playerPhone=initPlayers.get(i);
            if(existPlayer(playerPhone)){
                p=getPlayer(playerPhone);
            }
            else{
               p= mySesion.invitePlayer(playerPhone);
            }
            players.add(p);
        }
        mySesion.createTeam(teamName,players);
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
    public void enrollTeam(String teamName){
        mySesion.enrollTeam(teamName);
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
        mySesion.leaveTeam();
    }

    /**
     * Carga de la BD la información asociada a un jugador si las credenciales de inicio de sesión son correctas.
     * @param tel numero de telefono del usuario
     * @param pass contraseña
     * @return true si la información es correcta, false si no.
     */
    public boolean login(String tel, String pass) {
        return mySesion.login(tel,pass);
    }


    public void ratePlayer() {
        
    }

    public void addMeToNextConvocatory() {
        mySesion.addToNextMatch();
    }

    public void removeMeFromNextConvocatory() {
    }


    public boolean createMatch(String nRival, Date f, String h) {
        mySesion.createMatch(getTeamId(),nRival,f,h);
        return true;
    }

    public boolean existTeam(String team) {
        return mySesion.existTeam(team);
    }

    public void signIn(String name, String pass, String team, String tel, String posicion) {
        mySesion.signIn(name,pass,team,tel,posicion);
    }

    public void createPlayer(String name, String pass, String tel, String posicion) {
        mySesion.createPlayer(name,pass,tel,posicion);
    }
}
