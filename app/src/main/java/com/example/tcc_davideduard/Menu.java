package com.example.tcc_davideduard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {

    Button bt_facil, bt_medio, bt_dificil;

    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        bt_facil = (Button) findViewById(R.id.bt_facil);
        bt_medio = (Button) findViewById(R.id.bt_medio);
        bt_dificil = (Button) findViewById(R.id.bt_dificil);

        bt_facil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(Menu.this, Exercicio1.class);
                startActivity(i);
            }
        });

        bt_medio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(Menu.this, Exercicio2.class);
                startActivity(i);
            }
        });

        bt_dificil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(Menu.this, Exercicio3.class);
                startActivity(i);
            }
        });

    }
}