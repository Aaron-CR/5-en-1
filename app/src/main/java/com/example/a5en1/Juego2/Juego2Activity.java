package com.example.a5en1.Juego2;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.a5en1.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class Juego2Activity extends AppCompatActivity {

    private static final int QUIZ_COUNT = 5;
    private TextView countLabel;
    private TextView preguntaLabel;
    private Button respuestaBtn1;
    private Button respuestaBtn2;
    private Button respuestaBtn3;
    private Button respuestaBtn4;

    private String respuestaCorrecta;
    private int respuestaCorrectaCount =0;
    private int quizCount = 1;

    ArrayList<ArrayList<String>> arregloQuiz = new ArrayList<>();

    String[][] datosQuiz = {
            // {"Pregunta", "Respuesta Correcta", "OtraRespuesta1", "OtraRespuesta2", "OtraRespuesta3"}
            {"De qué color son las 'cajas negras' de los aviones", "Naranjas", "Negras", "Rojas", "Blancas"},
            {"Si en una pecera hay 12 peces y 5 de ellos se ahogan, ¿cuántos peces quedan?", "12", "5", "17", "Ninguno"},
            {"¿Qué pasó ayer en España de 5 a 6?", "Una hora", "Un atentado", "Un terremoto", "Nada"},
            {"Si un niño nace en Argentina, pero a los dos años se va a vivir a Uruguay, ¿dónde le crecen los dientes?", "En la boca", "En Argentina", "En Uruguay", "En el camino"},
            {"Estas corriendo una carreras y pasas a la persona que está en 3er lugar ¿en qué lugar estás?", "En 3er lugar", "En 2do lugar", "En el 4to lugar", "En el 1er lugar"},
            {"Si un tren eléctrico se mueve hacia el norte a 100km/h y sopla el viento hacia el oeste a 10km/h, hacia donde irá el humo", "Hacia ningún lado", "Hacia el oeste", "Hacia el norte", "Hacia el norte y el oeste"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Establecer el contenido de la actividad para utilize el archivo activity_juego_2.xmll.
        setContentView(R.layout.activity_juego_2);

        countLabel = findViewById(R.id.countLabel);
        preguntaLabel = findViewById(R.id.preguntaLabel);
        respuestaBtn1 = findViewById(R.id.respuestaBtn1);
        respuestaBtn2 = findViewById(R.id.respuestaBtn2);
        respuestaBtn3 = findViewById(R.id.respuestaBtn3);
        respuestaBtn4 = findViewById(R.id.respuestaBtn4);

        // Crear arregloQuiz desde datosQuiz

        for (int i =0; i < datosQuiz.length; i++){

            //Se prepara el arreglo a través de un arreglo auxiliar donde se van cargando los datos de datosQuiz
            ArrayList<String> arregloAux = new ArrayList<>();
            arregloAux.add(datosQuiz[i][0]); //Pregunta
            arregloAux.add(datosQuiz[i][1]); //Respuesta correcta
            arregloAux.add(datosQuiz[i][2]); //OtraRespuesta 1
            arregloAux.add(datosQuiz[i][3]); //OtraRespuesta 2
            arregloAux.add(datosQuiz[i][4]); //OtraRespuesta 3

            // Agrega arregloAux a arregloQuiz

            arregloQuiz.add(arregloAux);

        }

        showNextQuiz();


    }


    public void showNextQuiz(){

        // Actualiza quizCountLabel
        countLabel.setText("Pregunta" + quizCount);

        //Generar un número aleatorio entre 0 y el tamaño del arregloQuiz - 1
        Random random = new Random();
        int randomNum = random.nextInt(arregloQuiz.size());

        // Elegir una pregunta del arreglo
        ArrayList<String> pregunta = arregloQuiz.get(randomNum);

        // Establecer la pregunta y su respuesta correcta
        preguntaLabel.setText(pregunta.get(0));
        respuestaCorrecta = pregunta.get(1);

        // Borrar la pregunta del arreglo y mezclar opciones de respuesta

        pregunta.remove(0);
        Collections.shuffle(pregunta);

        //Establecer las opciones para cada botón
        respuestaBtn1.setText(pregunta.get(0));
        respuestaBtn2.setText(pregunta.get(1));
        respuestaBtn3.setText(pregunta.get(2));
        respuestaBtn4.setText(pregunta.get(3));

        // Quitar la pregunta actual del arregloQuiz
        arregloQuiz.remove(randomNum);

    }

    public void chequearRespuesta(View view){

        // Obtener el botón que fue apretado
        Button respuestaBtn = findViewById(view.getId());
        String textoBtn = respuestaBtn.getText().toString();

        String tituloAlerta;

        if (textoBtn.equals(respuestaCorrecta)){
            // Esta correcto
            tituloAlerta= "¡Correcto!";
            respuestaCorrectaCount++;

        } else {
            // Esta mal
            tituloAlerta= "Respuesta incorrecta :(";

        }

        // Crear ventana de diálogo
        AlertDialog.Builder constructor = new AlertDialog.Builder(this);
        constructor.setTitle(tituloAlerta);
        constructor.setMessage("La respuesta correcta es: " + respuestaCorrecta);
        constructor.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(quizCount == QUIZ_COUNT) {
                    //Mostrar pantalla de resultados
                } else {
                    quizCount++;
                    showNextQuiz();
                }
            }
        });

        constructor.setCancelable(false);
        constructor.show();


    }


}
