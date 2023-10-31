package com.example.teladeconsulta;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class TelaInicial extends AppCompatActivity {
    EditText cpfEditText;
    EditText senhaEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);

        // Localizar os elementos de entrada e botão
        cpfEditText = findViewById(R.id.cpfEditText);
        senhaEditText = findViewById(R.id.passwordEditText);
        Button loginButton = findViewById(R.id.loginButton);

        // Configurar um ouvinte de clique para o botão de login
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obter os valores inseridos nos campos de CPF e senha
                String cpf = cpfEditText.getText().toString();
                String senha = senhaEditText.getText().toString();

                // Verificar se o CPF e a senha são autorizados
                if (LoginManager.loginUser(cpf, senha)) {
                    // CPF e senha corretos, abrir a próxima atividade (MainActivity)
                    Intent intent = new Intent(TelaInicial.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    // CPF ou senha incorretos, exibir uma mensagem de erro
                    Toast.makeText(TelaInicial.this, "CPF ou senha incorretos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Configurar um ouvinte de clique para o botão "Sair"
        Button sairButton = findViewById(R.id.exitButton);
        sairButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mostrar um diálogo de confirmação de saída
                AlertDialog.Builder confirmExitDialog = new AlertDialog.Builder(TelaInicial.this);
                confirmExitDialog.setMessage("Deseja realmente sair?");
                confirmExitDialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish(); // Fecha a atividade atual
                    }
                });
                confirmExitDialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss(); // Fecha o diálogo
                    }
                });
                confirmExitDialog.show();
            }
        });
    }
}
