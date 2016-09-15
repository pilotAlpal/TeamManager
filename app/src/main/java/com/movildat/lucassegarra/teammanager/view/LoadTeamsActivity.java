package com.movildat.lucassegarra.teammanager.view;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.movildat.lucassegarra.teammanager.R;

/**
 * Created by Propietario on 18/08/2016.
 */
public class LoadTeamsActivity extends ViewActivity {
    private EditText etTeamName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.load_teams_view);
        etTeamName=(EditText)findViewById(R.id.et_team_name);
    }

    public void enrollTeam(View v){
        String tName=etTeamName.getText().toString();
        myController.enrollTeam(tName);
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
