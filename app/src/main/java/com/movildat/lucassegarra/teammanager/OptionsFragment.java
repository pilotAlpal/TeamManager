package com.movildat.lucassegarra.teammanager;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

/**
 * Created by lucas.segarra on 14/07/2016.
 */
public class OptionsFragment extends Fragment{

    private NextMatchFragment nextMatchFragment;
    private Spinner spinner;
//    private Button bJugador,bEquipo,bCalendar,bClasif

    @Override
    public void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
 //       nextMatchFragment=(NextMatchFragment)getFragmentManager().findFragmentById(R.id.fr_next_match);
        return inflater.inflate(R.layout.options_view, container, false);

    }
    public void hideNextMatchInfo(){
        nextMatchFragment.hideNextMatchInfo();
    }
}
