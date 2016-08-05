package com.movildat.lucassegarra.teammanager.model;

/**
 * Created by lucas.segarra on 05/08/2016.
 */
public class Gol {
    private String authorId;
    private String matchId;
    private int homeAfterGol;
    private int guestAfterGol;

    private Gol(String autor,String match,int homA,int guestA){
        authorId=autor;
        matchId=match;
        homeAfterGol=homA;
        guestAfterGol=guestA;
    }
}
