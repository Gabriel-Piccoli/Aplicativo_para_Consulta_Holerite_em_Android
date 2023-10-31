package com.example.teladeconsulta;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainConfiguracoes extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_configuracoes);

        //Configuração da variavel btVoltar
        Button btVoltar = findViewById(R.id.btVoltar);
        btVoltar.setOnClickListener(new View.OnClickListener() { //aplica a função de clique no btVoltar
            @Override
            public void onClick(View v) {
                finish(); // Fecha a tela e volta para a tela de consulta de holerite, na activity_main.
            }
        });
    }
}
