package com.movildat.lucassegarra.teammanager;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * Created by lucas.segarra on 26/07/2016.
 */
public class EditProfileFragment extends Fragment {
    private Spinner posChooser;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        String[] pos= getResources().getStringArray(R.array.posiciones);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,pos);
        View v=inflater.inflate(R.layout.edit_profile_view,container,false);
        posChooser=(Spinner) v.findViewById(R.id.sp_change_pos);
        posChooser.setAdapter(adapter);
        return v;


    }
}
