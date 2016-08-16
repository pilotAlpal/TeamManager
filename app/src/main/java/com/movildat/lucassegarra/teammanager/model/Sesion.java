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
    public void setUserName(String name){

    }
    public void setTeamName(String name){}
    @Override
    public void addObserver(Observador observer) {
        lista.add(observer);
    }

    @Override
    public void delObserver(Observador observer) {
        lista.remove(observer);
    }

    public boolean validLogin(String nombre, String pass) {
        boolean retorno=dao.validLogin(nombre,pass);
        if(!dao.validLogin(nombre,pass))
            notifyInvalidCredentials();
        else {
            jugador=dao.login(nombre,pass);
            //cargar ultimo equipo en el que se ha registrado el jugador
        }
        return retorno;
    }

    public void login(String nombre, String pass) {
        jugador=dao.login(nombre,pass);
        equipo=dao.lastTeamChosen(nombre);
    }
    public String[] getEvents(int eventsShown){
        return dao.getEvents(eventsShown);
    }

    public void createConvocatory(Convocatory c) {
        dao.createConvocatory(c);
    }

    public String getTeamId() {
        return equipo.getTeamId();
    }

    public void createTeam(Team equipo) {
    }

    public void insertPlayer(Player jugador, String teamId) {
    }

    public ArrayList<String> getNextConvocatory() {
        return dao.getNextConvocatory();
    }

    public PlayerStats getPlayerStats(String s) {
        return dao.getPlayerStats(s);
    }

    public interface Observador extends Observer{
        public void setController(Controller controller);
        /**
         * añadir aqui notificaciones a la vista
         */
    }

    private void notifyInvalidCredentials(){}
}
