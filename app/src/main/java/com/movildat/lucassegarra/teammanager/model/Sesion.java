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

    /**
     * constructor por defecto.
     */
    public Sesion(){
        lista=new ArrayList<>();
        dao=new DatabaseHandler();
    }

    /**
     * Carga un jugador y el último equipo al que este accedió, en la sesión actual dados su telefono(id) y su contraseña.
     * @param tel Identificador/teléfono.
     * @param pass Contraseña.
     * @return true si la identificación se produce correctamente, false si no.
     */
    public boolean login(String tel, String pass) {
        if(dao.validLogin(tel,pass)) {
            log(tel, pass);
            return true;
        }
        notifyInvalidCredentials();
        return false;
    }

    private void log(String tel, String pass) {
        jugador=dao.login(tel,pass);
        equipo=dao.lastTeamChosen(jugador.getPhone());
        refreshStats();
    }

    private void refreshStats(){
        estsJugEqu=dao.getTeamPlayerStats(jugador.getPhone(),equipo.getTeamId());
    }

    /**
     * Permite a un jugador registrarse.
     * Guarda información referente a él en la BD y carga al jugador y al equipo en la sesión.
     * @param name Nombre del jugador.
     * @param pass Contraseña.
     * @param team Nombre del equipo.
     * @param phone Teléfono (identificación).
     * @param pos Posición.
     * @return True si se ha podido registrar al jugador
     */
    public boolean signIn(String name,String pass,String team,String phone,String pos){
        equipo=dao.getTeam(team);
        if (!dao.existPlayer(phone)){
            jugador=dao.createPlayer(name,pass,phone,pos);
            estsJugEqu=new PlayerStats(pos);
            return true;
        }
        notifyRepeatedPlayerId();
        return false;
    }


    /**
     * Permite registrar un equipo si no existe otro con el mismo nombre
     * @param equipe Nombre del equipo.
     * @param players Lista con los jugadores.
     * @return Si se pudo crear el equipo.
     *
     */
    public boolean createTeam(String equipe, ArrayList<Player> players) {
        if(!dao.existTeam(equipe)){
            equipo=dao.createTeam(equipe,players);
            refreshStats();
            return true;
        }
        notifyRepeatedTeamName();
        return false;
    }

    /**
     * Cambia la imagen del usuario tanto en la sesión actual como en la BD.
     * @param image Nueva Foto.
     */
    public void changePic(Bitmap image) {
        jugador.changePic(image);
        dao.changePic(jugador.getPhone());
    }

    /**
     * Permite al usuario cambiar a otro de los equipos en los que está registrado.
     * @param newTeam Equipo que  se carga en la sesión.
     */
    public void changeTeam(String newTeam) {
        equipo=dao.getTeam(newTeam);
        equipo.addPlayer(jugador);
        refreshStats();
    }

    /**
     * Permite a un jugador borrar su usuario.
     */
    public void deleteProfile(){
        dao.deleteProfile(jugador);
    }

    /**
     * Permite a un usuario invitar a amigos que aún no tienen perfil.
     * @param phone Teléfono del compañero.
     * @return Jugador compañero.
     */
    public Player invitePlayer(String phone) {
        return dao.invitePlayer(phone);
    }

    /**
     *
     * @param observer
     */
    @Override
    public void addObserver(Observador observer) {
        lista.add(observer);
    }

    /**
     * Registra una nueva convocatoria en la BD
      * @param c
     */
    public void createConvocatory(Convocatory c) {
        dao.createConvocatory(c);
    }

    /**
     * Permite guardar un jugador en la BD, inscribirlo a un equipo ya existente, y cargarlo en la sesión.
     * @param name Nombre del jugador.
     * @param pass Contraseña.
     * @param telef Teléfono.
     * @param pos Posición.
     * @param team Nombre del equipo.
     * @return True si se ha podido inscribir al jugador e inscribirlo en el equipo, false si no.
     */
    public boolean createAndLinkPlayer(String name, String pass, String telef, String pos, String team) {
        jugador= dao.createPlayer(name,pass,telef,pos);
        return dao.linkTeamAndPlayer(telef,team);
    }

    /**
     * Permite a un jugador cambiar su posición favorita en la sesión y en la BD
     * @param position Nueva posición favorita.
     */
    public void changePlayerPos(String position) {
        dao.changePlayerPos(jugador.getPhone(),position);
        jugador.changePos(position);
    }

    /**
     * Permite a un jugador inscribirse en un equipo  siempre que este exista.
     * @param teamName Nombre del equipo nuevo en el que se quiere registrar el jugador.
     * @return True si se ha podido inscribir, si no false.
     */
    public boolean enrollTeam(String teamName) {
        if(existTeam(teamName)){
            dao.linkTeamAndPlayer(jugador.getPhone(),teamName);
            changeTeam(teamName);
            return true;
        }
        return false;
    }

    /**
     * Permite registrar un encuentro entre dos equipos dados una fecha y una hora.
     * @param miTeamId Equipo local.
     * @param nRival Visitante.
     * @param f Fecha.
     * @param h Hora.
     */
    public void createMatch(String miTeamId,String nRival, Date f, String h) {
        Match m= dao.createMatch(miTeamId,nRival,f,h);
        equipo.addMatch(m);
    }



    @Override
    public void delObserver(Observador observer) {
        lista.remove(observer);
    }


    /**
     * Carga la lista de próximos eventos
     * @param teamId
     * @return
     */
    public ArrayList<Events> getEvents(String teamId){
        return dao.getEvents(teamId);
    }

    /**
     * Carga los últimos partidos de un equipo
     * @param teamName
     * @return
     */
    public ArrayList<Match> getLastMatches(String teamName){
        return dao.getLastMatches(teamName);
    }

    /**
     *
     * @return Id del jugador con sesión iniciada
     */
    public String getMyPlayerId() {
        return jugador.getPhone();
    }


    /**
     *
     * @return Lista de los equipos en los que juega el usuario con sesión iniciada.
     */
    public String[] getMyTeams() {
        return dao.getTeams(jugador.getPhone());
    }


    /**
     *
     * @param teamId Nombre del equipo.
     * @return Lista de los convocados para el próximo partido.
     */
    public ArrayList<Player> getNextConvocated(String teamId) {
        return dao.getNextConvocatory(teamId);
    }

    /**
     *
     * @param teamName Nombre del equipo.
     * @return Lista de los próximos partidos.
     */
    private ArrayList<Match> getNextMatches(String teamName) {
        return dao.getNextMatches(teamName);
    }

    /**
     *
     * @param tName Nombre del equipo.
     * @return Id del próximo partido.
     */
    public String getNextMatchId(String tName){
        return dao.getNextMatchId(tName);
    }

    /**
     *
     * @param teamName Nombre del equipo.
     * @return Id del próximo rival.
     */
    private String getNextRivalId(String teamName) {
        return dao.getNextRivalId(teamName);
    }

    /**
     *
     * @return Lista de compañeros de equipo.
     */
    public ArrayList<Player> getPartners() {
        return equipo.getPlayersList();
    }

    /**
     *
     * @param playerId Teléfono del jugador.
     * @return Estadísticas del jugador.
     */
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



    /**
     *
     * @param teamName Nombre del equipo.
     * @return Records de mi equipo.
     */
    public TeamRecords getTeamRecords(String teamName) {
        return dao.getTeamRecords(teamName);
    }

    /**
     *
     * @param playerPhone
     * @return
     */
    public boolean existPlayer(String playerPhone) {
        return dao.existPlayer(playerPhone);
    }

    public Player getPlayer(String playerPhone) {
        return dao.getPlayer(playerPhone);
    }


    public boolean existTeam(String team) {
        return dao.existTeam(team);
    }

    /**
     * Permite al usuario abandonar el equipo que tiene cargado en la sesion
     */
    public void leaveTeam() {
        dao.leaveTeam(jugador,equipo);
        equipo=dao.lastTeamChosen(jugador.getPhone());
    }

    /**
     * Permite crear un nuevo evento en la BD y en la sesión
     * @param ini Fecha de inicio
     * @param fin Fecha de final
     */
    public void createEvent(Date ini, Date fin) {
        Events event=dao.createEvent(getTeamId(),ini,fin);
        equipo.addEvent(event);
    }

    public void addToNextMatch() {
    }

    public void createPlayer(String name, String pass, String tel, String posicion) {
        jugador=dao.createPlayer(name,pass,tel,posicion);
    }


    //Métodos que implementarán las vistas(observadores)
    public interface Observador extends Observer{
        void setController(Controller controller);
        /**
         * añadir aqui notificaciones a la vista
         */
        void invalidCredentials();
        void repeatedPlayerID();
        void repeatedTeamName();
    }

    public void notifyInvalidCredentials(){
        for (Observador o:lista){
            o.invalidCredentials();
        }
    }

    public void notifyRepeatedPlayerId(){
        for (Observador o:lista){
            o.repeatedPlayerID();
        }
    }

    public void notifyRepeatedTeamName(){
        for (Observador o:lista){
            o.repeatedTeamName();
        }
    }


}
