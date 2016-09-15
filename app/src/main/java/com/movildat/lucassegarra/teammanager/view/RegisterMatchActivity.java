package com.movildat.lucassegarra.teammanager.view;

import android.icu.util.GregorianCalendar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.movildat.lucassegarra.teammanager.R;
import com.movildat.lucassegarra.teammanager.controler.Controller;
import com.movildat.lucassegarra.teammanager.model.ViewActivity;

import java.util.Date;

/**
 * Created by Propietario on 09/08/2016.
 */
public class RegisterMatchActivity extends ViewActivity {
    private EditText rival,hora;
    private DatePicker fecha;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_match);
        rival=(EditText)findViewById(R.id.et_am_rival);
        fecha=(DatePicker) findViewById(R.id.dp_am);
        hora=(EditText)findViewById(R.id.et_am_hora);
    }
    private boolean rightRival(){
        String name=rival.getText().toString();
        if (name == "") {
            Toast.makeText(this, R.string.rival_vacio, Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
    private boolean validTime(){
        String time=hora.getText().toString();
        if (time == "") {
            Toast.makeText(this, R.string.hora_vacia, Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
    private boolean validForm(){
        return  rightRival()&&validTime();
    }

    public void saveMatch(View v){
        if (validForm()){
            String nRival=rival.getText().toString();
            GregorianCalendar calendarBeg= null;
            Date f;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                calendarBeg = new GregorianCalendar(fecha.getYear(),
                        fecha.getMonth(),fecha.getDayOfMonth());
                f=calendarBeg.getTime();
            }
            else {
                f=new Date(fecha.getYear()-1900,fecha.getMonth(),fecha.getDayOfMonth());
            }
            String h=hora.getText().toString();
            myController.createMatch(nRival,f,h);
            finish();
        }
    }

    @Override
    public void invalidCredentials() {

    }

    @Override
    public void repeatedPlayerID() {

    }

    @Override
    public void repeatedTeamName() {

    }

    @Override
    public void teamDoesNotExist() {

    }
}
