package com.movildat.lucassegarra.teammanager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;

/**
 * Created by lucas.segarra on 14/07/2016.
 */
public class SignInActivity extends Activity {
    private CheckBox cbLog;
    private Spinner spPos;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        cbLog=(CheckBox)findViewById(R.id.cb_sign_and_log);
        spPos=(Spinner) findViewById(R.id.sp_si_pos);
        String[] pos= getResources().getStringArray(R.array.posiciones);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,pos);
        spPos.setAdapter(adapter);
    }

    public void signIn(View view){
        if(cbLog.isChecked()){
            Intent signInIntent=new Intent(SignInActivity.this,MenuActivity.class);
            startActivity(signInIntent);
        }
        //registrar datos y volver a pantalla login
        finish();
    }
}
