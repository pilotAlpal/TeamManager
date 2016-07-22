package com.movildat.lucassegarra.teammanager;


import android.app.Activity;
import android.content.ContentUris;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.provider.CalendarContract;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;


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

    public void displayNextMatchInfo(View v){
        getFragmentManager().beginTransaction().replace(R.id.f_info,new NextMatchFragment()).commit();
        optionsFragment.hideNextMatchInfo();
        //  getFragmentManager().beginTransaction().replace(R.id.fr_next_match,new MatchDetailsFragment()).commit();
    }

    public void volver(View view){
        finish();
    }
}
