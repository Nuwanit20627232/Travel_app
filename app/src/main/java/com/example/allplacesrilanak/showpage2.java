package com.example.allplacesrilanak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class showpage2 extends AppCompatActivity {

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showpage2);

        button1 = findViewById(R.id.sigiriyad);
        button2 = findViewById(R.id.polonnaruwad);
        button3 = findViewById(R.id.mirissad);
        button4 = findViewById(R.id.srimahabodiyad);
        button5 = findViewById(R.id.sripadayad);





        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Button Clicked" ,Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(showpage2.this, sigiriyadetails.class);
                startActivity(intent);


            }


        });



        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Button Clicked" ,Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(showpage2.this, polonnaruwadetails.class);
                startActivity(intent);


            }


        });



        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Button Clicked" ,Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(showpage2.this, mirissadetails.class);
                startActivity(intent);


            }


        });



        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Button Clicked" ,Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(showpage2.this, srimahabodiyadetails.class);
                startActivity(intent);


            }


        });



        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Button Clicked" ,Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(showpage2.this, sripadayadetails.class);
                startActivity(intent);


            }


        });






    }
}