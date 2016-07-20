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


  //  private InfoFragment fInfo;
  //  private OptionsFragment fOps;
    private RecyclerView myRV;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager myLayoutManager;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        myRV=(RecyclerView) findViewById(R.id.rv_players);
        myRV.setHasFixedSize(true);
        myLayoutManager=new LinearLayoutManager(this);
        myRV.setLayoutManager(myLayoutManager);
       // String[] equipoInvencible=getResources().getStringArray(R.array.equipo_fantasma);
        String[] otroEquipo={"Albelda","Baraja"};
        adapter=new PlayersListAdapter(otroEquipo);

       // myRV.setAdapter(adapter);

      //  adapter.fillList(getResources().getStringArray(R.array.equipo_fantasma));

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

    public void volver(View view){
        finish();
    }
}
