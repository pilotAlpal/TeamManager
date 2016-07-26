package com.movildat.lucassegarra.teammanager;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
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
        View v=inflater.inflate(R.layout.options_view, container, false);
        FragmentManager fM=getFragmentManager();
        nextMatchFragment=(NextMatchFragment) this.getChildFragmentManager().findFragmentById(R.id.fr_next_match);
        return v;

    }
    public void hideNextMatchInfo(){
        //ninguna de estas 3 llamadas funciona cómo quiero, es decir no se oculta el nextMatchFragment dentro del optionsFragment
        //this.getChildFragmentManager().beginTransaction().replace(R.id.fr_next_match,new MatchDetailsFragment()).commit();
        getFragmentManager().beginTransaction().replace(nextMatchFragment.getId(),new MatchDetailsFragment()).commit();
       // nextMatchFragment.hideNextMatchInfo();
    }
}
