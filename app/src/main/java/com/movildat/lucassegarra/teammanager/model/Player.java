package com.movildat.lucassegarra.teammanager.model;

import android.graphics.Bitmap;
import android.media.Image;

import com.movildat.lucassegarra.teammanager.controler.Controller;

import java.io.Serializable;

/**
 * Created by lucas.segarra on 05/08/2016.
 */
public class Player implements Serializable {
    private String telefono,nombre,contrasena;
    private PlayerStats data;
    private Bitmap photo;

    /**
     * Perimite construir un nuevo jugador del que se conocen su nombre,contraseña,teléfono y posición.
     * @param pNam nombre del jugador
     * @param pass contraseña
     * @param pTel teléfono
     * @param pPos posición que ocupa habitualmente
     */
    public Player(String pNam,String pass,String pTel,String pPos){
        nombre= pNam;
        contrasena=pass;
        telefono=pTel;
        data=new PlayerStats(pPos);
    }

    /**
     * Perimite construir un nuevo jugador del que se conocen su nombre,contraseña,teléfono y una serie de estadísticas acerca del mismo.
     * @param pNam nombre del jugador
     * @param pass contraseña
     * @param pTel teléfono
     * @param stats estadísticas realtivas al jugador
     */
    public Player(String pNam,String pass,String pTel,PlayerStats stats){
        nombre= pNam;
        contrasena=pass;
        telefono=pTel;
        data=stats;
    }

    /**
     *
     * @return teléfono del jugador
     */
    public String getPhone() {
        return telefono;
    }

    /**
     *
     * @return estadísticas guardadas del jugador
     */
    public PlayerStats getPlayerStats(){
        return data;
    }

    /**
     * cambia la imagen asociada al jugador
     * @param image nueva imagen
     */
    public void changePic(Bitmap image) {
        photo=image;
    }

    /**
     *
     * @return nombre del jugador
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * cambia la posición favorita deñl jugador
     * @param pos nueva posición
     */
    public void changePos(String pos){
        data.setPos(pos);
    }

    /**
     * cambia el dorsal del jugador
     * @param number nuevo número
     */
    public void changeNumber(String number){
        data.changeNumber(number);
    }

    /**
     * suma uno a la cantidad de goles marcados por el jugador
     */
    public void countGol(){
        data.addGols(1);
    }

    /**
     * suma uno a la cantidad de asistencias dadas por el jugador
     */
    public void countAsistance(){
        data.addAsists(1);
    }

    /**
     * suma uno al número de partidos jugados por el jugador
     */
    public void countMatch(){
        data.addMatches(1);
    }

    /**
     * suma uno al numero de expulsiones sufridas por el jugador
     */
    public void addExpulsion(){
        data.addExpulsions(1);
    }
}
