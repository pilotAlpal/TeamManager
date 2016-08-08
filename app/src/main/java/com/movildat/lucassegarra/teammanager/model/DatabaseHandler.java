package com.movildat.lucassegarra.teammanager.model;

import java.util.ArrayList;

/**
 * Created by lucas.segarra on 05/08/2016.
 */
public class DatabaseHandler {
    static int nextTeamId=0,nextPlayerId=0;

    /**
     * recibe un objeto jugador (sin equipo) y guarda su info en la BD
     *
     * @param player objeto cuya información voy a guardar
     */
    public static void insertPlayer(Player player){}

    /**
     * borra un jugador de la tabla de jugadores(y de todas las tablas en las que apareciera)
     * @param playerId identificador del jugador a borrar
     */
    public static void removePlayer(String playerId){}

    /**
     * Desliga a un equipo y a un jugador
     * @param playerId identificador del jugador
     * @param teamId identificador del equipo
     */
    public static void unlinkPlayer(String playerId,String teamId){}

    /**
     * añade un jugador a un equipo,si el jugador no existe en la tabla de jugadores,se añadirá primero a dicha tabla y luego se le inscribirá en el equipo.
     * Si el id del equipo no existe,se le pedirá al usuario que lo vuelva a escribir
     * @param player
     * @param teamId
     */
    public static void insertPlayer(Player player,String teamId){}

    /**
     * crea una nueva convocatoria
     * @param convocatory
     */
    public static void insertConvocatory(Convocatory convocatory){}

    /**
     * borra una convocatoria
     * @param convocatoryId
     */
    public static void removeConvocatory(String convocatoryId){}

    /**
     * Almacena un nuevo equipo en la BD,si ya existe algún equipo con ese nombre se le pedirá al usuario que introduzca otro
     * @param team
     */
    public static void insertTeam(Team team){}

    /**
     * Permite eliminar un equipo de la BD
     * @param teamId
     */
    public static void removeTeam(String teamId){}

    /**
     * Almacena en la BD un nuevo equipo, si no existe ninguno con el mismo nombre.
     * @param team equipo
     */
    public static void createTeam(Team team){}

    /**
     * Permite crear una nueva liga
     * @param leage
     */
    public static void insertLeage(Leage leage){}

    /**
     * Permite borrar una liga
     * @param leageId
     */
    public static void removeLeage(String leageId){}

    /**
     * Permite registrar un evento
     * @param event
     */
    public static void insertEvent(Events event){}

    /**
     * Permite eliminar un evento
     * @param eventId
     */
    public static void removeEvent(String eventId){}

    public static String getNextTeamId(){
        return String.valueOf(nextTeamId);
    }

    public static String getNextPlayerId() {
        return String.valueOf(nextPlayerId);
    }

    public static String getTeamId(String pTeam) {
        return "0";
    }

    public static boolean login(String nombre, String pass) {
        return true;
    }
}
