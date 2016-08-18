package com.movildat.lucassegarra.teammanager.view;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.movildat.lucassegarra.teammanager.R;
import com.movildat.lucassegarra.teammanager.controler.Controller;
import com.movildat.lucassegarra.teammanager.model.ViewFragment;

import java.util.ArrayList;
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
        ArrayAdapter<String> adapter=new ArrayAdapter<  String>(getActivity(),android.R.layout.simple_spinner_item,pos);
        View v=inflater.inflate(R.layout.edit_profile_view,container,false);
        posChooser=(Spinner) v.findViewById(R.id.sp_change_pos);
        posChooser.setAdapter(adapter);
        teamChooser=(Spinner)v.findViewById(R.id.s_ep_equipo);

/*        posChooser.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                myController.changeMyPos();
            }
        });*/


        /*teamChooser.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                myController.changeTeam();
            }
        });*/
        return v;
    }



    @Override
    public void update(Observable observable, Object o) {

    }


    private void setTeamAdapter() {
        String[] equipos=myController.getMyTeams();
        ArrayAdapter<String> adapter1=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,equipos);
        teamChooser.setAdapter(adapter1);
    }


}
