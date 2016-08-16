package com.movildat.lucassegarra.teammanager.view;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.movildat.lucassegarra.teammanager.R;
import com.movildat.lucassegarra.teammanager.controler.Controller;
import com.movildat.lucassegarra.teammanager.model.Sesion;
import com.movildat.lucassegarra.teammanager.model.ViewFragment;

import java.util.Observable;

/**
 * Created by lucas.segarra on 15/07/2016.
 */
public class PlayerStatsFragment extends ViewFragment {


    @Override public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.player_stats_view,container,false);

    }

    @Override
    public void update(Observable observable, Object o) {
        return;
    }

    @Override
    public void setController(Controller controller) {

    }

    public static PlayerStatsFragment newInstance(Controller myController) {
        PlayerStatsFragment pSf=new PlayerStatsFragment();
        pSf.setController(myController);
        return pSf;
    }
}
