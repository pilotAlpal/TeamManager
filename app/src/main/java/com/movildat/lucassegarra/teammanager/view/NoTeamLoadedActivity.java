package com.movildat.lucassegarra.teammanager.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import com.movildat.lucassegarra.teammanager.R;

/**
 * Created by lucas.segarra on 30/08/2016.
 */
public class NoTeamLoadedActivity extends ViewActivity {
    private RadioButton rbCrear,rbBuscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_or_search_team_view);
        rbBuscar=(RadioButton) findViewById(R.id.rb_buscar);
        rbCrear=(RadioButton) findViewById(R.id.rb_crear);
    }

    public void createOrLoad(View v){
        if(rbBuscar.isChecked()){//unificar con menuActivity.showTeams
            Intent showTeamsIntent=new Intent();
            Bundle b=new Bundle();
            b.putSerializable("Controller",myController);
            showTeamsIntent.putExtras(b);
            showTeamsIntent.setClass(this,LoadTeamsActivity.class);
            this.startActivity(showTeamsIntent);
        }
        else if(rbCrear.isChecked()){//unificar con menuActivity.newTeam
            Intent newTeamIntent=new Intent();
            Bundle bundle=new Bundle();
            bundle.putSerializable("Controller",myController);
            newTeamIntent.putExtras(bundle);
            newTeamIntent.setClass(this,NewTeamActivity.class);
            startActivity(newTeamIntent);
        }
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
