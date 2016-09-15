package com.movildat.lucassegarra.teammanager.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.movildat.lucassegarra.teammanager.R;
import com.movildat.lucassegarra.teammanager.controler.Controller;
import com.movildat.lucassegarra.teammanager.model.Sesion;

import java.util.Observable;

public class LogInActivity extends Activity implements Sesion.Observador{

    private EditText etPhone,etPass;
    private Controller myController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in_view);
        etPhone =(EditText) findViewById(R.id.et_li_telefono);
        etPass=(EditText) findViewById(R.id.et_contrasena);
    }

    /**
     * Permite al usuario empezar la acción de loggearse
     * @param view vista desde la que se invoca al método
     */
    public void login(View view){
        String telf= etPhone.getText().toString();
        String pass=etPass.getText().toString();
        myController=new Controller();
        myController.login(telf,pass);
        Intent menuIntent = new Intent();
        Bundle bundle=new Bundle();
        bundle.putSerializable("Controller",myController);
        menuIntent.putExtras(bundle);
        menuIntent.setClass(this,MenuActivity.class);
        startActivity(menuIntent);
    }

    public void signin(View view){
        Intent signInIntent=new Intent(LogInActivity.this,SignInActivity.class);
        startActivity(signInIntent);
    }


    @Override
    public void setController(Controller controller) {
        myController=controller;
        controller.addObserver(this);
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

    @Override
    public void update(Observable observable, Object o) {

    }
}
