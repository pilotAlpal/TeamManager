package com.movildat.lucassegarra.teammanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LogInActivity extends AppCompatActivity {

    private Button bLog,bSign;
    private EditText etName,etPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        etName=(EditText) findViewById(R.id.et_nomUsuario);
        etPass=(EditText) findViewById(R.id.et_contrasena);
    }

    public void login(View view){
       //comparar contraseñas
        Intent menuIntent=new Intent(LogInActivity.this,MenuActivity.class);
        //pasarle al intent info del jugador
        startActivity(menuIntent);
    }
    public void signin(View view){
        Intent signInIntent=new Intent(LogInActivity.this,SignInActivity.class);
        startActivity(signInIntent);
    }

    public void registrateTeam(View v){
        Intent newTeamIntent=new Intent(LogInActivity.this,NewTeamActivity.class);
        startActivity(newTeamIntent);
    }
}
