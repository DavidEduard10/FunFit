package com.example.tcc_davideduard;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button bt_login, bt_cadastro;
    String usuario="", senha="";

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1 && resultCode == 1 && data != null) {
            usuario = data.getExtras().getString("usuario");
            senha = data.getExtras().getString("senha");
            Toast.makeText(this, "Dados de Login atualizados", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_cadastro = findViewById(R.id.bt_cadastro);
        bt_login = findViewById(R.id.bt_login);

        bt_cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Cadastro.class);
                startActivityForResult(i, 1);
            }
        });

        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (usuario.equals("") || senha.equals("")) {
                    Toast.makeText(MainActivity.this, "Cadastre-se antes de fazer login!", Toast.LENGTH_SHORT).show();
                } else {
                    Intent i = new Intent(MainActivity.this, Login.class);
                    i.putExtra("usuario", usuario);
                    i.putExtra("senha", senha);
                    startActivity(i);
                }
            }
        });
    }

    protected void onStart() {
        super.onStart();
        Log.i("APP", "onStart");
    }

    protected void onResume() {
        super.onResume();
        Log.i("APP", "onResume");
    }

    protected void onRestart() {
        super.onRestart();
        Log.i("APP", "onRestart");
    }

    protected void onPause() {
        super.onPause();
        Log.i("APP", "onPause");
    }

    protected void onStop() {
        super.onStop();
        Log.i("APP", "onStop");
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.i("APP", "onDestroy");
    }

}
