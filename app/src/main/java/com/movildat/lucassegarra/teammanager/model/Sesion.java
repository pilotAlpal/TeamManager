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
        estsJugEqu=dao.getTeamPlayerStats(jugador.getPhone(),getTeamId());
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
     * Cambia la imagen del usuario tanto en la sesión actual como en la BD.
     * @param image Nueva Foto.
     * @return Si se ha podido cambiar la imagen.
     */
    public boolean changePic(Bitmap image) {
        jugador.changePic(image);
        dao.changePic(jugador.getPhone());
        return true;
    }

    /**
     * Permite a un jugador cambiar su posición favorita en la sesión y en la BD
     * @param position Nueva posición favorita.
     * @return Si se pudo cambiar la posición.
     */
    public boolean changePlayerPos(String position) {
        dao.changePlayerPos(jugador.getPhone(),position);
        jugador.changePos(position);
        return true;
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
     * Permite al usuario cambiar a otro de los equipos en los que está registrado.
     * @param newTeam Equipo que  se carga en la sesión.
     * @return Si se ha podido hacer el cambio.
     */
    public boolean changeTeam(String newTeam) {
        equipo=dao.getTeam(newTeam);
        equipo.addPlayer(jugador);
        refreshStats();
        return true;
    }

    /**
     * Permite a un jugador inscribirse en un equipo  siempre que este exista.
     * @param teamName Nombre del equipo nuevo en el que se quiere registrar el jugador.
     * @return True si se ha podido inscribir, si no false.
     */
    public boolean enrollTeam(String teamName) {
        if(existTeam(teamName)){
            dao.linkTeamAndPlayer(jugador.getPhone(),teamName);
            return changeTeam(teamName);
        }
        notifyTeamDoesNotExist();
        return false;
    }

    /**
     * Permite al usuario abandonar el equipo que tiene cargado en la sesion
     */
    public void leaveTeam() {
        dao.leaveTeam(jugador,equipo);
        equipo=dao.lastTeamChosen(jugador.getPhone());
    }

    /**
     * Permite a un jugador borrar su usuario.
     */
    public void deleteProfile(){
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
     * @return True si se ha podido realizar la operación.
     */
    public boolean createPlayer(String name, String pass, String tel, String posicion) {
        if(!dao.existPlayer(tel)){
            jugador=dao.createPlayer(name,pass,tel,posicion);
            return true;
        }
        notifyRepeatedPlayerId();
        return false;
    }

    /**
     * Permite guardar un jugador en la BD, inscribirlo a un equipo ya existente, y cargarlo en la sesión, registrando relación entre equipo y jugador.
     * @param name Nombre del jugador.
     * @param pass Contraseña.
     * @param telef Teléfono.
     * @param pos Posición.
     * @param team Nombre del equipo.
     * @return True si se ha podido inscribir al jugador en el equipo, false si no.
     */
    public boolean createAndLinkPlayer(String name, String pass, String telef, String pos, String team) {
        if(!dao.existPlayer(telef)){
            jugador= dao.createPlayer(name,pass,telef,pos);
            return dao.linkTeamAndPlayer(telef,team);
        }
        notifyRepeatedPlayerId();
        return false;
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
     * @return Si se ha podido registrar el partido.
     */
    public boolean createMatch(String nRival, Date f, String h) {
        if(existTeam(nRival)){
            Match m= dao.createMatch(getTeamId(),nRival,f,h);
            equipo.addMatch(m);
            return true;
        }
        notifyTeamDoesNotExist();
        return false;
    }

    /**
     * Permite al jugador apuntarse al próximo partido.
     */
    public void addToNextMatch() {
        equipo.addToNextMatch(jugador.getPhone());
        dao.addToNextMatch(equipo.getTeamId(),jugador.getPhone());
    }

    public void removeFromNextMatch() {
        equipo.addToNextMatch(jugador.getPhone());
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
        return dao.getEvents(getTeamId());
    }

    /**
     *
     * @return Últimos partidos de un equipo.
     */
    public ArrayList<Match> getLastMatches(){
        return dao.getLastMatches(getTeamId());
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
        return dao.getNextConvocatory(getTeamId());
    }

    /**
     * @return Lista de los próximos partidos.
     */
    private ArrayList<Match> getNextMatches() {
        return dao.getNextMatches(getTeamId());
    }

    /**
     *
     * @return Lista de compañeros de equipo.
     */
    public ArrayList<Player> getPartners() {
        return equipo.getPlayersList();
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
     * @return Lista de jugadores de mi equipo.
     */
    private ArrayList<Player> getTeamPlayers() {
        return dao.getTeamPlayers(getTeamId());
    }

    /**
     *
     * @param teamId
     * @return Estadísticas asociadas a teamId.
     */
    public TeamStats getTeamStats(String teamId) {
        return dao.getTeamStats(teamId);
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
     * @param teamName Nombre del equipo.
     * @return Records de un equipo.
     */
    public TeamRecords getTeamRecords(String teamName) {
        return dao.getTeamRecords(teamName);
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
