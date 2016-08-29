package com.movildat.lucassegarra.teammanager.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.movildat.lucassegarra.teammanager.R;
import com.movildat.lucassegarra.teammanager.controler.Controller;
import com.movildat.lucassegarra.teammanager.model.Sesion;

import java.util.Observable;

public class LogInActivity extends AppCompatActivity implements Sesion.Observador{

    private EditText etPhone,etPass;

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
        Controller controller=new Controller();
        if(controller.validLogin(telf,pass)) {
            Intent menuIntent = new Intent();
            Bundle bundle=new Bundle();
            bundle.putSerializable("Controller",controller);
            menuIntent.putExtras(bundle);
            menuIntent.setClass(this,MenuActivity.class);
            startActivity(menuIntent);
        }
    }

    public void signin(View view){
        Intent signInIntent=new Intent(LogInActivity.this,SignInActivity.class);
        startActivity(signInIntent);
    }

    @Override
    public void setController(Controller controller) {

    }

    @Override
    public void update(Observable observable, Object o) {

    }
}
