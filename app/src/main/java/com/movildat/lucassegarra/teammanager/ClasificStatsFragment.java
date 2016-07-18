package com.movildat.lucassegarra.teammanager;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by lucas.segarra on 18/07/2016.
 */
public class ClasificStatsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState){
        return inflater.inflate(R.layout.clasification_view,viewGroup, false);
    }
}
