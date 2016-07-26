package com.movildat.lucassegarra.teammanager;


import android.app.Activity;
import android.content.ContentUris;
import android.content.Intent;
import android.icu.util.GregorianCalendar;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Date;


/**
 * Created by lucas.segarra on 14/07/2016.
 */

public class MenuActivity extends Activity {

    private OptionsFragment optionsFragment;
    private InfoFragment infoFragment;


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        optionsFragment=(OptionsFragment)getFragmentManager().findFragmentById(R.id.f_ops);
        infoFragment=(InfoFragment)getFragmentManager().findFragmentById((R.id.f_info));
    }

    public void statsJugador(View view){
        //pasar nombre del jugador (y equipo) para realizar la consulta
        getFragmentManager().beginTransaction().replace(R.id.f_info,new PlayerStatsFragment()).commit();
    }
    public void statsEquipo(View view){
        //pasar equipo
        getFragmentManager().beginTransaction().replace(R.id.f_info,new TeamStatsFragment()).commit();
    }
    public void calendario(View view){
        //pasar equipo
        getFragmentManager().beginTransaction().replace(R.id.f_info,new EventsFragment()).commit();
    }
    public void clasificacion(View view){
        //pasar equipo
        getFragmentManager().beginTransaction().replace(R.id.f_info,new ClasificStatsFragment()).commit();
    }
    public void showCalendar(View v){
        Uri.Builder builder= CalendarContract.CONTENT_URI.buildUpon();
        builder.appendPath("time");
        ContentUris.appendId(builder, SystemClock.currentThreadTimeMillis());
        Intent calendarIntent=new Intent(Intent.ACTION_VIEW).setData(builder.build());
        this.startActivity(calendarIntent);
    }

    public void addEvent(View v){
        setContentView(R.layout.add_event);
    }

    public void registraEvento(View v){
        setContentView(R.layout.add_event);
        EditText etNomEvento=(EditText) findViewById(R.id.et_ev_titulo);
        String nomEventto=etNomEvento.getText().toString();
        EditText etLugEvento=(EditText) findViewById(R.id.et_ev_lug);
        String lugEvent=etLugEvento.getText().toString();
        DatePicker dpIni=(DatePicker) findViewById(R.id.dp_ini);
        DatePicker dpFin=(DatePicker) findViewById(R.id.dp_fin);
        Intent addCalEvIntent = null;
        GregorianCalendar calendarBeg= null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            calendarBeg = new GregorianCalendar(dpIni.getYear(),
                    dpIni.getMonth(),dpIni.getDayOfMonth());
            Date begin=calendarBeg.getTime();
            GregorianCalendar caledarEnd=new GregorianCalendar(dpFin.getYear(),
                    dpFin.getMonth(),dpFin.getDayOfMonth());
            Date end=caledarEnd.getTime();
            addCalEvIntent=new Intent(Intent.ACTION_INSERT).setData(CalendarContract.Events.CONTENT_URI)
                    .putExtra(CalendarContract.Events.TITLE,nomEventto).putExtra(CalendarContract.Events.EVENT_LOCATION,lugEvent)
                    .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,begin).putExtra(CalendarContract.EXTRA_EVENT_END_TIME,end);

        } else {
            Date fechaIni = new Date(dpIni.getCalendarView().getDate());
            Date fechaFin = new Date(dpFin.getCalendarView().getDate());
            addCalEvIntent=new Intent(Intent.ACTION_INSERT).setData(CalendarContract.Events.CONTENT_URI)
                    .putExtra(CalendarContract.Events.TITLE,nomEventto).putExtra(CalendarContract.Events.EVENT_LOCATION,lugEvent)
                    .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,fechaIni).putExtra(CalendarContract.EXTRA_EVENT_END_TIME,fechaFin);

        }



        if ((addCalEvIntent.resolveActivity(getPackageManager()))!=null){
            startActivity(addCalEvIntent);
        }
        setContentView(R.layout.activity_menu);
    }

    public void displayNextMatchInfo(View v){
        getFragmentManager().beginTransaction().replace(R.id.f_info,new NextMatchFragment()).commit();
        optionsFragment.hideNextMatchInfo();
        //  getFragmentManager().beginTransaction().replace(R.id.fr_next_match,new MatchDetailsFragment()).commit();
    }

    public void volver(View view){
        finish();
    }
}
