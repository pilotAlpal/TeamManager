package com.movildat.lucassegarra.teammanager.model;

import android.app.Activity;
import android.content.res.Resources;
import android.icu.util.Freezable;
import android.support.v4.app.Fragment;
import android.text.format.Time;

import com.movildat.lucassegarra.teammanager.R;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by lucas.segarra on 05/08/2016.
 */
public class DatabaseHandler {


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
     * Permite eliminar un equipo de la BD
     * @param teamId
     */
    public static void removeTeam(String teamId){}

    /**
     * Almacena en la BD un nuevo equipo, si no existe ninguno con el mismo nombre.
     * @param team equipo
     */
    public static String  createTeam(Team team){return "1";}


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

    /**
     *
     * @return el proximo id libre para asignarle a un equipo
     */
    public static String getNextTeamId(){
        return "1";
    }

    /**
     *
     * @return el proximo id libre para asignarle a un jugador
     */
    public static String getNextPlayerId() {
        return "1";
    }

    /**
     *
     * @param pTeam nombre del equipo del que se quiere conocer el id
     * @return Devuelve el id asociado a un equipo
     */
    public static String getTeamId(String pTeam) {
        return "0";
    }

    /**
     * Permite identificar a un usuario
     * @param nombre nombre del usuario
     * @param pass contrasena
     * @return true si se ha identificado correctamente, false si no
     */
    public static boolean login(String nombre, String pass) {
        return true;
    }

    /**
     *
     * @return Lista de convocados para el próximo partido
     */
    public static ArrayList<String> getNextConvocatory() { return null;
    }

    public static String createMatch(Match m) {
        return "1";
    }

    public static String getNextMatchId() {
        return "1";
    }

    public static String getNextConvocatoryId() {
        return "1";
    }

    public static String createConvocatory(Convocatory c) {
        return "1";
    }

    public static String[] getEvents(int eventsShown) {
        String a[]= new String[2];
        // Resources.getSystem().getStringArray(R.array.eventos);
        a[0]="Leeds";
        a[1]="Bayern";
        return a;
    }
}
