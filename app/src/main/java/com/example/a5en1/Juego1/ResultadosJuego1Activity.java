package com.example.a5en1.Juego1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.a5en1.MainActivity;
import com.example.a5en1.R;

import java.util.Locale;

public class ResultadosJuego1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Establecer el contenido de la actividad para utilize el archivo activity_juego_1_resultados.xml.
        setContentView(R.layout.activity_juego_1_resultados);

        final int categoria = getIntent().getIntExtra("CATEGORIA", 0);
        int aciertos = getIntent().getIntExtra("CONTADOR_RESPUESTA_CORRECTA", 0);
        int cantidadPalabras = getIntent().getIntExtra("CANTIDAD_PALABRAS", 0);
        int puntajeTotal = getIntent().getIntExtra("PUNTAJE_TOTAL", 0);

        TextView textPuntajeTotal = findViewById(R.id.text_puntaje_total);
        TextView resultado = findViewById(R.id.text_resultado);

        textPuntajeTotal.setText(String.format(Locale.getDefault(), "%d", puntajeTotal));
        resultado.setText(String.format(Locale.getDefault(), "%d/%d", aciertos, cantidadPalabras));

        // Intent para volver a jugar
        ImageButton repetir = findViewById(R.id.button_repetir);
        // Establece un click listener en ese View.
        repetir.setOnClickListener(new View.OnClickListener() {
            // El código en este método se ejecutará cuando se haga clic en el boton "button_jugar_otra_vez".
            @Override
            public void onClick(View view) {
                // Crea un nuevo Intent para abrir {@link MainJuego1Activity}
                Intent repetirIntent = new Intent(ResultadosJuego1Activity.this, MainJuego1Activity.class);
                // Inicia el intent con la caetgoria ya elegida
                repetirIntent.putExtra("CATEGORIA", categoria);
                // Inicia la nueva Activity
                startActivity(repetirIntent);
            }
        });

        // Intent para abrir el Menu de las categorias
        ImageButton menuCategorias = findViewById(R.id.button_menu);
        // Establece un click listener en ese View.
        menuCategorias.setOnClickListener(new View.OnClickListener() {
            // El código en este método se ejecutará cuando se haga clic en el boton "button_categorias".
            @Override
            public void onClick(View view) {
                // Crea un nuevo Intent para abrir {@link MenuJuego1Activity}
                Intent menuCategoriasIntent = new Intent(ResultadosJuego1Activity.this, MenuJuego1Activity.class);
                // Inicia la nueva Activity
                startActivity(menuCategoriasIntent);
            }
        });

        // Intent para abrir el Menu principal
        ImageButton menuPrincipal = findViewById(R.id.button_home);
        // Establece un click listener en ese View.
        menuPrincipal.setOnClickListener(new View.OnClickListener() {
            // El código en este método se ejecutará cuando se haga clic en el boton MenuJuego1Activity.
            @Override
            public void onClick(View view) {
                // Crea un nuevo Intent para abrir {@link MainActivity}
                Intent menuPrincipalIntent = new Intent(ResultadosJuego1Activity.this, MainActivity.class);
                // Inicia la nueva Activity
                startActivity(menuPrincipalIntent);
            }
        });
    }

    // Metodo que deshabilita el boton "back"
    @Override
    public void onBackPressed() {

    }
}
