package com.example.tcc_davideduard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Cadastro extends AppCompatActivity {

    EditText etUsuario, etSenha, edIdade;
    Button btEntrarCadastro;
    Intent i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        etUsuario = (EditText) findViewById(R.id.etusuario_cadastro);
        etSenha = (EditText) findViewById(R.id.etsenha_cadastro);
        edIdade = (EditText) findViewById(R.id.etidade_cadastro);

        btEntrarCadastro = (Button) findViewById(R.id.btEntrarCadastro);

        btEntrarCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = etUsuario.getText().toString().trim();
                String senha = etSenha.getText().toString().trim();
                if (usuario.equals("") || senha.equals("")) {
                    Toast.makeText(Cadastro.this, "Preencha ambos os campos para registrar", Toast.LENGTH_SHORT).show();
                } else {
                    i = getIntent();
                    i.putExtra("usuario", usuario);
                    i.putExtra("senha", senha);
                    setResult(1, i);
                    finish();
                }
            }
        });

    }
}