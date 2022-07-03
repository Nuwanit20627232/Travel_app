package com.example.allplacesrilanak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private Button button6;
    private Button button7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button6 = findViewById(R.id.btnall);
        button7 = findViewById(R.id.planvisit);

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(), "Button Clicked" ,Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this, showpage2.class);
                startActivity(intent);

            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Button Clicked" ,Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this, planatripsrilanka.class);
                startActivity(intent);
            }


        });
    }


}