package com.movildat.lucassegarra.teammanager.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.movildat.lucassegarra.teammanager.R;

import java.util.ArrayList;

/**
 * Created by lucas.segarra on 03/08/2016.
 */
public class NewTeamActivity extends ViewActivity{

    RecyclerView phoneNumbers;
    EditText phoneET,teamET;
    PhonesAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_team_view);
        phoneNumbers=(RecyclerView) findViewById(R.id.rv_new_team_phones);
        phoneNumbers.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoyManager=new LinearLayoutManager(this);
        phoneNumbers.setLayoutManager(mLayoyManager);
        adapter=new PhonesAdapter();
        phoneNumbers.setAdapter(adapter);
        phoneET=(EditText)findViewById(R.id.et_phone);
        teamET=(EditText)findViewById(R.id.et_n_equipo);
    }

    public void addPhone(View v){
        String mateNumber=phoneET.getText().toString();
        phoneET.setText("");
        adapter.addItem(mateNumber);
    }

    public void createTeam(View v){
        String teamName=teamET.getText().toString();
        teamET.setText("");
        adapter.clear();
        ArrayList<String> equipoInicial=adapter.getValues();
        if (validPhones(equipoInicial)) {
            myController.createTeam(teamName,equipoInicial);
        }
        else Toast.makeText(this,"fallo telefonos",Toast.LENGTH_SHORT).show();
    }

    private boolean validPhones(ArrayList<String> equipoInicial) {
        return true;
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
}
