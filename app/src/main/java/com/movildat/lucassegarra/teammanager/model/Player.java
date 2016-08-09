package com.movildat.lucassegarra.teammanager.model;

import com.movildat.lucassegarra.teammanager.controler.Controller;

/**
 * Created by lucas.segarra on 05/08/2016.
 */
public class Player {
    private String telefono,id,posicion,nombre,contrasena;
    private int dorsal,goles,asistencias;

    //(id,pName,pPass,pTel,pos)

    public Player(String pNam,String pass,String pTel,String pPos){
        id= DatabaseHandler.getNextPlayerId();
        posicion=pPos;
        nombre=pNam;
        contrasena=pass;
        telefono=pTel;
    }
}
