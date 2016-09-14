package com.movildat.lucassegarra.teammanager.view;

        import android.app.Fragment;
        import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;

        import com.movildat.lucassegarra.teammanager.R;
        import com.movildat.lucassegarra.teammanager.model.ViewFragment;

        import java.util.Observable;

/**
 * Created by lucas.segarra on 22/07/2016.
 */
public class MatchDetailsFragment extends ViewFragment {
    @Override
    public void onCreate(Bundle savedInstanceSate){
        super.onCreate(savedInstanceSate);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup,Bundle savedInstanceState){
        return inflater.inflate(R.layout.match_details_layout,viewGroup,false);
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
