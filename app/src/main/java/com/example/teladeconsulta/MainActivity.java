package com.example.teladeconsulta;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btSair = findViewById(R.id.btSair); //Variavel para relacionar executar o bt sair
        AppCompatButton btConta = findViewById(R.id.btConta); //Variavel para executar o bt Conta

        Spinner spinnerAno = findViewById(R.id.spinner_ano);//Spinner para fornecer os dados de anos
        ArrayAdapter<String> anoAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, getAnos());//recebe o string
        anoAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAno.setAdapter(anoAdapter);

        // Spinner de Mês
        Spinner spinnerMes = findViewById(R.id.spinner_mes); //Spinner para fornecer os dados de mês
        ArrayAdapter<CharSequence> mesAdapter = ArrayAdapter.createFromResource(this, R.array.meses_array, android.R.layout.simple_spinner_item);// recebe os meses do res/values/strings.xml
        mesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMes.setAdapter(mesAdapter);

        btConta.setOnClickListener(new View.OnClickListener() { //configuração para acessar a MainConfiguration pelo btConta
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainConfiguracoes.class);
                startActivity(intent);
            }
        });
        btSair.setOnClickListener(new View.OnClickListener() { //configuração para o btSair, fechando o aplicativo
            @Override
            public void onClick(View v) {
                finishAffinity(); // Fecha todas as atividades na pilha e encerra o aplicativo
            }
        });
    }

    private String[] getAnos() {   // criado uma string para cada ano criado, de 2000 á 2023
        String[] anos = new String[24];
        for (int i = 0; i < 24; i++) { //loop em for que adiciona 1 e variar entre 0 e 23 vezes
            anos[i] = String.valueOf(2000 + i);
        }
        return anos; //retorna o ano selecionado ao usuário
    }


}
