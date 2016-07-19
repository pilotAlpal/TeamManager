package com.movildat.lucassegarra.teammanager;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * Created by lucas.segarra on 15/07/2016.
 */
public class PlayerStatsFragment extends Fragment {
    private Spinner posChooser;
    private ArrayAdapter<String> adapter;
    @Override public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        //¿por qué se inicializa posChooser a null?
        String[] pos= getResources().getStringArray(R.array.posiciones);
        adapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,pos);
       //descomentar linea de abajo cuandom se consiga inicializar bien el Spinner

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.player_stats_view, container, false);
        posChooser=(Spinner) v.findViewById(R.id.sp_pos);
        posChooser.setAdapter(adapter);
        return v;
    }
}
