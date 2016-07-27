package com.movildat.lucassegarra.teammanager;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.icu.util.GregorianCalendar;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Date;

/**
 * Created by lucas.segarra on 27/07/2016.
 */
public class RegisterEventActivity extends Activity {

    private  EditText etNomEvento,etLugEvento;
    private DatePicker dpIni,dpFin;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_event);
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
            Date fechaIni=new Date(dpIni.getYear(),dpIni.getMonth(),dpIni.getDayOfMonth());
            Date fechaFin = new Date(dpFin.getYear(),dpFin.getMonth(),dpFin.getDayOfMonth());
            addCalEvIntent=new Intent(Intent.ACTION_INSERT).setData(CalendarContract.Events.CONTENT_URI)
                    .putExtra(CalendarContract.Events.TITLE,nomEventto).putExtra(CalendarContract.Events.EVENT_LOCATION,lugEvent)
                    .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME,fechaIni).putExtra(CalendarContract.EXTRA_EVENT_END_TIME,fechaFin);

        }
        if ((addCalEvIntent.resolveActivity(getPackageManager()))!=null){
            startActivity(addCalEvIntent);
        }
        finish();
    }


}
