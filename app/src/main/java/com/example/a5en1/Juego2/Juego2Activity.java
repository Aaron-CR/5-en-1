package com.example.a5en1.Juego2;

import android.content.DialogInterface;
import android.os.CountDownTimer;
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
import java.util.Locale;
import java.util.Random;

public class Juego2Activity extends AppCompatActivity {

    private static final int QUIZ_COUNT = 10;
    private static final long TIEMPO_RESTANTE= 10000;
    public final int DEFAULT_TOTAL_SCORE = 100;
    public final int DEFAULT_DESCUENTO_SCORE = 15;

    private static final String categoria= "Lógica";
    public int SCORE_HISTORICO=0;

    private TextView quizScore;
    private TextView quizTime;
    private TextView countLabel;
    private TextView preguntaLabel;
    private Button respuestaBtn1;
    private Button respuestaBtn2;
    private Button respuestaBtn3;
    private Button respuestaBtn4;

    private String respuestaCorrecta;
    private int respuestaCorrectaCount =0;
    private int quizCount = 1;
    private int score =0;
    private int time =0;
    private String formatoScoreResta;
    private String formatoScoreSuma;

    private CountDownTimer countDown;
    private long tiempoRestante;

    ArrayList<ArrayList<String>> arregloQuiz = new ArrayList<>();

    String[][] datosQuiz = {
            // {"Pregunta", "Respuesta Correcta", "OtraRespuesta1", "OtraRespuesta2", "OtraRespuesta3"}
            {"De qué color son las 'cajas negras' de los aviones", "Naranjas", "Negras", "Rojas", "Blancas"},
            {"Si en una pecera hay 12 peces y 5 de ellos se ahogan, ¿cuántos peces quedan?", "12", "5", "17", "Ninguno"},
            {"¿Qué pasó ayer en España de 5 a 6?", "Una hora", "Un atentado", "Un terremoto", "Nada"},
            {"Si un niño nace en Argentina, pero a los dos años se va a vivir a Uruguay, ¿dónde le crecen los dientes?", "En la boca", "En Argentina", "En Uruguay", "En el camino"},
            {"Estas corriendo una carreras y pasas a la persona que está en 3er lugar ¿en qué lugar estás?", "En 3er lugar", "En 2do lugar", "En el 4to lugar", "En el 1er lugar"},
            {"Si un tren eléctrico se mueve hacia el norte a 100km/h y sopla el viento hacia el oeste a 10km/h, hacia donde irá el humo", "Hacia ningún lado", "Hacia el oeste", "Hacia el norte", "Hacia el norte y el oeste"},
            {"¿Qué es lo que siempre viene pero nunca llega?", "el mañana", "la muerte", "la felicidad", "la tarde"},
            {"¿Qué vive si lo alimentas y muere si le das de beber", "Fuego", "Viento", "Una persona", "Un robot"},
            {"¿Qué se puede romper pero nunca es sostenido?", "una promesa", "el silecio", "la dieta", "el miedo"},
            {"Si una persona no tiene todos los dedos en una mano, ¿cuántos dedos tiene?", "Diez", "Cinco", "Cuatro", "Seis"},
            {"¿Qué se puede agarrar pero no es tirado?", "Un resfrío", "Una pelota", "Un sueño", "Una maldición"},
            {"Si tenés un bowl con seis manzanas y agarrás cuatro, ¿cuántas tenés?", "cuatro", "seis", "diez", "ninguna"},
            {"Un chico tira una pelota a 20 metros, y la pelota vuelve sola a él. ¿Cómo hizo?", "Tiro para arriba", "Reboto en una pared", "Fue a buscarla", "Es un bumerang"},
            {"¿Cuántos meses tienen 28 días?", "Todos", "Uno", "Seis", "Cinco"},
            {"¿Qué va de arriba a abajo pero se queda siempre en el mismo lugar?", "Las escaleras", "El termómetro", "La temperatura", "Las nubes"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Establecer el contenido de la actividad para utilize el archivo activity_juego_2.xmll.
        setContentView(R.layout.activity_juego_2);

        quizScore = findViewById(R.id.quizScore);
        quizTime = findViewById(R.id.quizTime);
        countLabel = findViewById(R.id.countLabel);
        preguntaLabel = findViewById(R.id.preguntaLabel);
        respuestaBtn1 = findViewById(R.id.respuestaBtn1);
        respuestaBtn2 = findViewById(R.id.respuestaBtn2);
        respuestaBtn3 = findViewById(R.id.respuestaBtn3);
        respuestaBtn4 = findViewById(R.id.respuestaBtn4);

        quizScore.setText(String.format(Locale.getDefault(), "%d", score));

        // Crear arregloQuiz desde datosQuiz

        ArrayList<String> arregloAux; //Arreglo auxiliar para poner los datos del quiz

        for (int i =0; i < datosQuiz.length; i++){

            //Se prepara el arreglo a través de un arreglo auxiliar donde se van cargando los datos de datosQuiz
            arregloAux = new ArrayList<>();
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

    //Metodo que muestra la siguiente pregunta en la lista
    public void showNextQuiz(){

        // Actualiza quizCountLabel
        countLabel.setText("Pregunta " + quizCount);

        // Pasarle tiempo al timer
        tiempoRestante=TIEMPO_RESTANTE;
        startTimer();

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

    //Metodo que inicia el timer del juego

    public void startTimer(){
        countDown = new CountDownTimer(tiempoRestante, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tiempoRestante=millisUntilFinished;
                updateTimerText();
            }

            @Override
            public void onFinish() {
                tiempoRestante=0;
                updateTimerText();
                restaScore();
                showNextQuiz();
            }
        }.start();
    }

    //Metodo que actualiza el timer en el view
    private void updateTimerText(){
        int minutos = (int) ((tiempoRestante / 1000) / 60);
        int segundos = (int) ((tiempoRestante / 1000) % 60);

        String formatoTiempo= String.format(Locale.getDefault(), "%02d", segundos);

        quizTime.setText(formatoTiempo);
    }

    //Metodos que actualizan el puntaje en el view
    public void sumaScore(){
        score = score + DEFAULT_TOTAL_SCORE;
        formatoScoreSuma= String.format(Locale.getDefault(), "%d", score);
        quizScore.setText(formatoScoreSuma);
    }

    public void restaScore(){
        score = score - DEFAULT_DESCUENTO_SCORE;
        formatoScoreResta= String.format(Locale.getDefault(), "%d", score);
        quizScore.setText(formatoScoreResta);
    }

    //Metodo que evalúa si la respuesta es correcta

    public void chequearRespuesta(View view){

        countDown.cancel();

        // Obtener el botón que fue apretado
        Button respuestaBtn = findViewById(view.getId());
        String textoBtn = respuestaBtn.getText().toString();

        String tituloAlerta;

        if (textoBtn.equals(respuestaCorrecta)){
            // Esta correcto
            sumaScore();

            tituloAlerta= "¡Correcto!";
            respuestaCorrectaCount++;

        } else {
            // Esta mal
            restaScore();

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

        SCORE_HISTORICO= score;

    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        if (countDown != null){
            countDown.cancel();
        }
    }


}
