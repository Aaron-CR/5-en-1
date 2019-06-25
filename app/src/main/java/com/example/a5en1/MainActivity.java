package com.example.a5en1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Establecer el contenido de la actividad para utilize el archivo activity_main.xml.
        setContentView(R.layout.activity_main);

        /** Encuentra el Button de la opción Jugar. */
        Button jugar = findViewById(R.id.button_jugar);
        // Establece un click listener en ese View.
        jugar.setOnClickListener(new View.OnClickListener() {
            // El código en este método se ejecutará cuando se haga clic en la opción JugarActivity.
            @Override
            public void onClick(View view) {
                // Crea un nuevo Intent para abrir {@link MenuJuego1Activity}
                Intent jugarIntent = new Intent(MainActivity.this, JugarActivity.class);
                // Inicia la nueva Activity
                startActivity(jugarIntent);
            }
        });



        /*
        /// Encuentra el Button que de la opción Estadísticas.
        Button estadisticas = findViewById(R.id.button_estadisticas);
        // Establece un click listener en ese View.
        estadisticas.setOnClickListener(new View.OnClickListener() {
            // El código en este método se ejecutará cuando se haga clic en la opción Estadísticas.
            @Override
            public void onClick(View view) {
                // Crea un nuevo Intent para abrir {@link MenuJuego1Activity}
                Intent estadisticasIntent = new Intent(MainActivity.this, EstadisticasActivity.class);
                // Inicia la nueva Activity
                startActivity(estadisticasIntent);
            }
        });

        // Encuentra el Button de la opción Ajustes.
        Button ajustes = findViewById(R.id.button_ajustes);
        // Establece un click listener en ese View.
        ajustes.setOnClickListener(new View.OnClickListener() {
            // El código en este método se ejecutará cuando se haga clic en la opción AjustesActivity.
            @Override
            public void onClick(View view) {
                // Crea un nuevo Intent para abrir {@link MenuJuego1Activity}
                Intent ajustesIntent = new Intent(MainActivity.this, AjustesActivity.class);
                // Inicia la nueva Activity
                startActivity(ajustesIntent);
            }
        });
        */
    }

    public void proximamente(View view) {
        Toast.makeText(this, "Próximamente!", Toast.LENGTH_SHORT).show();
    }
}
