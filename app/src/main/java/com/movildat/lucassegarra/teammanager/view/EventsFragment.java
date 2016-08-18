package com.movildat.lucassegarra.teammanager.view;

import android.Manifest;
import android.app.Fragment;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.movildat.lucassegarra.teammanager.R;
import com.movildat.lucassegarra.teammanager.controler.Controller;
import com.movildat.lucassegarra.teammanager.model.Events;
import com.movildat.lucassegarra.teammanager.model.Result;
import com.movildat.lucassegarra.teammanager.model.Sesion;
import com.movildat.lucassegarra.teammanager.model.ViewFragment;

import java.util.ArrayList;
import java.util.Observable;


/**
 * Created by lucas.segarra on 19/07/2016.
 */
public class EventsFragment extends ViewFragment {


    private static final int EVENTS_SHOWN =5 ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.events_view,container,false);
        RecyclerView myRecycler=(RecyclerView)v.findViewById(R.id.rv_next_matches);
        myRecycler.setHasFixedSize(true);
        RecyclerView.LayoutManager rvLM=new LinearLayoutManager(getActivity());
        myRecycler.setLayoutManager(rvLM);
        ArrayList<Events> eventos= myController.getEvents(myController.getTeamId());
        Result[] resultados=myController.getResults();
        RecyclerView.Adapter adapter=new CalendarListAdapter(eventos);
        myRecycler.setAdapter(adapter);

        return v;
    }


    @Override
    public void update(Observable observable, Object o) {

    }

    public static EventsFragment newInstance(Controller c) {
        EventsFragment ef=new EventsFragment();
        ef.setController(c);
        return ef;
    }
}
