package com.example.a21650521.apptareaglide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    private EditText etNum;
    private Button btnConsulta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNum = findViewById(R.id.etNumPokemon);
        btnConsulta = findViewById(R.id.btnConsultar);

        btnConsulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListPokemonActivity.class);
                String numPokemon = etNum.getText().toString();
                intent.putExtra(getResources().getString(R.string.clave_num_pokemon),numPokemon);
                startActivity(intent);
            }
        });
    }
}
