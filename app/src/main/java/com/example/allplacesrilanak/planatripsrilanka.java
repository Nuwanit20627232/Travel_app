package com.example.allplacesrilanak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import Detabes.DBhander;

public class planatripsrilanka extends AppCompatActivity {
    EditText groupname,placeofvisit,traveldate,traveltime;
    Button createname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planatripsrilanka);

        groupname =findViewById(R.id.GNC);
        placeofvisit =findViewById(R.id.PVC);
        traveldate =findViewById(R.id.TDC);
        traveltime =findViewById(R.id.TTC);
        createname =findViewById(R.id.creatname);

        createname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBhander dBhander =new DBhander(getApplicationContext());
                long newId=dBhander.addInfo(groupname.getText().toString(),placeofvisit.getText().toString(),traveldate.getText().toString(),traveltime.getText().toString());
                Toast.makeText(getApplicationContext(), "Creating User Id:"+ newId ,Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(planatripsrilanka.this, profilemanagement.class);
                startActivity(intent);

            }
        });


    }
}