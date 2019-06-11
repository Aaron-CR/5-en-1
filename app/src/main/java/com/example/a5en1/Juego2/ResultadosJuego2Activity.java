package com.example.a5en1.Juego2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;


import com.example.a5en1.R;

public class ResultadosJuego2Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Establecer el contenido de la actividad para utilize el archivo activity_juego_2_resultados.xml.
        setContentView(R.layout.activity_juego_2_resultados);



    }

    // Metodo que deshabilita el boton "back"
    @Override
    public void onBackPressed() {

    }
}
