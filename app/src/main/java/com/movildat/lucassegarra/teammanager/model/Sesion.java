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
     */
    public void login(String tel, String pass) {
        if(dao.validLogin(tel,pass)) {
            log(tel, pass);
        }
        notifyInvalidCredentials();
    }

    private void log(String tel, String pass) {
        jugador=dao.login(tel,pass);
        refreshTeam();
        refreshStats();
    }

    private void refreshTeam(){
        equipo=dao.lastTeamChosen(jugador.getPhone());
    }

    private void refreshStats(){
        estsJugEqu=dao.getTeamPlayerStats(jugador.getPhone(),getTeamId());
    }

    /**
     * Permite a un jugador registrarse.
     * Guarda información referente a él en la BD y carga el jugador y el equipo en la sesión.
     * @param name Nombre del jugador.
     * @param pass Contraseña.
     * @param team Nombre del equipo.
     * @param phone Teléfono (identificación).
     * @param pos Posición.
     */
    public void signIn(String name,String pass,String team,String phone,String pos){
        setTeam(team);
        if (!dao.existPlayer(phone)){
            jugador=dao.createPlayer(name,pass,phone,pos);
            estsJugEqu=new PlayerStats(pos);
        }
        notifyRepeatedPlayerId();
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
     * Permite a un jugador cambiar su posición favorita en la sesión y en la BD
     * @param position Nueva posición favorita.
     *
     */
    public void changePlayerPos(String position) {
        dao.changePlayerPos(jugador.getPhone(),position);
        jugador.changePos(position);
    }

    /**
     *
     * @param team Nombre del equipo.
     * @return Permite comprobar si existe un nombre asociado a algún equipo.
     */
    public boolean existTeam(String team) {
        return dao.existTeam(team);
    }

    /**
     * Permite registrar un equipo si no existe otro con el mismo nombre
     * @param equipe Nombre del equipo.
     * @param players Lista con los jugadores.
     *
     */
    public void createTeam(String equipe, ArrayList<Player> players) {
        if(!dao.existTeam(equipe)){
            equipo=dao.createTeam(equipe,players);
            refreshStats();
        }
        notifyRepeatedTeamName();
    }

    /**
     * Permite al usuario cambiar a otro de los equipos en los que está registrado.
     * @param newTeam Equipo que  se carga en la sesión.
     */
    public void changeTeam(String newTeam) {
        setTeam(newTeam);
        equipo.addPlayer(jugador);
        refreshStats();
    }

    private void setTeam(String teamName){
        equipo=dao.getTeam(teamName);
    }

    /**
     * Permite a un jugador inscribirse en un equipo  siempre que este exista.
     * @param teamName Nombre del equipo nuevo en el que se quiere registrar el jugador.

     */
    public void enrollTeam(String teamName) {
        if(existTeam(teamName)){
            dao.linkTeamAndPlayer(jugador.getPhone(),teamName);
            changeTeam(teamName);
        }
        notifyTeamDoesNotExist();
    }

    /**
     * Permite al usuario abandonar el equipo que tiene cargado en la sesion
     */
    public void leaveTeam() {
        dao.leaveTeam(jugador,equipo);
        refreshTeam();
    }

    /**
     * Permite a un jugador borrar su usuario.
     */
    public void deleteProfile(){
        equipo.removePlayer(jugador.getPhone());
        dao.deleteProfile(jugador);
    }

    /**
     * Devuelve el jugador asociado a un id
     * @param playerPhone
     * @return
     */
    public Player getPlayer(String playerPhone) {
        return dao.getPlayer(playerPhone);
    }

    /**
     * Comprueba si existe un jufador con un numero de teléfono concreto
     * @param playerPhone
     * @return
     */
    public boolean existPlayer(String playerPhone){
        return dao.existPlayer(playerPhone);
    }

    /**
     * Permite al usuario crear un jugador e inscribirlo a un equipo ya existente y cargarlo en la sesión.
     * @param name Nombre del jugador.
     * @param pass Contraseña.
     * @param tel Teléfono.
     * @param posicion Posición.
     */
    public void createPlayer(String name, String pass, String tel, String posicion) {
        if(!dao.existPlayer(tel)){
            jugador=dao.createPlayer(name,pass,tel,posicion);
        }
        notifyRepeatedPlayerId();
    }

    /**
     * Permite guardar un jugador en la BD, inscribirlo a un equipo ya existente, y cargarlo en la sesión, registrando relación entre equipo y jugador.
     * @param name Nombre del jugador.
     * @param pass Contraseña.
     * @param telef Teléfono.
     * @param pos Posición.
     * @param team Nombre del equipo.
     */
    public void createAndLinkPlayer(String name, String pass, String telef, String pos, String team) {
        if(!dao.existPlayer(telef)){
            jugador= dao.createPlayer(name,pass,telef,pos);
            dao.linkTeamAndPlayer(telef,team);
        }
        notifyRepeatedPlayerId();
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
     * Permite registrar un encuentro entre dos equipos dados una fecha y una hora.
     * @param nRival Equipo rival.
     * @param f Fecha.
     * @param h Hora.
     */
    public void createMatch(String nRival, Date f, String h) {
        if(existTeam(nRival)){
            Match m= dao.createMatch(getTeamId(),nRival,f,h);
            equipo.addMatch(m);
        }
        notifyTeamDoesNotExist();
    }

    /**
     * Permite al jugador apuntarse al próximo partido.
     */
    public void addToNextMatch() {
        equipo.addToNextMatch(jugador);
        dao.addToNextMatch(equipo.getTeamId(),jugador.getPhone());
    }

    /**
     *Permite al jugador borrarse del próximo partido
     */
    public void removeFromNextMatch() {
        equipo.removeFromNextMatch(jugador);
        dao.removeFromNextMatch(equipo.getTeamId(),jugador.getPhone());
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

    /**
     *
     * @return Lista de próximos eventos.
     */
    public ArrayList<Events> getEvents(){
        return equipo.getEvents();
    }


    /**
     *
     * @return Id del jugador con sesión iniciada.
     */
    public String getId() {
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
     * @return Lista de los convocados para el próximo partido.
     */
    public ArrayList<Player> getNextConvocated() {
        return equipo.getNextConvocatory();
    }

    /**
     *
     * @return Últimos partidos de un equipo.
     */
    public ArrayList<Match> getLastMatches(){
        return equipo.getLastMatches();
    }


    /**
     * @return Lista de los próximos partidos.
     */
    private ArrayList<Match> getNextMatches() {
        return equipo.getNextMatches();
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
     * @return Estadísticas asociadas a mi jugador
     */
    public PlayerStats getMyPlayerStats() {
        return jugador.getPlayerStats();
    }

    /**
     * Permite obtener las estadísticas de un jugador.
     * @param playerId Teléfono del jugador.
     * @return Estadísticas del jugador.
     */
    public PlayerStats getPlayerStats(String playerId) {
        return dao.getPlayerStats(playerId);
    }

    /**
     *
     * @return El id de mi equipo.
     */
    public String getTeamId() {
        return equipo.getTeamId();
    }


    /**
     *
     * @return Estadísticas asociadas al equipo con sesión iniciada.
     */
    public TeamStats getMyTeamStats() {
        return equipo.getTeamStats();
    }

    /**
     *
     * @return Records de mi equipo.
     */
    public TeamRecords getMyTeamRecords() {
        return equipo.getTeamRecords();
    }

    @Override
    public void addObserver(Observador observer) {
        lista.add(observer);
    }

    @Override
    public void delObserver(Observador observer) {
        lista.remove(observer);
    }

    //Métodos que implementarán las vistas(observadores)

    public interface Observador extends Observer{
        void setController(Controller controller);
        void invalidCredentials();
        void repeatedPlayerID();
        void repeatedTeamName();
        void teamDoesNotExist();
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

    private void notifyTeamDoesNotExist() {
        for (Observador o:lista){
            o.teamDoesNotExist();
        }
    }

}
