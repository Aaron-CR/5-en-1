package com.example.a5en1.Juego2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.a5en1.JugarActivity;
import com.example.a5en1.R;

public class MenuJuego2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Establecer el contenido de la actividad para utilize el archivo activity_juego_2_menu.xml.
        setContentView(R.layout.activity_juego_2_menu);

        /* Encuentra el Button de la categoría 1. */
        Button juego2 = findViewById(R.id.button_cat1juego2);
        // Establece un click listener en ese View.
        juego2.setOnClickListener(new View.OnClickListener() {
            // El código en este método se ejecutará cuando se haga clic en la categoría Juego 2.
            @Override
            public void onClick(View v) {
                // Crea un nuevo Intent para abrir {@link MenuJuego2Activity}
                Intent juego2Intent = new Intent(MenuJuego2Activity.this, Juego2Activity.class);
                // Inicia la nueva Activity
                startActivity(juego2Intent);
            }
        });
    }
}
