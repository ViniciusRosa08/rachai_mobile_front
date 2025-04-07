package com.example.rachai_mobile_front.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;

public class DetalhesViagemActivity extends AppCompatActivity {

    private TextView tvValorOrigem, tvValorDestino, tvValorData, tvValorMotorista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_viagem);

        tvValorOrigem = findViewById(R.id.tvValorOrigem);
        tvValorDestino = findViewById(R.id.tvValorDestino);
        tvValorData = findViewById(R.id.tvValorData);
        tvValorMotorista = findViewById(R.id.tvValorMotorista);

        // Recupera os dados enviados via Intent
        String origem = getIntent().getStringExtra("origem");
        String destino = getIntent().getStringExtra("destino");
        String data = getIntent().getStringExtra("data");
        String motorista = getIntent().getStringExtra("motorista");

        // Exibe os dados nos TextViews
        tvValorOrigem.setText(origem);
        tvValorDestino.setText(destino);
        tvValorData.setText(data);
        tvValorMotorista.setText(motorista);
    }

    Button btnEditar, btnParticipantes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_viagem);

        btnEditar = findViewById(R.id.btnEditar);
        btnParticipantes = findViewById(R.id.btnParticipantes);

        btnEditar.setOnClickListener(v -> {
            Intent intent = new Intent(DetalhesViagemActivity.this, EditarViagemActivity.class);
            // Adicione extras se quiser passar dados da viagem
            startActivity(intent);
        });

        btnParticipantes.setOnClickListener(v -> {
            Intent intent = new Intent(DetalhesViagemActivity.this, ParticipantesActivity.class);
            startActivity(intent);
        });
    }

}


