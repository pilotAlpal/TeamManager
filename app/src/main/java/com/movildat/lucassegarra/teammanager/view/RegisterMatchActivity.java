package com.movildat.lucassegarra.teammanager.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.format.Time;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.movildat.lucassegarra.teammanager.R;
import com.movildat.lucassegarra.teammanager.controler.Controller;


import java.util.Date;

/**
 * Created by Propietario on 09/08/2016.
 */
public class RegisterMatchActivity extends AppCompatActivity {
    private EditText rival,fecha,hora;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_match);
        rival=(EditText)findViewById(R.id.et_am_rival);
        fecha=(EditText)findViewById(R.id.et_am_fecha);
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
    private boolean validDate(){
        String date=fecha.getText().toString();
        if (date == "") {
            Toast.makeText(this, R.string.fecha_incorrecta, Toast.LENGTH_SHORT).show();
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
        return  rightRival()&&validDate()&&validTime();
    }

    public void saveMatch(View v){/*
        if (validForm()){
            String nRival=rival.getText().toString();
            Date f=new Date(fecha.getText().toString());
            Time h=new Time(hora.getText().toString());
            Controller.registetMatch(nRival,f,h);
        }*/
    }

}
