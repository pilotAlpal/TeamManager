package com.movildat.lucassegarra.teammanager.model;

import android.app.Fragment;

import com.movildat.lucassegarra.teammanager.controler.Controller;

/**
 * Created by lucas.segarra on 16/08/2016.
 */
public abstract class ViewFragment extends Fragment implements Sesion.Observador {
    protected Controller myController;
    public void setController(Controller c){myController=c;}
}
