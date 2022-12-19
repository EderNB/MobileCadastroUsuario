package com.example.cadastrousurio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.inputmethod.InputContentInfoCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FormLogin extends AppCompatActivity {

    private TextView text_tela_cadastro;
    Button bt_entrar;

    EditText editEmail;
    EditText editSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_login);

        getSupportActionBar().hide();

        editEmail = findViewById(R.id.edit_email);
        editSenha = findViewById(R.id.edit_senha);

        IniciarCompomentes();

        text_tela_cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String lsemail, lssenha;

                SharedPreferences prefs = getSharedPreferences("Arq_Pref", 0);
                lsemail=prefs.getString("email","");
                lssenha=prefs.getString("senha","");

                if(editEmail.getText().toString() =="adm@adm.com.br" &&  editSenha.getText().toString() =="123")  {

                    Intent intent = new Intent(FormLogin.this, FormCadastro.class);
                    startActivity(intent);
                }
                else if(editEmail.getText().toString() ==lsemail &&  editSenha.getText().toString() ==lssenha) {
                    Intent intent = new Intent(FormLogin.this, FormCadastro.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(), " Contate a administração!!  Usu: adm@adm.com.br / Senha: adm  ", Toast.LENGTH_LONG).show();
                }
            }
        });


        bt_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String lsemail, lssenha;

                SharedPreferences prefs = getSharedPreferences("Arq_Pref", 0);
                lsemail=prefs.getString("email","");
                lssenha=prefs.getString("senha","");

                if(editEmail.getText().toString() =="adm@adm.com.br" &&  editSenha.getText().toString() =="123")  {

                    Intent intent = new Intent(FormLogin.this, TelaPrincipal.class);
                    startActivity(intent);
                }
                else if(editEmail.getText().toString() ==lsemail &&  editSenha.getText().toString() ==lssenha) {
                    Intent intent = new Intent(FormLogin.this, TelaPrincipal.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(), " Contate a administração!!  Usu: adm@adm.com.br / Senha: adm  ", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void IniciarCompomentes() {
        text_tela_cadastro = findViewById(R.id.text_tela_cadastro);
    }

}