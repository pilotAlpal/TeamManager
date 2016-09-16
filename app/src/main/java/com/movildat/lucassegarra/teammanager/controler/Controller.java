package com.movildat.lucassegarra.teammanager.controler;
import android.graphics.Bitmap;

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


    /**
     *
     * @param ini
     * @param fin
     */
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
     */
    public  void createPlayer(String pName,String pPass,String pTel,String pos,String team) {
        mySesion.createAndLinkPlayer(pName,pPass,pTel,pos,team);
    }

    /**
     *
     * @param name
     * @param pass
     * @param tel
     * @param posicion
     */
    public void createPlayer(String name, String pass, String tel, String posicion) {
        mySesion.createPlayer(name,pass,tel,posicion);
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
            if(mySesion.existPlayer(playerPhone)){
                p=mySesion.getPlayer(playerPhone);
            }
            else{
               p= mySesion.invitePlayer(playerPhone);
            }
            players.add(p);
        }
        mySesion.createTeam(teamName,players);
    }

    /**
     *
     * @param nRival
     * @param f
     * @param h
     */
    public void createMatch(String nRival, Date f, String h) {
        mySesion.createMatch(nRival,f,h);
    }

    /**
     * permite al usuario borrar su perfil
     */
    public void deleteProfile() {
        mySesion.deleteProfile();
    }

    /**
     *
     * @return Las estadísticas asociadas a mi jugador
     */
    public PlayerStats getMyplayerStats(){
        return mySesion.getMyPlayerStats();
    }


    /**
     *
     * @return
     */
    public ArrayList<Events> getEvents() {
        return mySesion.getEvents();
    }

    /**
     *
     * @return
     */
    public String getMyPlayerId(){return mySesion.getId();}

    /**
     *
     * @return
     */
    public String[] getMyTeams() {
        return mySesion.getMyTeams();
    }

    /**
     *
     * @return
     */
    public TeamStats getMyTeamStats(){
        return mySesion.getMyTeamStats();
    }

    /**
     *
     * @return
     */
    public TeamRecords getMyTeamRecords() {
        return mySesion.getMyTeamRecords();
    }

    /**
     *
     * @return Lista convocados proximo partido
     */
    public ArrayList<Player> getNextConvocatory() {
        return mySesion.getNextConvocated();
    }

    /**
     *
     * @return
     */
    public ArrayList<Player> getPartners() {
        return mySesion.getPartners();
    }

    /**
     *
     * @param playerId
     * @return
     */
    public PlayerStats getPlayerStats(String playerId) {
        return mySesion.getPlayerStats(playerId);
    }

    /**
     *
     * @return
     */
    public Result[] getResults() {
        Result[] r=new Result[1];
        r[0]=new Result();
        return r;
    }

    /**
     *
     * @param teamName
     */
    public void enrollTeam(String teamName){
        mySesion.enrollTeam(teamName);
    }

    /**
     *
     */
    public void leaveTeam() {
        mySesion.leaveTeam();
    }

    /**
     * Carga de la BD la información asociada a un jugador si las credenciales de inicio de sesión son correctas.
     * @param tel numero de telefono del usuario
     * @param pass contraseña
     */
    public void login(String tel, String pass) {
        mySesion.login(tel,pass);
    }


    /**
     *
     * @param v
     * @param partnerId
     */
    public void ratePlayer(float v, String partnerId) {
        mySesion.rate(v,partnerId);
    }

    /**
     *
     */
    public void addMeToNextConvocatory() {
        mySesion.addToNextMatch();
    }

    /**
     *
     */
    public void removeMeFromNextConvocatory() {
        mySesion.removeFromNextMatch();
    }

    /**
     *
     * @param team
     * @return
     */
    public boolean existTeam(String team){
        return mySesion.existTeam(team);
    }

    /**
     *
     * @param name
     * @param pass
     * @param team
     * @param tel
     * @param posicion
     */
    public void signIn(String name, String pass, String team, String tel, String posicion) {
        mySesion.signIn(name,pass,team,tel,posicion);
    }

    /**
     * Permite aniadir un observador al modelo
     * @param o
     */
    public void addObserver(Sesion.Observador o) {
        mySesion.addObserver(o);
    }
}
