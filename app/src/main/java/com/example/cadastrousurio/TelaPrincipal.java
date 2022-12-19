package com.example.cadastrousurio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TelaPrincipal extends AppCompatActivity {

    Button botaoConsultar;
    TextView textLista;
    String ARQUIVO = "Arq_Pref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);
        getSupportActionBar().hide();

        botaoConsultar = findViewById(R.id.button_listar);

       botaoConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String lsnome, lsemail, lssenha;

                SharedPreferences prefs = getSharedPreferences(ARQUIVO, 0);

                lsnome=prefs.getString("nome","" );
                lsemail=prefs.getString("email","");
                lssenha=prefs.getString("senha","");

                textLista.setText(lsnome+" | "+lsemail+" | "+ lssenha);

            }
        });
    }
}