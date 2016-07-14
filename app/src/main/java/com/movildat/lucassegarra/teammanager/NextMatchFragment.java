package com.movildat.lucassegarra.teammanager;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by lucas.segarra on 14/07/2016.
 */
public class NextMatchFragment extends Fragment {
    private TextView proxRiv;
    @Override public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        proxRiv=(TextView)getActivity().findViewById(R.id.eT_prox_rival);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.next_match_view, container, false);
    }
}
