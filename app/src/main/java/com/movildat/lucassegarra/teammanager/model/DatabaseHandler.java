package com.movildat.lucassegarra.teammanager.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by lucas.segarra on 05/08/2016.
 */
public class DatabaseHandler implements Serializable {

    /**
     * Verifica que exista un usuario con ese id y esa contraseña
     * @param telefono id del jugador
     * @param pass contraseña
     * @return True si existe
     */
    public boolean validLogin(String telefono, String pass) {
        return true;
    }

    /**
     *
     * @param telf id del jugador
     * @param pass contraseña
     * @return El jugador asociado a un teléfono.
     */
    public Player login(String telf, String pass) {
        return new Player("Lucas",pass,telf,"mediapunta");
    }

    /**
     *
     * @param idJugador
     * @return Último equipo al que accedió un jugador con un determinado número de teléfono
     */
    public Team lastTeamChosen(String idJugador) {
        String team="Rayo Vaticano";
        Convocatory convocatory=new Convocatory(getNextConvocatory(team));
        Match nextMatch=new Match(getNextRivalId(team),convocatory);
        Agenda agenda=new Agenda(getNextMatches(team),getLastMatches(team),nextMatch,getEvents(team));
        return new Team(team,getTeamPlayers(team),getTeamStats(),agenda);
    }

    /**
     * Comprueba que un id de equipo exista
     * @param teamName
     * @return
     */
    public boolean existTeam(String teamName) {
        return true;
    }

    /**
     *
     * @param equipo
     * @return Objeto que representa a un equipo dado su id
     */
    public Team getTeam(String equipo) {
        return new Team(equipo,getTeamPlayers(equipo),new TeamStats(),
                        new Agenda(new ArrayList<Match>(),new ArrayList<Match>(),
                                   new Match("Bayern",new Convocatory()),new ArrayList<Events>()));
    }

    /**
     * Construye y guarda un nuevo equipo en la sesión y en la BD.
     * @param equipo
     * @param players
     * @return
     */
    public Team createTeam(String equipo, ArrayList<Player> players) {
        return new Team(equipo,players,new TeamStats(),new Agenda());
    }

    /**
     *
     * @param phone
     * @param id
     * @return Estadísticas asociadas a un jugador con un equipo.
     */
    public PlayerStats getTeamPlayerStats(String phone, String id) {
        return new PlayerStats("mediapunta");
    }

    /**
     *
     * @param team
     * @return Integrantes de un equipo.
     */
    public ArrayList<Player> getTeamPlayers(String team) {
        ArrayList<Player> l=getNextConvocatory(team);
        l.add(new Player("Palop","a","626992478","Portero"));
        l.add(new Player("Marchena","a","626992478","Central"));
        l.add(new Player("Farinós","a","626992478","Centrocampista"));
        l.add(new Player("Fabio Aurelio","a","626992478","Lateral"));
        l.add(new Player("Rufete","a","626992478","Extremo"));
        return l;
    }

    /**
     *
     * @return Estadísticas asociadas a un equipo.
     */
    public TeamStats getTeamStats() {
        TeamRecords tRec=new TeamRecords();
        return new TeamStats(100,80,10,10,10,tRec);
    }

    /**
     *
     * @param teamId
     * @return Próximos eventos en los que participa el equipo.
     */
    public static ArrayList<Events> getEvents(String teamId) {
        ArrayList<Events> a= new ArrayList<>();
        a.add(new Events("Tirol"));
        a.add(new Events("Olimpique"));
        a.add(new Events("Heerenveen"));
        a.add(new Events("Olimpiakos"));
        a.add(new Events("Manchester"));
        a.add(new Events("Stum Graz"));
        a.add(new Events("Panathinaikos"));
        a.add(new Events("Arsenal"));
        a.add(new Events("Leeds"));
        a.add(new Events("Bayern"));
        return a;
    }

    /**
     *
     * @param teamId
     * @param ini
     * @param fin
     * @return Nuevo evento
     */
    public Events createEvent(String teamId, Date ini, Date fin) {
        return new Events("1");
    }


    /**
     *
     * @param team
     * @return id de l próximo rival
     */
    public String getNextRivalId(String team) {
        return "Bayern";
    }

    /**
     *
     * @param team
     * @return Lista con los últimos partidos en los que participó un equipo.
     */
    public ArrayList<Match> getLastMatches(String team) {
        return new ArrayList<>();
    }

