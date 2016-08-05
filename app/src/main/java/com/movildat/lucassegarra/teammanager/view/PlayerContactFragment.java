package com.movildat.lucassegarra.teammanager.view;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.movildat.lucassegarra.teammanager.R;

/**
 * Created by lucas.segarra on 26/07/2016.
 */
public class PlayerContactFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        return inflater.inflate(R.layout.contact_partner_view,container,false);
    }
}
