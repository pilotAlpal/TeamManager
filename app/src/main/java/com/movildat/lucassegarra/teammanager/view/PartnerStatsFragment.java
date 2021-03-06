package com.movildat.lucassegarra.teammanager.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RatingBar;
import com.movildat.lucassegarra.teammanager.R;
import com.movildat.lucassegarra.teammanager.controler.Controller;
import java.util.Observable;

/**
 * Created by lucas.segarra on 05/08/2016.
 */
public class PartnerStatsFragment extends ViewFragment{

    private ImageButton callButt,messageBut;
    private RatingBar ratePartner;
    private String partnerId;

    @Override public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.partner_stats_view,container,false);
        View v2=v.findViewById(R.id.layout_contact);
        ratePartner=(RatingBar)v2.findViewById(R.id.r_b_partner);
        ratePartner.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                //pasar numero del compañero
                myController.ratePlayer(v,partnerId);
            }
        });
        callButt=(ImageButton) v2.findViewById(R.id.b_contact_call);
        callButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numero="626992478";
                Intent callIntent=new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:"+numero));
                if (callIntent.resolveActivity(getActivity().getPackageManager())!=null){
                    startActivity(callIntent);
                }
            }
        });
        messageBut=(ImageButton) v2.findViewById(R.id.b_contact_message);
        messageBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String numero="626992478";
                Intent messageIntent=new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", numero, null));
                if(messageIntent.resolveActivity(getActivity().getPackageManager())!=null){
                    startActivity(messageIntent);
                }
            }
        });
        return v;
    }


    public static PartnerStatsFragment newInstance(Controller myController) {
        PartnerStatsFragment partnerStatsFragment=new PartnerStatsFragment();
        partnerStatsFragment.setController(myController);
        return partnerStatsFragment;
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
