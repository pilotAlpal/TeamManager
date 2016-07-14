package com.movildat.lucassegarra.teammanager;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * Created by lucas.segarra on 14/07/2016.
 */
public class SignInActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
    }

    public void signIn(View view){
        //registrar datos y volver a pantalla login
        finish();
    }
}
