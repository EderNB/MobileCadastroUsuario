package com.example.cadastrousurio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FormCadastro extends AppCompatActivity {

    Button button_consultar;
    Button botaoSalvar;
    EditText editNome;
    EditText editEmail;
    EditText editSenha;
    String ARQUIVO = "Arq_Pref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_cadastro);

        getSupportActionBar().hide();
        IniciarCompomentes();

        editNome = findViewById(R.id.edit_nome);
        editEmail = findViewById(R.id.edit_email);
        editSenha = findViewById(R.id.edit_senha);
        botaoSalvar = findViewById(R.id.button_salvar);
        editNome.requestFocus();

        button_consultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(FormCadastro.this, TelaPrincipal.class);
                startActivity(intent);
            }
        });

        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences preferencias = getSharedPreferences(ARQUIVO, 0);
                SharedPreferences.Editor editor = preferencias.edit();

                if(editNome.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Campo Nome Obrigatório", Toast.LENGTH_LONG).show();
                }

                else if(editEmail.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Campo E-mail Obrigatório", Toast.LENGTH_LONG).show();
                }
                else if(editSenha.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Campo Senha Obrigatório", Toast.LENGTH_LONG).show();
                }
                else {
                    String nome =  editNome.getText().toString();
                    editor.putString("nome",nome);

                    String email =  editEmail.getText().toString();
                    editor.putString("email",email);

                    String senha =  editSenha.getText().toString();
                    editor.putString("senha",senha);

                    editor.commit();

                    Toast.makeText(getApplicationContext(), "Cadastrado com êxito! ", Toast.LENGTH_LONG).show();
                }

            }
        });





    }

    private void IniciarCompomentes() {
        button_consultar = findViewById(R.id.button_consultar);
    }
}