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
        nextMatchFragment=(NextMatchFragment) this.getChildFragmentManager().findFragmentById(R.id.fr_next_match);
        return v;

    }
    public void replaceNextMatchInfo(){
        /*
        * ¿Por qué me da runtimeException
        *
        *  getFragmentManager().beginTransaction().replace(R.id.f_info,nextMatchFragment).commit();
        * */
        getFragmentManager().beginTransaction().replace(R.id.f_info,new NextMatchFragment()).commit();
        //Intentar evitar esta llamada a hide
        getFragmentManager().beginTransaction().hide(getChildFragmentManager().findFragmentById(R.id.fr_next_match)).commit();
        getFragmentManager().beginTransaction().replace(R.id.left_bellow_ly,new MatchDetailsFragment()).commit();
//        nextMatchFragment.replaceNextMatchInfo();
    }


}
