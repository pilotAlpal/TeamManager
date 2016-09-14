package com.movildat.lucassegarra.teammanager.model;


import android.app.Activity;
import android.os.Bundle;

import com.movildat.lucassegarra.teammanager.controler.Controller;

import java.util.Observable;

/**
 * Created by Propietario on 16/08/2016.
 */
public abstract class ViewActivity extends Activity implements Sesion.Observador {
    protected Controller myController;
    @Override
    public void setController(Controller controller) {
        myController=controller;
        controller.addObserver(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        myController=(Controller)getIntent().getSerializableExtra("Controller");
    }

    @Override
    public void update(Observable observable, Object o) {

    }
}
