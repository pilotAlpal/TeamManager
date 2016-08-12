package com.movildat.lucassegarra.teammanager.model;

import java.util.ArrayList;
import java.util.Observer;

/**
 * Created by Propietario on 12/08/2016.
 */
public class Sesion implements Observable<Sesion.Observador> {
   private ArrayList<Observador> lista;
    public Sesion(){
        lista=new ArrayList<>();
    }
    @Override
    public void addObserver(Observador observer) {
        lista.add(observer);
    }

    @Override
    public void delObserver(Observador observer) {
        lista.remove(observer);
    }
    public interface Observador extends Observer{
        /**
         * añadir aqui notificaciones a la vista
         */
    }
}
