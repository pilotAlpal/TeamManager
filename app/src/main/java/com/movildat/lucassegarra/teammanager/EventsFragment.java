package com.movildat.lucassegarra.teammanager;

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

import static android.support.v7.widget.RecyclerView.*;

/**
 * Created by lucas.segarra on 19/07/2016.
 */
public class EventsFragment extends Fragment {

    public static final String[] EVENT_PROJECTION = new String[]{
            CalendarContract.Calendars._ID,                           // 0
            CalendarContract.Calendars.ACCOUNT_NAME,                  // 1
            CalendarContract.Calendars.CALENDAR_DISPLAY_NAME,         // 2
            CalendarContract.Calendars.OWNER_ACCOUNT                  // 3
    };
    public final int EVENTS_SHOWN=7;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.events_view,container,false);
        RecyclerView myRecycler=(RecyclerView)v.findViewById(R.id.rv_next_matches);
        myRecycler.setHasFixedSize(true);
        RecyclerView.LayoutManager rvLM=new LinearLayoutManager(getActivity());
        myRecycler.setLayoutManager(rvLM);
        Cursor cursor = null;
        ContentResolver cResolver = getActivity().getContentResolver();
        Uri uri = CalendarContract.Calendars.CONTENT_URI;
        String selection = "((" + CalendarContract.Calendars.ACCOUNT_TYPE + " = ?))";
        String[] sArgs = new String[]{"com.movildat"};
        String[] eventos=new String[EVENTS_SHOWN];
        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_CALENDAR) != PackageManager.PERMISSION_GRANTED) {
            cursor = cResolver.query(uri, EVENT_PROJECTION, selection, sArgs, null);
            int eS=0;
            while ((eS<EVENTS_SHOWN)&&(cursor.moveToNext())){
                eventos[eS]=cursor.getString(2);
            }
            if(eS>0){
                RecyclerView.Adapter adapter=new CalendarListAdapter(eventos);
                myRecycler.setAdapter(adapter);
            }
        }
        return v;
    }

}
