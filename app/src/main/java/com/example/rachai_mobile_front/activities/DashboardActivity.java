package com.example.rachai_mobile_front.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {

    private TextView tvBemVindo;
    private Button btnNovaViagem, btnMinhasViagens, btnPerfil, btnSair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        tvBemVindo = findViewById(R.id.tvBemVindo);
        btnNovaViagem = findViewById(R.id.btnNovaViagem);
        btnMinhasViagens = findViewById(R.id.btnMinhasViagens);
        btnPerfil = findViewById(R.id.btnPerfil);
        btnSair = findViewById(R.id.btnSair);

        String nomeUsuario = getIntent().getStringExtra("nomeUsuario");
        if (nomeUsuario != null) {
            tvBemVindo.setText("Bem-vindo(a), " + nomeUsuario + "!");
        }

        btnNovaViagem.setOnClickListener(v -> {
            // Exemplo de redirecionamento para criação de viagem
            Intent intent = new Intent(DashboardActivity.this, NovaViagemActivity.class);
            startActivity(intent);
        });

        btnMinhasViagens.setOnClickListener(v -> {
            Intent intent = new Intent(DashboardActivity.this, com.example.rachai.MinhasViagensActivity.class);
            startActivity(intent);
        });

        btnPerfil.setOnClickListener(v -> {
            Intent intent = new Intent(DashboardActivity.this, PerfilActivity.class);
            startActivity(intent);
        });

        btnSair.setOnClickListener(v -> {
            Intent intent = new Intent(DashboardActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });
    }
}

