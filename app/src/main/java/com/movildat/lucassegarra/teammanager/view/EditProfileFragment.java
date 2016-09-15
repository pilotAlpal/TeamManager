package com.movildat.lucassegarra.teammanager.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.movildat.lucassegarra.teammanager.R;

import java.util.Observable;

/**
 * Created by lucas.segarra on 26/07/2016.
 */
public class EditProfileFragment extends ViewFragment {
    private Spinner posChooser,teamChooser;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        String[] pos= getResources().getStringArray(R.array.posiciones);
        final ArrayAdapter<String> adapter=new ArrayAdapter<  String>(getActivity(),android.R.layout.simple_spinner_item,pos);
        View v=inflater.inflate(R.layout.edit_profile_view,container,false);
        posChooser=(Spinner) v.findViewById(R.id.sp_change_pos);
        posChooser.setAdapter(adapter);

        posChooser.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                myController.changeMyPos(adapter.getItem(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        teamChooser=(Spinner)v.findViewById(R.id.s_ep_equipo);
        final ArrayAdapter<String> adapter2=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,pos);
        teamChooser.setAdapter(adapter2);
        teamChooser.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                myController.changeTeam(adapter2.getItem(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        return v;
    }



    @Override
    public void update(Observable observable, Object o) {

    }


    public void setTeamAdapter() {
        String[] equipos=myController.getMyTeams();
        ArrayAdapter<String> adapter1=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,equipos);
        teamChooser.setAdapter(adapter1);
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
