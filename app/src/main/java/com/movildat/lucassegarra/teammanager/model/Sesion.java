package com.movildat.lucassegarra.teammanager.model;

import com.movildat.lucassegarra.teammanager.controler.Controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observer;

/**
 * Created by Propietario on 12/08/2016.
 */
public class Sesion implements Observable<Sesion.Observador> ,Serializable{

    private Player jugador;
    private Team equipo;
    private DatabaseHandler dao;
    private ArrayList<Observador> lista;
    public Sesion(){
        lista=new ArrayList<>();
        dao=new DatabaseHandler();
    }
    @Override
    public void addObserver(Observador observer) {
        lista.add(observer);
    }

    @Override
    public void delObserver(Observador observer) {
        lista.remove(observer);
    }

    public boolean validLogin(String nombre, String pass) {
        if(dao.validLogin(nombre,pass)) {
            login(nombre, pass);
            return true;
        }
        notifyInvalidCredentials();
        return false;
    }

    private void login(String nombre, String pass) {
        jugador=dao.login(nombre,pass);
        equipo=dao.lastTeamChosen(jugador.getPhone());
    }
    public ArrayList<Events> getEvents(String teamId){
        return dao.getEvents(teamId);
    }

    public void createConvocatory(Convocatory c) {
        dao.createConvocatory(c);
    }

    public String getTeamId() {
        return equipo.getTeamId();
    }

    public boolean createTeam(Team equipo) {
        return true;
    }

    public boolean insertPlayer(Player jugador) {
        return true;
    }

    public ArrayList<Player> getNextConvocatory(String teamId) {
        return dao.getNextConvocatory(teamId);
    }

    public PlayerStats getPlayerStats(String playerId) {
        return dao.getPlayerStats(playerId);
    }

    public String getPlayerId() {
        return jugador.getPhone();
    }

    public TeamStats getTeamStats(String teamId) {
        return dao.getTeamStats(teamId);
    }

    public ArrayList<String> getPartners() {
        return equipo.getPlayersList();
    }

    public void changePic() {
        dao.changePic(jugador.getPhone());
    }

    public String[] getMyTeams() {
        return dao.getTeams(jugador.getPhone());
    }

    public boolean enrollTeam(String teamName) {
        if(dao.existTeam(teamName)){
            jugador.addTeam(teamName);
            equipo=new Team(teamName,dao.getTeamPlayers(),dao.getTeamStats(teamName),dao.getNextConvocatory(teamName),
                    dao.getNextMatchId(teamName),dao.getEvents(teamName),dao.getLastMatches(teamName),dao.getNextMatches(teamName));
            return true;
        }
        return false;
    }

    public interface Observador extends Observer{
        void setController(Controller controller);
        /**
         * añadir aqui notificaciones a la vista
         */
    }

    private void notifyInvalidCredentials(){}
}
