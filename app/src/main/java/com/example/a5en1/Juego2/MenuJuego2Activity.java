package com.example.a5en1.Juego2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.a5en1.JugarActivity;
import com.example.a5en1.R;

public class MenuJuego2Activity extends AppCompatActivity {

    //Variable en la cual se guardara que categoria fue seleccionada
    public int categoria = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Establecer el contenido de la actividad para utilize el archivo activity_juego_2_menu.xml.
        setContentView(R.layout.activity_juego_2_menu);

        /* Encuentra el boton de la categoria 1 (Logica) */
        Button logica= findViewById(R.id.btn1Logica);

        /* Encuentra el botón de la categoría 2 (Ciencia) */
        Button ciencia = findViewById(R.id.btn2Ciencia);

        /* Encuentra el botón de la categoría 3 (Entretenimiento) */
        Button entretenimiento = findViewById(R.id.btn3Entretenimiento);

        /* Encuentra el botón de la categoría 4 (Historia) */
        Button historia = findViewById(R.id.btn4Historia);

        /* Encuentra el botón de la categoría 5 (Geografía) */
        Button geo = findViewById(R.id.btn5Geografia);

        /* Encuentra el botón de la categoría 6 (Aleatorio) */
        Button aleatorio = findViewById(R.id.btn6Aleatorio);

        // Establece un click listener para logica
        logica.setOnClickListener(new View.OnClickListener() {
            // El código en este método se ejecutará cuando se haga clic en la categoría logica.
            @Override
            public void onClick(View v) {
                //Se asigna la categoria
                categoria=1;
                // Crea un nuevo Intent para abrir {@link MenuJuego2Activity}
                Intent juego2Intent = new Intent(MenuJuego2Activity.this, Juego2Activity.class);
                // Se le agrega el valor de categoría al activity
                juego2Intent.putExtra("Categoria", categoria);
                // Inicia la nueva Activity
                startActivity(juego2Intent);
            }
        });

        // Establece un click listener para ciencia
        ciencia.setOnClickListener(new View.OnClickListener() {
            // El código en este método se ejecutará cuando se haga clic en la categoría ciencia.
            @Override
            public void onClick(View v) {
                //Se asigna la categoria
                categoria=2;
                // Crea un nuevo Intent para abrir {@link MenuJuego2Activity}
                Intent juego2Intent = new Intent(MenuJuego2Activity.this, Juego2Activity.class);
                // Se le agrega el valor de categoría al activity
                juego2Intent.putExtra("Categoria", categoria);
                // Inicia la nueva Activity
                startActivity(juego2Intent);
            }
        });

        // Establece un click listener para entretenimiento
        entretenimiento.setOnClickListener(new View.OnClickListener() {
            // El código en este método se ejecutará cuando se haga clic en la categoría entretenimiento.
            @Override
            public void onClick(View v) {
                //Se asigna la categoria
                categoria=3;
                // Crea un nuevo Intent para abrir {@link MenuJuego2Activity}
                Intent juego2Intent = new Intent(MenuJuego2Activity.this, Juego2Activity.class);
                // Se le agrega el valor de categoría al activity
                juego2Intent.putExtra("Categoria", categoria);
                // Inicia la nueva Activity
                startActivity(juego2Intent);
            }
        });


        // Establece un click listener para historia
        historia.setOnClickListener(new View.OnClickListener() {
            // El código en este método se ejecutará cuando se haga clic en la categoría historia.
            @Override
            public void onClick(View v) {
                //Se asigna la categoria
                categoria=4;
                // Crea un nuevo Intent para abrir {@link MenuJuego2Activity}
                Intent juego2Intent = new Intent(MenuJuego2Activity.this, Juego2Activity.class);
                // Se le agrega el valor de categoría al activity
                juego2Intent.putExtra("Categoria", categoria);
                // Inicia la nueva Activity
                startActivity(juego2Intent);
            }
        });

        // Establece un click listener para geografía
        geo.setOnClickListener(new View.OnClickListener() {
            // El código en este método se ejecutará cuando se haga clic en la categoría geografía.
            @Override
            public void onClick(View v) {
                //Se asigna la categoria
                categoria=5;
                // Crea un nuevo Intent para abrir {@link MenuJuego2Activity}
                Intent juego2Intent = new Intent(MenuJuego2Activity.this, Juego2Activity.class);
                // Se le agrega el valor de categoría al activity
                juego2Intent.putExtra("Categoria", categoria);
                // Inicia la nueva Activity
                startActivity(juego2Intent);
            }
        });

        // Establece un click listener para aleatorio
        aleatorio.setOnClickListener(new View.OnClickListener() {
            // El código en este método se ejecutará cuando se haga clic en la categoría aleatorio.
            @Override
            public void onClick(View v) {
                //Se asigna la categoria
                categoria=6;
                // Crea un nuevo Intent para abrir {@link MenuJuego2Activity}
                Intent juego2Intent = new Intent(MenuJuego2Activity.this, Juego2Activity.class);
                // Se le agrega el valor de categoría al activity
                juego2Intent.putExtra("Categoria", categoria);
                // Inicia la nueva Activity
                startActivity(juego2Intent);
            }
        });

    }
}
