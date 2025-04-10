package com.example.rachai_mobile_front.activities;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ParticipantesActivity extends AppCompatActivity {

    private ListView listParticipantes;
    private ArrayList<String> participantes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_participantes);

        listParticipantes = findViewById(R.id.listParticipantes);

        // Participantes fictícios – substituir por dados reais futuramente
        participantes = new ArrayList<>();
        participantes.add("João Silva (Motorista)");
        participantes.add("Maria Souza (Passageira)");
        participantes.add("Carlos Lima (Passageiro)");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                participantes
        );

        listParticipantes.setAdapter(adapter);
    }
}

