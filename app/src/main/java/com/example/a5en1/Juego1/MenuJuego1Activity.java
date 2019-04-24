package com.example.a5en1.Juego1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a5en1.R;

import java.util.Random;

public class MenuJuego1Activity extends AppCompatActivity implements View.OnClickListener {

    private TextView palabraParaValidar;
    private EditText palabraDigitadaParaValidar;
    private Button arriesgar, pasarPalabra;
    private String palabraParaEncontrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Establecer el contenido de la actividad para utilize el archivo activity_juego_1_menu.xml.
        setContentView(R.layout.activity_juego_1_menu);
        // Encuentra el View que muestra la palabra para validar.
        palabraParaValidar = (TextView) findViewById(R.id.palabra_para_validar);

        // Encuentra el View que muestra la palabra ingresada por el usuario.
        palabraDigitadaParaValidar = (EditText) findViewById(R.id.palabra_digitada);

        // Encuentra el Botón que se utiliza para arriesgar una palabra.
        arriesgar = (Button) findViewById(R.id.arriesgar);

        /** Establece un click listener en ese Botón. */
        arriesgar.setOnClickListener(this);

        // Encuentra el Botón que se utiliza para pasar la palabra si no se sabe.
        pasarPalabra = (Button) findViewById(R.id.pasar_palabra);

        // Establece un click listener en ese Botón.
        pasarPalabra.setOnClickListener(this);

        // Ejecuta el método para generar una nueva palabra.
        nuevaPalabra();

    }

    public static final Random RANDOM = new Random();

    public static final String[] PALABRAS = {"FRANCIA", "ESPAÑA", "ESTADOSUNIDOS", "CHINA", "ITALIA",
            "REINOUNIDO", "ALEMANIA", "UCRANIA", "TURQUÍA", "MÉXICO", "MALASIA", "AUSTRIA", "RUSIA",
            "CANADÁ", "HONGKONG", "GRECIA", "POLONIA", "TAILANDIA", "MACAO", "PORTUGAL",
            "ARABIASAUDITA", "PAÍSESBAJOS", "EGIPTO", "CROACIA", "SUDÁFRICA", "HUNGRÍA", "SUIZA",
            "JAPÓN", "SINGAPUR"};

    public static String palabraAleatorea() {
        return PALABRAS[RANDOM.nextInt(PALABRAS.length)];
    }

    public static String mezclarPalabra(String palabra) {
        if (palabra != null && !"".equals(palabra)) {
            char a[] = palabra.toCharArray();

            for (int i = 0; i < a.length; i++) {
                int j = RANDOM.nextInt(a.length);
                char tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            }

            return new String(a);
        }

        return palabra;
    }

    public void onClick(View view) {
        if (view == arriesgar) {
            verificar();
        } else if (view == pasarPalabra) {
            nuevaPalabra();
        }
    }

    private void verificar() {
        String p = palabraDigitadaParaValidar.getText().toString().toUpperCase().trim();

        if (palabraParaEncontrar.equals(p)) {
            Toast.makeText(this, "Felicitaciones ! Adivinaste la palabra " + palabraParaEncontrar, Toast.LENGTH_SHORT).show();
            nuevaPalabra();
        } else {
            Toast.makeText(this, "Palabra equivocada!", Toast.LENGTH_SHORT).show();
            nuevaPalabra();
        }
    }

    private void nuevaPalabra() {
        palabraParaEncontrar = palabraAleatorea();
        String palabraMezclada = mezclarPalabra(palabraParaEncontrar);
        palabraParaValidar.setText(palabraMezclada);
        palabraDigitadaParaValidar.setText("");
    }

}