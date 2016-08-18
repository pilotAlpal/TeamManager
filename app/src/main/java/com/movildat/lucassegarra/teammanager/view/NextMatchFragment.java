package com.movildat.lucassegarra.teammanager.view;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.movildat.lucassegarra.teammanager.R;
import com.movildat.lucassegarra.teammanager.controler.Controller;
import com.movildat.lucassegarra.teammanager.model.Player;

import java.util.ArrayList;

/**
 * Created by lucas.segarra on 14/07/2016.
 */
public class NextMatchFragment extends Fragment {
    private TextView proxRiv,numConfirmados;
    private RecyclerView myRV;
    private Controller myController;
    @Override public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);


    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.next_match_view, container, false);
        proxRiv=(TextView)v.findViewById(R.id.eT_prox_rival);
        numConfirmados=(TextView)v.findViewById(R.id.tv_n_confirmados);
        myRV=(RecyclerView) v.findViewById(R.id.rv_players_layout);
        myRV.setHasFixedSize(true);
        RecyclerView.LayoutManager  myLayoutManager=new LinearLayoutManager(getActivity());
        myRV.setLayoutManager(myLayoutManager);

//        numConfirmados.setText(adapter.getItemCount());
        return v;
    }

    public NextMatchFragment newInstance(Controller c){
        NextMatchFragment nextMF=new NextMatchFragment();
        nextMF.myController=c;
        return nextMF;
    }
    public void setController(Controller c){
        myController=c;
        ArrayList<Player> convocados= myController.getNextConvocatory(myController.getTeamId());
        String[] equipoInvencible=getResources().getStringArray(R.array.equipo_fantasma);
        RecyclerView.Adapter adapter=new PlayersListAdapter(equipoInvencible);
        myRV.setAdapter(adapter);
    }

}
