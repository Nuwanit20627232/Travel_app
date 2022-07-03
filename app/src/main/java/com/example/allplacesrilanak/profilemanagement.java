package com.example.allplacesrilanak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import Detabes.DBhander;

public class profilemanagement extends AppCompatActivity {
    EditText groupname,placeofvisit,traveldate,traveltime;
    Button update,delete,search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planatripsrilanka);

        groupname =findViewById(R.id.PMGN);
        placeofvisit =findViewById(R.id.PMPV);
        traveldate =findViewById(R.id.PMTD);
        traveltime =findViewById(R.id.PMTT);
        search=findViewById(R.id.search1);
        update =findViewById(R.id.PMUP);
        delete=findViewById(R. id .pmdele);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBhander dBhander = new DBhander(getApplicationContext());
                List user= dBhander.readAllinfo(groupname.getText().toString());
                if (user.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "No User", Toast.LENGTH_SHORT).show();
                    groupname.setText(null);
                }
                else {
                    Toast.makeText(getApplicationContext(), "User Found User:"+user.get(0) .toString(), Toast.LENGTH_SHORT).show();
                    groupname.setText(user.get(0).toString());
                    placeofvisit.setText(user.get(1).toString());
                    traveldate.setText(user.get(2).toString());
                    traveltime.setText(user.get(3).toString());

                }
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBhander dBhander = new DBhander(getApplicationContext());
                Boolean status = dBhander.updateInfo(groupname.getText().toString(), placeofvisit.getText().toString(), traveldate.getText().toString(), traveltime.getText().toString());
                if (status){
                    Toast.makeText(getApplicationContext(), "User Updated", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), " Updated Fail", Toast.LENGTH_SHORT).show();


                }
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBhander dBhander = new DBhander(getApplicationContext());

                dBhander.deleteInfo(groupname.getText().toString());
                Toast.makeText(getApplicationContext(), "User Delete", Toast.LENGTH_SHORT).show();

                groupname.setText(null);
                placeofvisit.setText(null);
                traveldate.setText(null);
                traveltime.setText(null);
            }
        });



    }
}