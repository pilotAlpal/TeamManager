package com.movildat.lucassegarra.teammanager.view;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.movildat.lucassegarra.teammanager.R;
import com.movildat.lucassegarra.teammanager.controler.Controller;
import com.movildat.lucassegarra.teammanager.model.Sesion;

import java.util.Observable;

/**
 * Created by lucas.segarra on 05/08/2016.
 */
public class PartnerStatsFragment extends Fragment implements Sesion.Observador{

    private ImageButton callButt,messageBut;

    @Override public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.partner_stats_view,container,false);
        View v2=v.findViewById(R.id.layout_contact);
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

    @Override
    public void update(Observable observable, Object o) {

    }

    @Override
    public void setController(Controller controller) {

    }
}
