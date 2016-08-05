package com.movildat.lucassegarra.teammanager.model;

import java.sql.Date;

/**
 * Created by lucas.segarra on 05/08/2016.
 */
public class Events {
    String myId;
    String teamId;
    Date eventDate;

    public Events(String ev_id, String team_id, Date ev_date){
        myId=ev_id;
        teamId=team_id;
        eventDate=ev_date;
    }

}
