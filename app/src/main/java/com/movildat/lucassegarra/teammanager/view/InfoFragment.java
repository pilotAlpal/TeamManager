package com.movildat.lucassegarra.teammanager.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.movildat.lucassegarra.teammanager.R;
import java.util.Observable;

/**
 * Created by lucas.segarra on 14/07/2016.
 */
public class InfoFragment extends ViewFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.info_view, container, false);
    }


    @Override
    public void update(Observable observable, Object o) {

    }

    @Override
    public void invalidCredentials() {

    }

    @Override
    public void repeatedPlayerID() {

    }

    @Override
    public void repeatedTeamName() {

    }

    @Override
    public void teamDoesNotExist() {

    }
}
