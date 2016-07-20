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

    @Override public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String[] pos= getResources().getStringArray(R.array.posiciones);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,pos);
        View v=inflater.inflate(R.layout.player_stats_view,container,false);
        posChooser=(Spinner) v.findViewById(R.id.sp_pos);
        posChooser.setAdapter(adapter);
        return v;
    }
}
