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
import com.movildat.lucassegarra.teammanager.model.Sesion;

/**
 * Created by lucas.segarra on 14/07/2016.
 */
public class SignInActivity extends Activity {
//    private CheckBox cbLog;

    private Spinner spPos;
    private EditText etNombre,etContrasena,etEquipo,etTelefono;
    private Controller myController;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
     //   cbLog=(CheckBox)findViewById(R.id.cb_sign_and_log);
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
            myController=new Controller();
            if(myController.validLogin(tel,pass)){
                if(!team.equalsIgnoreCase("")) {
                    if (myController.existTeam(team))
                        if (myController.createPlayer(name,pass,tel,posicion,team))
                            raiseMenuIntent();
                    else
                        Toast.makeText(this,"Team does not exist",Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent findTeamIntent = new Intent();
                    Bundle bundle=new Bundle();
                    bundle.putSerializable("Controller",myController);
                    findTeamIntent.putExtras(bundle);
                    findTeamIntent.setClass(this,NoTeamLoadedActivity.class);
                    startActivity(findTeamIntent);
                }
            }
            else{
                Toast.makeText(this,"Invalid login",Toast.LENGTH_SHORT).show();
            }
            finish();
        }
    }

    private void raiseMenuIntent(){
        Intent signInIntent = new Intent();
        Bundle bundle=new Bundle();
        bundle.putSerializable("Controller",myController);
        signInIntent.putExtras(bundle);
        signInIntent.setClass(this,MenuActivity.class);
        startActivity(signInIntent);
    }



    private boolean validPhone() {
        String tel=etTelefono.getText().toString();
        if (tel.equalsIgnoreCase("") ) {
      //      Toast.makeText(this, R.string.equipo_vacio, Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
    private boolean validTeam(){
    /*    String team=etEquipo.getText().toString();
        if (team.equalsIgnoreCase("")) {
            Toast.makeText(this, R.string.equipo_vacio, Toast.LENGTH_SHORT).show();
            return false;
        }*/
        return true;
    }
    private boolean validPass() {
        String pass = etContrasena.getText().toString();
        if (pass.equalsIgnoreCase("")) {
  //          Toast.makeText(this, R.string.password_vacio, Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
    private boolean validName() {
        String name = etNombre.getText().toString();
        return !name.equalsIgnoreCase("");
    }
}
