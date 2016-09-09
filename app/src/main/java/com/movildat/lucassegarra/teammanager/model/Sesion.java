package com.movildat.lucassegarra.teammanager.model;

import android.graphics.Bitmap;

import com.movildat.lucassegarra.teammanager.controler.Controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Observer;

/**
 * Created by Propietario on 12/08/2016.
 */
public class Sesion implements Observable<Sesion.Observador> ,Serializable{

    private PlayerStats estsJugEqu;
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

    //cambia en modelo y bd imagen asociada al usuario
    //recibirá una imagen cómo parámetro
    public void changePic(Bitmap image) {
        jugador.changePic(image);
        dao.changePic(jugador.getPhone());
    }

    //Modelo:carga en equipo la informacion correspondiente a un equipo que se recibirá cómo parámetro
    //existe una relación entre el equipo y el usuario en la bd
    public void changeTeam(String newTeam) {
        equipo=makeTeam(newTeam);
    }

    //BD:crea una nueva convocatoria en la base de datos
    //Modelo:si es anterior a la próxima convocatoria almacenada por equipo en sesión,actualizarla
    public void createConvocatory(Convocatory c) {
        dao.createConvocatory(c);
    }

    //BD:permite al usuario guardar un jugador en la bd
    //Modelo:No hay cambios ya que la sesion aun no ha sido iniciada cuando se invoca a este método
    //Controlador:Permite al controlador conocer si se ha insertado el jugador.
    public boolean createPlayer(Player jugador) {
        return dao.createPlayer(jugador);
    }

    //BD:permite al usuario insertar un nuevo método en la bd
    //Modelo:No hay cambios ya que la sesion aun no ha sido iniciada cuando se invoca a este método
    //Controlador:Informa al controlador si ha sido posible crear el equipo
    public void createTeam(String equipe, ArrayList<Player> players, TeamStats ts, Agenda agenda, TeamRecords recordEquipo) {
        equipo=dao.createTeam(equipe,players,ts,agenda,recordEquipo);
    }

    @Override
    public void delObserver(Observador observer) {
        lista.remove(observer);
    }

    /**
     * Añade una nueva relación entre el usuario y un equipo ya existente tanto en la BD como en la sesión actual
     * @param teamName nombre del equipo
     * @return si la operación ha tenido (o no) éxito
     */
    public boolean enrollTeam(String teamName) {
        if(existTeam(teamName)){
            changeTeam(teamName);
            equipo.addPlayer(jugador);
            return true;
        }
        return false;
    }

    private Team makeTeam(String teamName){
        Convocatory convocatory=new Convocatory(getNextMatchId(teamName),teamName, getNextConvocated(teamName));
        Match proxP=new Match(getNextRivalId(teamName),convocatory);
        Agenda agenda=new Agenda(getNextMatches(teamName),getLastMatches(teamName),proxP,getEvents(teamName));
        TeamRecords tr=dao.getTeamRecords(teamName);
        return new Team(teamName,getTeamPlayers(),getTeamStats(teamName),agenda,tr);
    }




    //BD:carga la lista de próximos eventos
    public ArrayList<Events> getEvents(String teamId){
        return dao.getEvents(teamId);
    }

    public ArrayList<Match> getLastMatches(String teamName){
        return dao.getLastMatches(teamName);
    }

    //Modelo:Devuelve el id de mi jugador
    public String getMyPlayerId() {
        return jugador.getPhone();
    }

    //BD:carga la lista de equipos relacionados con un jugador
    public String[] getMyTeams() {
        return dao.getTeams(jugador.getPhone());
    }
    //BD:carga info sobre próxima convocatoria
    public ArrayList<Player> getNextConvocated(String teamId) {
        return dao.getNextConvocatory(teamId);
    }

    private ArrayList<Match> getNextMatches(String teamName) {
        return dao.getNextMatches(teamName);
    }

    public String getNextMatchId(String tName){
        return dao.getNextMatchId(tName);
    }

    private String getNextRivalId(String teamName) {
        return dao.getNextRivalId(teamName);
    }

    //Modelo:Obtiene del modelo la lista de compañeros de equipo
    public ArrayList<Player> getPartners() {
        return equipo.getPlayersList();
    }

    //BD:carga de las estadisticas asociadas al compañero
    public PlayerStats getPlayerStats(String playerId) {
        return dao.getPlayerStats(playerId);
    }

    /**
     *
     * @return el id de mi equipo
     */
    public String getTeamId() {
        return equipo.getTeamId();
    }

    private ArrayList<Player> getTeamPlayers() {
        return dao.getTeamPlayers(getTeamId());
    }

    /**
     *
     * @param teamId
     * @return estadisticas asociadas a mi equipo
     */
    public TeamStats getTeamStats(String teamId) {
        return equipo.getTeamStats(teamId);
    }

    private void log(String tel, String pass) {
        jugador=dao.login(tel,pass);
        equipo=dao.lastTeamChosen(jugador.getPhone());
        estsJugEqu=dao.getTeamPlayerStats(jugador.getPhone(),equipo.getTeamId());
    }

    /**
     * Comprueba si cierta información de inicio de sesión es válida. Si lo es carga los valores
     * asocuiados al usario de la BD a la sesión, si no informa.
     * @param tel numero de telefono del usuario
     * @param pass contraseña
     * @return true si se ha podido iniciar la sesión, falso si no.
     */
    public boolean login(String tel, String pass) {
        if(dao.validLogin(tel,pass)) {
            log(tel, pass);
            return true;
        }
        notifyInvalidCredentials();
        return false;
    }

    public void signIn(String name,String pass,String team,String phone,String pos){
        equipo=dao.getTeam(name);

    }

    public TeamRecords getTeamRecords(String teamName) {
        return dao.getTeamRecords(teamName);
    }

    public boolean existPlayer(String playerPhone) {
        return dao.existPlayer(playerPhone);
    }

    public Player getPlayer(String playerPhone) {
        return dao.getPlayer(playerPhone);
    }

    public boolean createMatch(String miTeamId,String nRival, Date f, String h) {
        return dao.createMatch(miTeamId,nRival,f,h);
    }

    public boolean existTeam(String team) {
        return dao.existTeam(team);
    }

    public boolean linkTeamAndPlayer(String pTel, String team) {
        return dao.linkTeamAndPlayer(pTel,team);
    }

    public void changePlayerPos(String position) {
        dao.changePlayerPos(jugador.getPhone(),position);
        jugador.changePos(position);
    }

    public interface Observador extends Observer{
        void setController(Controller controller);
        /**
         * añadir aqui notificaciones a la vista
         */
    }

    private void notifyInvalidCredentials(){}
}
