package com.example.tcc_davideduard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText etUsuario, etSenha;
    Button btEntrarLogin;

    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsuario = (EditText) findViewById(R.id.etusuario_login);
        etSenha = (EditText) findViewById(R.id.etsenha_login);

        btEntrarLogin = (Button) findViewById(R.id.btEntrarLogin);

        btEntrarLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = getIntent();
                String usuario = etUsuario.getText().toString().trim();
                String senha = etSenha.getText().toString().trim();

                if (usuario.equals(i.getExtras().getString("usuario"))
                    && senha.equals(i.getExtras().getString("senha"))) {
                    i = new Intent(Login.this, Menu.class);
                    startActivity(i);
                } else {
                    Toast.makeText(Login.this, "Login incorreto, tente novamente", Toast.LENGTH_SHORT).show();
                    etUsuario.setText("");
                    etSenha.setText("");
                }
            }
        });
    }
}