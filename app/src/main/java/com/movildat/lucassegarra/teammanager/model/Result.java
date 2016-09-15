package com.movildat.lucassegarra.teammanager.model;

import java.io.Serializable;

/**
 * Created by lucas.segarra on 18/08/2016.
 */
public class Result implements Serializable {
    private int local,visitante;

    public Result(int golesL,int golesV){
        local=golesL;
        visitante=golesV;
    }
    public Result(){
        local=0;
        visitante=0;
    }
    public void golLocal(){
        local++;
    }
    public void golVisitante(){
        visitante--;
    }

}
