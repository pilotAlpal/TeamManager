package com.movildat.lucassegarra.teammanager.view;

import android.content.Intent;
import android.icu.util.GregorianCalendar;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import com.movildat.lucassegarra.teammanager.R;
import com.movildat.lucassegarra.teammanager.controler.Controller;
import com.movildat.lucassegarra.teammanager.model.ViewActivity;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by lucas.segarra on 27/07/2016.
 */
public class RegisterEventActivity extends ViewActivity {

    private  EditText etNomEvento,etLugEvento;
    private DatePicker dpIni,dpFin;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_event);
        myController=(Controller)getIntent().getSerializableExtra("Controller");
        etNomEvento=(EditText) findViewById(R.id.et_ev_titulo);
        etLugEvento=(EditText) findViewById(R.id.et_ev_lug);
        dpIni=(DatePicker) findViewById(R.id.dp_ini);
        dpFin=(DatePicker) findViewById(R.id.dp_fin);

    }

    public void registraEvento(View v){
        String nomEventto=etNomEvento.getText().toString();
        String lugEvent=etLugEvento.getText().toString();
        Intent addCalEvIntent = null;
        GregorianCalendar calendarBeg= null;
        Date ini,fin;
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

            ini=begin;fin=end;
        } else {
            Date fechaIni=new Date(dpIni.getYear()-1900,dpIni.getMonth(),dpIni.getDayOfMonth());
            Date fechaFin = new Date(dpFin.getYear()-1900,dpFin.getMonth(),dpFin.getDayOfMonth());
            addCalEvIntent=new Intent(Intent.ACTION_INSERT).setData(CalendarContract.Events.CONTENT_URI)
                    .putExtra(CalendarContract.Events.TITLE,nomEventto).putExtra(CalendarContract.Events.EVENT_LOCATION,lugEvent)
                    .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,fechaIni).putExtra(CalendarContract.EXTRA_EVENT_END_TIME,fechaFin);
            ini=fechaIni;fin=fechaFin;
        }
        if ((addCalEvIntent.resolveActivity(getPackageManager()))!=null){
            myController.createEvent(ini,fin);
            startActivity(addCalEvIntent);
        }
        finish();
    }


}
