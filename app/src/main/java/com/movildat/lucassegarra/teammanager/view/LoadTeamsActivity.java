package com.movildat.lucassegarra.teammanager.view;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.movildat.lucassegarra.teammanager.R;
import com.movildat.lucassegarra.teammanager.controler.Controller;
import com.movildat.lucassegarra.teammanager.model.ViewActivity;

/**
 * Created by Propietario on 18/08/2016.
 */
public class LoadTeamsActivity extends ViewActivity {
    private EditText etTeamName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myController=(Controller)getIntent().getSerializableExtra("Controller");
        setContentView(R.layout.load_teams_view);
        etTeamName=(EditText)findViewById(R.id.et_team_name);
    }

    public void enrollTeam(View v){
        String tName=etTeamName.getText().toString();
        if(myController.enrollTeam(tName)){

        }

    }
}
