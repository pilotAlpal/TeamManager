package com.movildat.lucassegarra.teammanager.view;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.movildat.lucassegarra.teammanager.R;

/**
 * Created by lucas.segarra on 22/07/2016.
 */
public class MatchDetailsFragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceSate){
        super.onCreate(savedInstanceSate);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup,Bundle savedInstanceState){
       return inflater.inflate(R.layout.match_details_layout,viewGroup,false);
    }
}