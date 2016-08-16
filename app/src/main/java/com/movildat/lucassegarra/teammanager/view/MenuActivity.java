package com.movildat.lucassegarra.teammanager.view;


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
import com.movildat.lucassegarra.teammanager.model.PlayerStats;
import com.movildat.lucassegarra.teammanager.model.ViewActivity;


/**
 * Created by lucas.segarra on 14/07/2016.
 */

public class MenuActivity extends ViewActivity {

    private OptionsFragment optionsFragment;
    private InfoFragment infoFragment;
    private static int CAM_INTENT_CODE=0;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_view);
        myController=(Controller)getIntent().getSerializableExtra("Controller");
        optionsFragment=(OptionsFragment)getFragmentManager().findFragmentById(R.id.f_ops);
        optionsFragment.setController(myController);
        infoFragment=(InfoFragment)getFragmentManager().findFragmentById((R.id.f_info));
        infoFragment.setController(myController);
    }

    public void statsJugador(View view){
        PlayerStatsFragment pSf=PlayerStatsFragment.newInstance(myController.getMyplayerStats());
        getFragmentManager().beginTransaction().replace(R.id.f_info,pSf).commit();
    }
    public void statsEquipo(View view){
        TeamStatsFragment tSf=TeamStatsFragment.newInstance(myController);
        getFragmentManager().beginTransaction().replace(R.id.f_info,new TeamStatsFragment()).commit();
    }
    public void calendario(View view){
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
        Bundle b=new Bundle();
        b.putSerializable("Controller",myController);
        registerEventIntent.putExtras(b);
        registerEventIntent.setClass(this,RegisterEventActivity.class);
        this.startActivity(registerEventIntent);
    }

    public void addMatch(View v){
        Intent registerMatchIntent=new Intent(MenuActivity.this,RegisterMatchActivity.class);
        Bundle b=new Bundle();
        b.putSerializable("Controller",myController);
        registerMatchIntent.putExtras(b);
        registerMatchIntent.setClass(this,RegisterMatchActivity.class);
        this.startActivity(registerMatchIntent);
    }

    public void partnerClicked(View v){
        TextView t= (TextView) v.findViewById(R.id.tv_name_tmi);
        String s=t.getText().toString();
        PlayerStats pSf=myController.getPlayerStats(s);
        PartnerStatsFragment partnerStatsFragment=PartnerStatsFragment.newInstance(myController,pSf);
        getFragmentManager().beginTransaction().replace(R.id.f_info,partnerStatsFragment).commit();
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
}
