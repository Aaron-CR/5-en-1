package com.example.a5en1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.a5en1.Juego1.MenuJuego1Activity;
import com.example.a5en1.Juego2.MenuJuego2Activity;
import com.example.a5en1.Juego3.MenuJuego3Activity;
import com.example.a5en1.Juego4.MenuJuego4Activity;
import com.example.a5en1.Juego5.MenuJuego5Activity;

public class JugarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Establecer el contenido de la actividad para utilize el archivo activity_jugar.xml.
        setContentView(R.layout.activity_jugar);

        /** Encuentra el Button de la opción Juego 1. */
        Button juego1 = findViewById(R.id.button_juego_1);
        // Establece un click listener en ese View.
        juego1.setOnClickListener(new View.OnClickListener() {
            // El código en este método se ejecutará cuando se haga clic en la categoría Juego 1.
            @Override
            public void onClick(View view) {
                // Crea un nuevo Intent para abrir {@link MenuJuego1Activity}
                Intent juego1Intent = new Intent(JugarActivity.this, MenuJuego1Activity.class);
                // Inicia la nueva Activity
                startActivity(juego1Intent);
            }
        });


        /** Encuentra el Button de la opción Juego 2. */
        Button juego2 = findViewById(R.id.button_juego_2);
        // Establece un click listener en ese View.
        juego2.setOnClickListener(new View.OnClickListener() {
            // El código en este método se ejecutará cuando se haga clic en la categoría Juego 2.
            @Override
            public void onClick(View v) {
                // Crea un nuevo Intent para abrir {@link MenuJuego2Activity}
                Intent juego2Intent = new Intent(JugarActivity.this, MenuJuego2Activity.class);
                // Inicia la nueva Activity
                startActivity(juego2Intent);
            }
        });

        /** Encuentra el Button de la opción Juego 3. */
        Button juego3 = findViewById(R.id.button_juego_3);
        // Establece un click listener en ese View.
        juego3.setOnClickListener(new View.OnClickListener() {
            // El código en este método se ejecutará cuando se haga clic en la categoría Juego 3.
            @Override
            public void onClick(View v) {
                // Crea un nuevo Intent para abrir {@link MenuJuego3Activity}
                Intent juego3Intent = new Intent(JugarActivity.this, MenuJuego3Activity.class);
                // Inicia la nueva Activity
                startActivity(juego3Intent);
            }
        });

        /** Encuentra el Button de la opción Juego 4. */
        Button juego4 = findViewById(R.id.button_juego_4);
        // Establece un click listener en ese View.
        juego4.setOnClickListener(new View.OnClickListener() {
            // El código en este método se ejecutará cuando se haga clic en la categoría Juego 4.
            @Override
            public void onClick(View v) {
                // Crea un nuevo Intent para abrir {@link MenuJuego4Activity}
                Intent juego4Intent = new Intent(JugarActivity.this, MenuJuego4Activity.class);
                // Inicia la nueva Activity
                startActivity(juego4Intent);
            }
        });

        /** Encuentra el Button de la opción Juego 5. */
        Button juego5 = findViewById(R.id.button_juego_5);
        // Establece un click listener en ese View.
        juego5.setOnClickListener(new View.OnClickListener() {
            // El código en este método se ejecutará cuando se haga clic en la categoría Juego 5.
            @Override
            public void onClick(View v) {
                // Crea un nuevo Intent para abrir {@link MenuJuego5Activity}
                Intent juego5Intent = new Intent(JugarActivity.this, MenuJuego5Activity.class);
                // Inicia la nueva Activity
                startActivity(juego5Intent);
            }
        });

    }

    // Metodo del boton "back"
    @Override
    public void onBackPressed() {
        // Crea un nuevo Intent para abrir {@link MenuJuego1Activity}
        Intent menuCategoriasIntent = new Intent(JugarActivity.this, MainActivity.class);
        // Inicia la nueva Activity
        startActivity(menuCategoriasIntent);
    }
}
