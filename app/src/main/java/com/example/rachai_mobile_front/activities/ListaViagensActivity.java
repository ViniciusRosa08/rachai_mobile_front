package com.example.rachai_mobile_front.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class ListaViagensActivity extends AppCompatActivity {

    private ListView listViewViagens;
    private Button btnNovaViagem;
    private ArrayList<String> listaViagens;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_viagens);

        listViewViagens = findViewById(R.id.listViewViagens);
        btnNovaViagem = findViewById(R.id.btnNovaViagem);

        listaViagens = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaViagens);
        listViewViagens.setAdapter(adapter);

        btnNovaViagem.setOnClickListener(v -> {
            Intent intent = new Intent(ListaViagensActivity.this, CadastroViagemActivity.class);
            startActivity(intent);
        });

        listViewViagens.setOnItemClickListener((parent, view, position, id) -> {
            String viagemSelecionada = listaViagens.get(position);
            Toast.makeText(ListaViagensActivity.this, "Viagem: " + viagemSelecionada, Toast.LENGTH_SHORT).show();
        });
        Intent intent = getIntent();
        if (intent != null) {
            String novaOrigem = intent.getStringExtra("novaOrigem");
            String novoDestino = intent.getStringExtra("novoDestino");
            String novaData = intent.getStringExtra("novaData");

            if (novaOrigem != null && novoDestino != null && novaData != null) {
                listaViagens.add(new Viagem(novaOrigem, novoDestino, novaData));
                adapter.notifyDataSetChanged();
            }
        }
        lvViagens.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(ListaViagensActivity.this, DetalhesViagemActivity.class);
            intent.putExtra("origem", "São Paulo");
            intent.putExtra("destino", "Rio de Janeiro");
            intent.putExtra("data", "10/04/2025");
            startActivity(intent);
        });

    }

}
