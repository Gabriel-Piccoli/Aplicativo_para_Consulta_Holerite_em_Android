package com.example.teladeconsulta;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinnerAno = findViewById(R.id.spinner_ano);
        ArrayAdapter<String> anoAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, getAnos());
        anoAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAno.setAdapter(anoAdapter);

        // Spinner de Mês
        Spinner spinnerMes = findViewById(R.id.spinner_mes);
        ArrayAdapter<CharSequence> mesAdapter = ArrayAdapter.createFromResource(this, R.array.meses_array, android.R.layout.simple_spinner_item);
        mesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMes.setAdapter(mesAdapter);
    }

    private String[] getAnos() {
        String[] anos = new String[24];
        for (int i = 0; i < 24; i++) {
            anos[i] = String.valueOf(2000 + i);
        }
        return anos;
    }
}