    /**
     *
     * @param team
     * @return Lista con los próximos partidos en los que participará un equipo.
     */
    public ArrayList<Match> getNextMatches(String team){
        return new ArrayList<>();
    }

    /**
     * Permite crear un nuevo partido
     * @param miTeamId
     * @param nRival
     * @param f
     * @param h
     * @return
     */
    public Match createMatch(String miTeamId, String nRival, Date f, String h) {
        return new Match();
    }

    /**
     *
     * @param teamId
     * @return Lista de convocados para el próximo partido.
     */
    public ArrayList<Player> getNextConvocatory(String teamId) {
        ArrayList<Player> convocatoria=new ArrayList<>();
        convocatoria.add(new Player("Cañizares","a","626992478","Portero"));
        convocatoria.add(new Player("Angloma","a","626992478","Lateral"));
        convocatoria.add(new Player("Ayala","a","626992478","Central"));
        convocatoria.add(new Player("Pelegrino","a","626992478","Central"));
        convocatoria.add(new Player("Carboni","a","626992478","Lateral"));
        convocatoria.add(new Player("Mendieta","a","626992478","Centrocampista"));
        convocatoria.add(new Player("Baraja","a","626992478","Centrocampista"));
        convocatoria.add(new Player("Aimar","a","626992478","Mediapunta"));
        convocatoria.add(new Player("Killy Gónzalez","a","628665088","Extremo"));
        convocatoria.add(new Player("Angulo","a","626992478","Extremo"));
        convocatoria.add(new Player("Carew","a","626992478","Delantero"));
        convocatoria.add(new Player("Vicente","a","628665088","Extremo"));
        convocatoria.add(new Player("Juan Sánchez","a","626992478","Delantero"));
        convocatoria.add(new Player("Albelda","a","626992478","Centrocampista"));
        convocatoria.add(new Player("Djukic","a","626992478","Central"));
        return convocatoria;
    }

    /**
     * Registra realación entre jugador y equipo.
     * @param pTel
     * @param team
     * @return
     */
    public boolean linkTeamAndPlayer(String pTel, String team) {
        return true;
    }

    /**
     * Guarda una nueva instancia de jugador en la BD.
     * @param phone
     * @return
     */
    public Player invitePlayer(String phone) {
        return new Player("Pablo","asasas",phone,"MediaPunta");
    }

    /**
     *
     * @param playerPhone
     * @return Comprueba que exista un jugador con un id determinado.
     */
    public boolean existPlayer(String playerPhone) {
        return false;
    }

    /**
     *
     * @param playerPhone
     * @return Jugador asociado a un teléfono.
     */
    public Player getPlayer(String playerPhone) {
        return new Player("Aimar","a",playerPhone,"Mediapunta");
    }

    /**
     * Construye y guarda un nuevo jugador.
     * @param n
     * @param pss
     * @param ph
     * @param pos
     * @return
     */
    public Player createPlayer(String n,String pss,String ph,String pos) {
        return new Player(n,pss,ph,pos);
    }

    /**
     * Devuelve lista de los equipos a los que está inscrito el jugador.
     * @param idJugador
     * @return
     */
    public String[] getTeams(String idJugador) {
        String[] ret=new String[2];
        ret[0]="Argentina";
        ret[1]="Valencia";
        return ret;
    }

    /**
     *
     * @param playerId
     * @return Estadísticas(totales) del jugador.
     */
    public PlayerStats getPlayerStats(String playerId) {
        return new PlayerStats("mediapunta");
    }

    /**
     * Permite cambiar la foto asociada a un jugador.
     * @param id
     */
    public void changePic(String id) {
    }

    /**
     * Permite cambiar la posición favorita de un jugador.
     * @param phone
     * @param position
     */
    public void changePlayerPos(String phone, String position) {
    }

    /**
     * Permite a un jugador, eliminar su perfil.
     * @param jugador
     */
    public void deleteProfile(Player jugador) {
    }

    /**
     *  Permite a un jugador abandonar el equipo.
     * @param jugador
     * @param equipo
     */
    public void leaveTeam(Player jugador, Team equipo) {
    }

    /**
     * Permite a un jugador apuntarse a la próxima convocatoria.
     * @param teamId
     * @param phone
     */
    public void addToNextMatch(String teamId, String phone) {

    }

    /**
     * Permite a un jugador borrarse de la próxima convocatoria.
     * @param teamId
     * @param phone
     */
    public void removeFromNextMatch(String teamId, String phone) {
    }
}
