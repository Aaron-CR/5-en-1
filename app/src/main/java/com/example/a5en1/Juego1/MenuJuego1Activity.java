package com.example.a5en1.Juego1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.a5en1.JugarActivity;
import com.example.a5en1.MainActivity;
import com.example.a5en1.R;

public class MenuJuego1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Establecer el contenido de la actividad para utilize el archivo activity_juego_1_menu.xmll.
        setContentView(R.layout.activity_juego_1_menu);
    }

    public void empezarCategoria(View view) {
        int categoria = 0;
        switch (view.getId()) {
            case R.id.facil:
                categoria = 1;
                break;
            case R.id.medio:
                categoria = 2;
                break;
            case R.id.dificil:
                categoria = 3;
                break;
            case R.id.paises:
                categoria = 4;
                break;
            case R.id.animales:
                categoria = 5;
                break;
        }
        Intent intent = new Intent(getApplicationContext(), MainJuego1Activity.class);
        intent.putExtra("CATEGORIA", categoria);
        startActivity(intent);
    }

    // Metodo del boton "back"
    @Override
    public void onBackPressed() {
        // Crea un nuevo Intent para abrir {@link MenuJuego1Activity}
        Intent menuCategoriasIntent = new Intent(MenuJuego1Activity.this, JugarActivity.class);
        // Inicia la nueva Activity
        startActivity(menuCategoriasIntent);
    }
}