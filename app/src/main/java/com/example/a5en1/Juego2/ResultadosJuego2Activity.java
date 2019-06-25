package com.example.a5en1.Juego2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


import com.example.a5en1.JugarActivity;
import com.example.a5en1.MainActivity;
import com.example.a5en1.R;

import java.util.Locale;

public class ResultadosJuego2Activity extends AppCompatActivity {

    private String mensaje;
    private int categoria;
    private int comboCorrectas;
    private int comboIncorrectas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Establecer el contenido de la actividad para utilize el archivo activity_juego_2_resultados.xml.
        setContentView(R.layout.activity_juego_2_resultados);

        int puntajeTotal= getIntent().getIntExtra("Puntaje total", 0);
        int respCorrect= getIntent().getIntExtra("Respuestas correctas", 0);
        int cantPreguntas= getIntent().getIntExtra("Cantidad preguntas", 0);
        categoria= getIntent().getIntExtra("Categoria", 0);
        comboCorrectas= getIntent().getIntExtra("Combo correctas", 0);
        comboIncorrectas= getIntent().getIntExtra("Combo incorrectas", 0);

        if (respCorrect==10){
            mensaje="¡Excelente!";
        } else if (respCorrect<10 && respCorrect > 5 ) {
            mensaje= "¡Bien hecho!";
        } else if (respCorrect<5){
            mensaje= "¡Que no decaiga, la práctica hace al maestro!";
        }

        TextView mensajeResultado = findViewById(R.id.mensajeResult);
        TextView puntajeObtenido = findViewById(R.id.puntajeObtenido);
        TextView preguntasCorrectas = findViewById(R.id.preguntasCorrectas);
        TextView muestraComboCorrectas= findViewById(R.id.comboCorrectas);
        TextView muestraComboIncorrectas= findViewById(R.id.comboIncorrectas);

        mensajeResultado.setText(mensaje);
        puntajeObtenido.setText(String.format(Locale.getDefault(), "%d", puntajeTotal));
        preguntasCorrectas.setText(String.format(Locale.getDefault(), "%d/%d", respCorrect, cantPreguntas));
        muestraComboCorrectas.setText(String.format(Locale.getDefault(), "%d", comboCorrectas));
        muestraComboIncorrectas.setText(String.format(Locale.getDefault(), "%d", comboIncorrectas));

        /* Intent para volver a jugar */
        ImageButton repetir = findViewById(R.id.btnJugarDenuevo);
        // Establece un click listener en ese View.
        repetir.setOnClickListener(new View.OnClickListener() {
            // El código en este método se ejecutará cuando se haga clic en el boton "btnJuegarDenuevo".
            @Override
            public void onClick(View view) {
                // Crea un nuevo Intent para abrir {@link Juego2Activity}
                Intent repetirIntent = new Intent(ResultadosJuego2Activity.this, Juego2Activity.class);
                // Inicia el intent con la caetgoria ya elegida
                repetirIntent.putExtra("Categoria", categoria);
                // Inicia la nueva Activity
                startActivity(repetirIntent);
            }
        });

        /* Intent para volver al menu de categorias */
        ImageButton volverCat = findViewById(R.id.btnVolverCategorias);
        // Establece un click listener en ese View.
        volverCat.setOnClickListener(new View.OnClickListener() {
            // El código en este método se ejecutará cuando se haga clic en el boton "btnVolverCategorias".
            @Override
            public void onClick(View view) {
                // Crea un nuevo Intent para abrir {@link MenuJuego2Activity}
                Intent volverCatIntent = new Intent(ResultadosJuego2Activity.this, MenuJuego2Activity.class);
                // Inicia la nueva Activity
                startActivity(volverCatIntent);
            }
        });

        /* Intent para volver al menu principal */
        ImageButton volverMenu = findViewById(R.id.btnVolverMainMenu);
        // Establece un click listener en ese View.
        volverMenu.setOnClickListener(new View.OnClickListener() {
            // El código en este método se ejecutará cuando se haga clic en el boton "btnVolverMainMenu".
            @Override
            public void onClick(View view) {
                // Crea un nuevo Intent para abrir {@link MainActivity}
                Intent volverMenuIntent = new Intent(ResultadosJuego2Activity.this, MainActivity.class);
                // Inicia la nueva Activity
                startActivity(volverMenuIntent);
            }
        });

    }

    // Metodo que deshabilita el boton "back"
    @Override
    public void onBackPressed() {

    }
}
