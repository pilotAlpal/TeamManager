package com.movildat.lucassegarra.teammanager;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;

/**
 * Created by lucas.segarra on 14/07/2016.
 */
public class OptionsFragment extends Fragment{

    private Spinner spinner;
//    private Button bJugador,bEquipo,bCalendar,bClasif

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.options_view, container, false);
    }
}
