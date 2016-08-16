package com.movildat.lucassegarra.teammanager.view;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import com.movildat.lucassegarra.teammanager.R;
import com.movildat.lucassegarra.teammanager.controler.Controller;

/**
 * Created by lucas.segarra on 14/07/2016.
 */
public class OptionsFragment extends Fragment{

    private NextMatchFragment nextMatchFragment;
    private Spinner spinner;
    private Controller myController;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }
    public OptionsFragment newInstance(Controller c){
        OptionsFragment opt=new OptionsFragment();
        opt.setController(c);
        return opt;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.options_view, container, false);
        nextMatchFragment=(NextMatchFragment) this.getChildFragmentManager().findFragmentById(R.id.fr_next_match);
        return v;
    }

    public void setController(Controller c){
        myController=c;
        nextMatchFragment.setController(myController);
    }

}
