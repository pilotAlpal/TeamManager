package com.movildat.lucassegarra.teammanager;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.View;

/**
 * Created by lucas.segarra on 14/07/2016.
 */

public class MenuActivity extends Activity {

    InfoFragment fInfo;
    OptionsFragment fOps;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        /*leer y guardar info del jugador:
                                            nombre
                                            lista<equipos>
         */
        fInfo=(InfoFragment) getFragmentManager().findFragmentById(R.id.f_info);
        fOps=(OptionsFragment)getFragmentManager().findFragmentById(R.id.f_ops);
    }

    public void statsJugador(View view){
        getFragmentManager().beginTransaction().add(R.id.f_info,new PlayerStatsFragment()).commit();
    }
    public void statsEquipo(View view){
        //pasar equipo
        getFragmentManager().beginTransaction().add(R.id.f_info,new TeamStatsFragment()).commit();
        // fInfo.showTeamStats();
    }
    public void calendario(View view){
        //pasar equipo
        fInfo.showCalendar();
    }
    public void clasificacion(View view){
        //pasar equipo
        getFragmentManager().beginTransaction().add(R.id.f_info,new ClasificStatsFragment()).commit();
    }
    public void volver(View view){
        finish();
    }
}
