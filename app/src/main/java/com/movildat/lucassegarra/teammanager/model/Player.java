package com.movildat.lucassegarra.teammanager.model;

import com.movildat.lucassegarra.teammanager.controler.Controller;

import java.io.Serializable;

/**
 * Created by lucas.segarra on 05/08/2016.
 */
public class Player implements Serializable {
    private String telefono,nombre,contrasena;
    private PlayerStats data;

    //(id,pName,pPass,pTel,pos)

    public Player(String pNam,String pass,String pTel,String pPos){
        nombre= pNam;
        contrasena=pass;
        telefono=pTel;
        data=new PlayerStats(pPos);
    }
    public Player(String pNam,String pass,String pTel,String pPos,PlayerStats stats){
        nombre= pNam;
        contrasena=pass;
        telefono=pTel;
        data=stats;
    }

    public String getPhone() {
        return telefono;
    }

    public void addTeam(String teamName) {
    }

    public void changePic() {

    }
}
