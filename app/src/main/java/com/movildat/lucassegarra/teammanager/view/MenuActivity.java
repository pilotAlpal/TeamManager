package com.movildat.lucassegarra.teammanager.view;


import android.app.Activity;
import android.content.ContentUris;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.provider.CalendarContract;
import android.provider.MediaStore;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.movildat.lucassegarra.teammanager.R;
import com.movildat.lucassegarra.teammanager.controler.Controller;


/**
 * Created by lucas.segarra on 14/07/2016.
 */

public class MenuActivity extends Activity {

    private OptionsFragment optionsFragment;
    private InfoFragment infoFragment;
    private static int CAM_INTENT_CODE=0;
    private Controller myController;

    @Override
    public void onCreate(Bundle savedInstanceState){
        //cagar id_usuario
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_view);
        myController=(Controller)getIntent().getSerializableExtra("Controller");
        optionsFragment=(OptionsFragment)getFragmentManager().findFragmentById(R.id.f_ops);
        optionsFragment.setController(myController);
        infoFragment=(InfoFragment)getFragmentManager().findFragmentById((R.id.f_info));
    }

    public void statsJugador(View view){
        //pasar id_jugador
        getFragmentManager().beginTransaction().replace(R.id.f_info,new PlayerStatsFragment()).commit();
    }
    public void statsEquipo(View view){
        //obtener y pasar id_equipo
        getFragmentManager().beginTransaction().replace(R.id.f_info,new TeamStatsFragment()).commit();
    }
    public void calendario(View view){
        //pasar id_jugador
        EventsFragment eventsFragment=EventsFragment.newInstance(myController);
        getFragmentManager().beginTransaction().replace(R.id.f_info,eventsFragment).commit();
    }
    public void clasificacion(View view){
        //posiblemente excluir de 1ºversion
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
        Intent registerEventIntent = new Intent(MenuActivity.this,RegisterEventActivity.class);
        this.startActivity(registerEventIntent);
    }

    public void addMatch(View v){
        Intent registerMatchIntent=new Intent(MenuActivity.this,RegisterMatchActivity.class);
        this.startActivity(registerMatchIntent);
    }

    public void partnerClicked(View v){
        TextView t= (TextView) v.findViewById(R.id.tv_name_tmi);
        String s=t.getText().toString();
        getFragmentManager().beginTransaction().replace(R.id.f_info,new PartnerStatsFragment()).commit();
    }



    public void volver(View view){
        finish();
    }

    @Override
    public void onActivityResult(int reqCo,int resCo,Intent data){
        if(reqCo==CAM_INTENT_CODE)
            Toast.makeText(this,"photo done",Toast.LENGTH_SHORT);
    }
    public void changePic(View v){
        Intent photoIntent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(photoIntent.resolveActivity(this.getPackageManager())!=null){
            startActivityForResult(photoIntent,CAM_INTENT_CODE);
        }
    }

    public void setController(Controller c){myController=c;}
}
