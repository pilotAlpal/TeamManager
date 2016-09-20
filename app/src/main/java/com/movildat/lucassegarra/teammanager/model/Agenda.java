package com.movildat.lucassegarra.teammanager.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by lucas.segarra on 24/08/2016.
 */
public class Agenda implements Serializable {
    private ArrayList<Match> listaProximos, listaUltimos;
    private Match proxPartido;
    private ArrayList<Events> teamEvents;

    public Agenda(ArrayList<Match> proximos,ArrayList<Match> ultimos,Match proxP,ArrayList<Events> eventos){
        listaProximos=proximos;listaUltimos=ultimos;
        proxPartido=proxP;
        teamEvents=eventos;
    }

    public Agenda(){
        proxPartido=new Match();
        teamEvents=new ArrayList<>();
        listaProximos=new ArrayList<>();
        listaUltimos =new ArrayList<>();
    }

    public ArrayList<Match> getNextMatches(){
        return listaProximos;
    }

    public ArrayList<Match> getLastMatches(){
        return listaUltimos;
    }

    public Match getNextMatch(){
        return proxPartido;
    }

    public ArrayList<Events> getTeamEvents(){
        return teamEvents;
    }

    public void addMatch(Match m) {
        if(m.getDate().before(proxPartido.getDate())){
            listaUltimos.add(proxPartido);
            proxPartido=m;
        }
        else {
            listaProximos.add(m);
        }

    }

    public void refreshNextMatch(){
        listaUltimos.add(proxPartido);
        proxPartido=getNextFromList();
        listaProximos.remove(proxPartido);
    }

    private Match getNextFromList() {
        Match prox=listaProximos.get(0);
        for(Match m:listaProximos){
            if(prox.getDate().before(m.getDate())){
                prox=m;
            }
        }
        return prox;
    }

    public void addEvent(Events e){
        teamEvents.add(e);
    }

    public void removeEvent(Events e){
        teamEvents.remove(e);
    }

    public void addToNextMatch(Player p){
        proxPartido.addToConvocatory(p);
    }
    public void removeFromNextMatch(Player p){
        proxPartido.removeFromConvocatory(p);
    }

    public ArrayList<Result> getTeamResults() {
        ArrayList<Result>resultados=new ArrayList<>();
        for(Match m:listaUltimos){
            resultados.add(m.getResult());
        }
        return resultados;
    }
}
