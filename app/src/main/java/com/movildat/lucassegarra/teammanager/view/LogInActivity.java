package com.movildat.lucassegarra.teammanager.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.movildat.lucassegarra.teammanager.R;
import com.movildat.lucassegarra.teammanager.controler.Controller;
import com.movildat.lucassegarra.teammanager.model.Sesion;

import java.util.Observable;

public class LogInActivity extends AppCompatActivity implements Sesion.Observador{

    private Button bLog,bSign;
    private EditText etName,etPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in_view);
        etName=(EditText) findViewById(R.id.et_nomUsuario);
        etPass=(EditText) findViewById(R.id.et_contrasena);
    }

    public void login(View view){
        String nombre=etName.getText().toString();
        String pass=etPass.getText().toString();
        Controller controller=new Controller();
        if(controller.validLogin(nombre,pass)) {
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

    public void registrateTeam(View v){
        Intent newTeamIntent=new Intent(LogInActivity.this,NewTeamActivity.class);
        Controller controller=new Controller();
        Bundle bundle=new Bundle();
        bundle.putSerializable("Controller",controller);
        newTeamIntent.putExtras(bundle);
        newTeamIntent.setClass(this,NewTeamActivity.class);
        startActivity(newTeamIntent);
    }

    @Override
    public void setController(Controller controller) {

    }

    @Override
    public void update(Observable observable, Object o) {

    }
}
