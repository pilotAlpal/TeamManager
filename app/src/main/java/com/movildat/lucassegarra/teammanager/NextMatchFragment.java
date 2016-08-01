package com.movildat.lucassegarra.teammanager;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by lucas.segarra on 14/07/2016.
 */
public class NextMatchFragment extends Fragment {
    private TextView proxRiv;
    private RecyclerView myRV;
    @Override public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);


    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.next_match_view, container, false);
        proxRiv=(TextView)v.findViewById(R.id.eT_prox_rival);
        myRV=(RecyclerView) v.findViewById(R.id.rv_players_layout);
        myRV.setHasFixedSize(true);
        RecyclerView.LayoutManager  myLayoutManager=new LinearLayoutManager(getActivity());
        myRV.setLayoutManager(myLayoutManager);
        String[] equipoInvencible=getResources().getStringArray(R.array.equipo_fantasma);
        RecyclerView.Adapter adapter=new PlayersListAdapter(equipoInvencible);
        myRV.setAdapter(adapter);
        return v;
    }
    public void replaceNextMatchInfo(){
        FragmentManager myFM=getFragmentManager();
            myFM.beginTransaction().replace(R.id.fr_next_match,new MatchDetailsFragment()).commit();
    }
}
