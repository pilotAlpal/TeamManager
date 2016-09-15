package com.movildat.lucassegarra.teammanager.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Calendar;

/**
 * Created by lucas.segarra on 05/08/2016.
 */
public class Events implements Serializable{
    String myId;
    Date eventDate;

    public Events(String ev_id){
        myId=ev_id;
        eventDate= Calendar.getInstance().getTime();
    }

    public Events(String ev_id,Date date){}

    public Date getEventDate(){
        return eventDate;
    }

    public String getId(){return myId;}

}
