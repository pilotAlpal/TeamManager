package com.movildat.lucassegarra.teammanager;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * Created by lucas.segarra on 14/07/2016.
 */
public class PlayersFragment extends Fragment {
    private RecyclerView myRV;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager myLayoutManager;
    private ListView listView;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //referenciar a objeto recyClerView construir un adapter
        //e inicializarlo con dicho adapter y con un LinearLayoutMangaer
        //RecyclerView=(RecyclerView)getActivity().findViewById(R.id.rv_players);
        //llenar listView con lista de los jugadores del equipo
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.players_view,container,false);
        myRV=(RecyclerView) v.findViewById(R.id.rv_players);
        myRV.setHasFixedSize(true);
        myLayoutManager=new LinearLayoutManager(getActivity());
        myRV.setLayoutManager(myLayoutManager);
        // String[] equipoInvencible=getResources().getStringArray(R.array.equipo_fantasma);
        String[] otroEquipo={"Albelda","Baraja"};
        adapter=new PlayersListAdapter(otroEquipo);
        myRV.setAdapter(adapter);
        return inflater.inflate(R.layout.players_view, container, false);
    }
}
