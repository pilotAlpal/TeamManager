package com.movildat.lucassegarra.teammanager.model;

import java.io.Serializable;

/**
 * Created by lucas.segarra on 05/08/2016.
 */
public class Gol implements Serializable {
    private String authorId;
    private boolean localGol;
    private int homeAfterGol;
    private int guestAfterGol;

    private Gol(String autor,boolean local,int homA,int guestA){
        authorId=autor;
        localGol=local;
        homeAfterGol=homA;
        guestAfterGol=guestA;
    }
}
