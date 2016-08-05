package com.movildat.lucassegarra.teammanager.model;

import java.sql.Date;

/**
 * Created by lucas.segarra on 05/08/2016.
 */
public class Match {
    private String id;
    private String tournament;//leage
    private String homeId,guestId;
    private Date when;
    private int homeG,guestG;

    private Match(String matchId,String tournamentId,String home_id,String guest_id,Date w,int home_goals,int guest_goals){
        id=matchId;tournament=tournamentId;homeId=home_id;guestId=guest_id;
        when=w;
        homeG=home_goals;
        guestG=guest_goals;
    }

}
