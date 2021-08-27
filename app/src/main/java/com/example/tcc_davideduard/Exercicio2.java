package com.example.tcc_davideduard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class Exercicio2 extends AppCompatActivity {

    Button btvoltar, btiniciar;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio2);

        btvoltar = (Button) findViewById(R.id.btVoltar);
        btiniciar = (Button) findViewById(R.id.btStart);

        btvoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(Exercicio2.this, Menu.class);
                startActivity(i);
            }
        });

        btiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(Exercicio2.this, Timer.class);
                startActivity(i);
            }
        });
    }

}
