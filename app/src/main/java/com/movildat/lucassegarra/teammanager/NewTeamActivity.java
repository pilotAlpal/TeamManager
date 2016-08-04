package com.movildat.lucassegarra.teammanager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

/**
 * Created by lucas.segarra on 03/08/2016.
 */
public class NewTeamActivity extends AppCompatActivity {
    RecyclerView phoneNumbers;
    EditText phoneET;
    PhonesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_team_form);
        phoneNumbers=(RecyclerView) findViewById(R.id.rv_new_team_phones);
        phoneNumbers.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoyManager=new LinearLayoutManager(this);
        phoneNumbers.setLayoutManager(mLayoyManager);
        adapter=new PhonesAdapter();
        phoneNumbers.setAdapter(adapter);
        phoneET=(EditText)findViewById(R.id.et_phone);
    }

    public void addPhone(View v){
        String mateNumber=phoneET.getText().toString();
        phoneET.setText("");
        adapter.addItem(mateNumber);
    }

}
