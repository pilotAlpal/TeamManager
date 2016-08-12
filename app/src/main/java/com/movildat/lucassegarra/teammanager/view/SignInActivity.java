package com.movildat.lucassegarra.teammanager.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.movildat.lucassegarra.teammanager.R;
import com.movildat.lucassegarra.teammanager.controler.Controller;

/**
 * Created by lucas.segarra on 14/07/2016.
 */
public class SignInActivity extends Activity {
    private CheckBox cbLog;
    private Spinner spPos;
    private EditText etNombre,etContrasena,etEquipo,etTelefono;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        cbLog=(CheckBox)findViewById(R.id.cb_sign_and_log);
        spPos=(Spinner) findViewById(R.id.sp_si_pos);
        String[] pos= getResources().getStringArray(R.array.posiciones);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,pos);
        spPos.setAdapter(adapter);
        etNombre=(EditText) findViewById(R.id.et_si_nomUsuario);
        etContrasena=(EditText) findViewById(R.id.et_si_contrasena);
        etEquipo=(EditText) findViewById(R.id.et_si_equipo);
        etTelefono=(EditText) findViewById(R.id.et_si_telefono);
    }

    public void signIn(View view) {
        boolean rightForm = validName() && validPass() && validTeam() && validPhone();
        if (rightForm) {
            String tel=etTelefono.getText().toString();
            String team=etEquipo.getText().toString();
            String pass = etContrasena.getText().toString();
            String name = etNombre.getText().toString();
            String posicion=(String)spPos.getSelectedItem();
            Controller.createPlayer(name,pass,team,tel,posicion);
            if (cbLog.isChecked()) {
                Intent signInIntent = new Intent(SignInActivity.this, MenuActivity.class);
                startActivity(signInIntent);
            }
            finish();
        }
    }

    private boolean validPhone() {
        String tel=etTelefono.getText().toString();
        if (tel == "") {
            Toast.makeText(this, R.string.equipo_vacio, Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
    private boolean validTeam(){
        String team=etEquipo.getText().toString();
        if (team == "") {
            Toast.makeText(this, R.string.equipo_vacio, Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
    private boolean validPass() {
        String pass = etContrasena.getText().toString();
        if (pass == "") {
            Toast.makeText(this, R.string.password_vacio, Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
    private boolean validName() {
        String name = etNombre.getText().toString();
        if (name == "") {
            Toast.makeText(this, R.string.nombre_vacio, Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

}