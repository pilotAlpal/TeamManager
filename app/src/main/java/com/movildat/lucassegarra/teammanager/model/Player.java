package com.movildat.lucassegarra.teammanager.model;

/**
 * Created by lucas.segarra on 05/08/2016.
 */
public class Player {
    private String telefono,id,posicion,nombre,contrasena;
    private int dorsal,goles,asistencias;

    //(id,pName,pPass,pTel,pos)

    public Player(String pId,String pNam,String pass,String pTel,String pPos){
        id=pId;
        posicion=pPos;
        nombre=pNam;
        contrasena=pass;
        telefono=pTel;
    }
}
