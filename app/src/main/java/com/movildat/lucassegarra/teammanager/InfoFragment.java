package com.movildat.lucassegarra.teammanager;

import android.app.Fragment;
import android.content.ContentUris;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.provider.CalendarContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by lucas.segarra on 14/07/2016.
 */
public class InfoFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.info_view, container, false);
    }

    //¿Se puede ejecutar un intent dentro de un fragment?
    public void showCalendar(){
        Uri.Builder builder=CalendarContract.CONTENT_URI.buildUpon();
        builder.appendPath("time");
        ContentUris.appendId(builder, SystemClock.currentThreadTimeMillis());
        Intent calendarIntent=new Intent(Intent.ACTION_VIEW).setData(builder.build());
        this.startActivity(calendarIntent);
    }
    public void showClasif(){

    }


}
