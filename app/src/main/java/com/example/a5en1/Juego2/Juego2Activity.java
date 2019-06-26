package com.example.a5en1.Juego2;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.speech.RecognizerIntent;
import android.os.CountDownTimer;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a5en1.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Random;

import static android.widget.Toast.*;

public class Juego2Activity extends AppCompatActivity {

    private static final int QUIZ_COUNT = 10; //Cantidad de preguntas por partida
    private static final long TIEMPO_RESTANTE= 16000; //Tiempo por pregunta en milisegundos
    public final int DEFAULT_TOTAL_SCORE = 100; //Puntaje por pregunta correcta
    public final int DEFAULT_DESCUENTO_SCORE = 15; //Puntaje que se descuenta por pregunta incorrecta


    private TextView quizScore;
    private TextView quizTime;
    private TextView countLabel;
    private TextView preguntaLabel;
    private Button respuestaBtn1;
    private Button respuestaBtn2;
    private Button respuestaBtn3;
    private Button respuestaBtn4;
    private Button btnPasarPregunta;
    private Button btnPedirRespuesta;

    private String respuestaCorrecta;
    private int respuestaCorrectaCount =0;
    private int quizCount = 1;
    private int score =0;
    private String formatoScoreResta;
    private String formatoScoreSuma;
    private int categoria;
    private String nombreCategoria;
    private int usoComodinPasar=0;
    private int usoComodinPista=0;
    private static int correctasSeguidas=0;
    private static int incorrectasSeguidas=0;
    private static int promedioTime=0;
    private int acumTime=0;
    private int acumAllTime=0;
    private static int totalTimeUsed=0;
    private int mayorCorrectas=0;
    private int mayorIncorrectas=0;

    private CountDownTimer countDown;
    private long tiempoRestante;

    ArrayList<ArrayList<String>> arregloQuiz = new ArrayList<>();

    String[][] datosQuizLogica = {
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

    String[][] datosQuizCiencia = {
            // {"Pregunta", "Respuesta Correcta", "OtraRespuesta1", "OtraRespuesta2", "OtraRespuesta3"}
            {"¿Quién posee la fuerza de mordida más fuerte del reino animal?", "Cocodrilo", "Serpiente", "León", "Oso"},
            {"¿Dónde están los meniscos?", "En las rodillas", "En el pie", "En los codos", "En el coxis"},
            {"¿En qué parte del cuerpo se encuentra la piel más gruesa?", "Espalda", "Brazos", "Piernas", "Cabeza"},
            {"¿A qué le teme una persona que sufre de turofobia?", "Al queso", "A la leche", "A la manteca", "Al yogurt"},
            {"¿Cuánto tarda la luz en viajar desde el Sol hasta la superficie terrestre?", "8' 17''", "9' 16''", "8' 24''", "9' 36''"},
            {"¿Cuál de las siguientes enfermedades ataca al higado?", "Hepatitis", "Diabetes", "Apendicitis", "Peritonitis"},
            {"¿Qué cambio de estado ocurre en la sublimación?", "Sólido --> gaseoso", "sólido --> líquido", "gaseoso --> sólido", "líquido --> gaseoso"},
            {"¿De dónde se extrae la sacarina?", "Del carbón", "Del azúcar", "Del azufre", "De la sal"},
            {"¿Cuántas caras tiene un icosaedro?", "20", "16", "19", "24"},
            {"¿Qué es el calostro?", "La primera leche materna", "Una hormona", "Una parte del intestino grueso", "Un hueso"},
            {"¿Qué estudia la icitología?", "Los peces", "Los insectos", "Las erupciones cutáneas", "Las rocas"},
            {"¿Cómo se llama el nivel más alto de la marea?", "Pleamar", "Bajamar", "Repunte", "Estacionario"},
            {"¿Para qué sirve la prueba del carbono 14?", "Deducir la edad de un material", "Calcular los electrones de un átomo", "Calcular los quilates del oro", "Galvanizar un metal"},
            {"¿Cuánto km2 tiene el desierto del Sahara?", "9065000km2", "9650000km2", "9560000km2", "9056000km2"},
            {"¿Cuantas veces en promedio se reemplaza la piel humana a lo largo de la vida?", "900", "100", "750", "Ninguna"},
    };

    String[][] datosQuizEntretenimiento = {
            // {"Pregunta", "Respuesta Correcta", "OtraRespuesta1", "OtraRespuesta2", "OtraRespuesta3"}
            {"¿Cuántos dedos tienen Los Simpsons?", "Cuatro", "Tres", "Cinco", "Seis"},
            {"¿En qué año se lanzó Age Of Empieres 1?", "1997", "1998", "1996", "1999"},
            {"¿Con qué compuesto cocina metanfetamina Walter White en Breaking Bad?", "Metilamina", "Etilamina", "Dietilamina", "Trimetilamina"},
            {"¿En qué país nació la Bauhaus?", "Alemania", "Inglaterra", "Rusia", "Holanda"},
            {"¿Cómo se llama el lobo huargo de Jon Snow?", "Ghost", "Nymeria", "Summer", "Grey Wind"},
            {"¿Cómo se dice 'gracias!' en Dothraki?", "San athchomari yeraan!", "Ki aleta yeni!", "Aena shekhikhi!", "Graddakh!"},
            {"¿A qué hace referencia la 'Milla verde'?", "Al camino a la muerte", "Al camino a la cárcel", "A una jugada de fútbol americano", "A un proverbio cristiano"},
            {"¿Cuál es el nombre de Tini Stoessel?", "Martina", "Agustina", "Justina", "Cristina"},
            {"¿Con qué apodo se llama al presidente Mauricio Macri?", "Gato", "Pato", "Perro", "Puerco"},
            {"¿Cuántos colores tiene un cubo rubik clásico?", "6", "8", "4", "12"},
            {"¿Qué actor ha hecho más películas como James Bonds?", "Roger Moore", "Daniel Craig", "Pierce Brosnan", "Sean Connery"},
            {"¿Cómo se llama el pájaro símbolo de 'Los juegos del hambre'?", "Sinsajo", "Charlajo", "Sinchajo", "Astajo"},
            {"¿Quién es el profesor del colegio Hogwarts que se convierte en hombre lobo?", "Remus Lupin", "Romulus Lupin", "James Potter", "Subill Trelawney"},
            {"¿De qué color era Clifford, el perro gigante?", "Rojo", "Azul", "Marrón", "Blanco"},
            {"¿Dónde nació John Lennon?", "Liverpool", "Dublin", "Londres", "Hamburgo"},
    };

    String[][] datosQuizHistoria = {
            // {"Pregunta", "Respuesta Correcta", "OtraRespuesta1", "OtraRespuesta2", "OtraRespuesta3"}
            {"¿Cuál es la rama mayoritaria del Islam?", "Sunismo", "Chiísmo", "Jariyismo", "Sufismo"},
            {"¿En qué año tuvo lugar el ataque de Pearl Harbor?", "1941", "1940", "1939", "1942"},
            {"¿Las revueltas de dónde se llaman Intifadas?", "Palestina", "Kosovo", "Montenegro", "Chechenia"},
            {"¿Cuántas bajas tuvo el ejército argentino durante la guerra de Malvinas?", "1731", "1082", "629", "1258"},
            {"El renacimiento marcó el inicio de la edad...", "Moderna", "Media", "Contemporánea", "Clásica"},
            {"¿Dónde surgió la filosofía?", "Grecia", "Roma", "Egipto", "Japón"},
            {"¿Los cuatro evangelistas de la Biblia son Mateo, Marcos, Lucas y...?", "Juan", "Pedro", "Pablo", "José"},
            {"¿En qué año fue patentada la máquina Enigma?", "1918", "1944", "1923", "1932"},
            {"¿Cuántos días duró el mandato como vicepresidente de Héctor José Cámpora?", "49", "40", "50", "45"},
            {"¿En qué país nació el protestantismo?", "Alemania", "Italia", "Francia", "Polonia"},
            {"¿Qué sobrenombre tenía Guillermo I de Inglaterra?", "El Conquistador", "El valiente", "El loco", "El Tirano"},
            {"¿En qué provincia nació el Cid Campeador?", "Burgos", "Salamanca", "Cantabria", "León"},
            {"¿Cuántos mandamientos hay en el cristianismo?", "10", "12", "5", "20"},
            {"¿Cuál era el nombre de pila de Lenin?", "Vladímir", "Aléksey", "Iósif", "Aleksandr"},
            {"¿En qué año empezó la Guerra del Golfo Pérsico?", "1990", "1985", "1995", "1999"},
    };

    String[][] datosQuizGeo = {
            // {"Pregunta", "Respuesta Correcta", "OtraRespuesta1", "OtraRespuesta2", "OtraRespuesta3"}
            {"¿En dónde se encuentra Silicon Valley?", "California", "Nueva York", "Miami", "Nuevo Mexico"},
            {"¿Cuál es la capital de Suiza?", "Berna", "Zurich", "Ginebra", "Basilea"},
            {"¿Qué separa las franjas de Gaza y Cisjordania?", "Un muro", "Nada", "Un río", "Israel"},
            {"¿Cuál de estos países africanos no tiene costa?", "Todos tienen costa", "Mauritania", "Senegal", "Gambia"},
            {"¿Cuál es la capital de Baréin?", "Manama", "Beréin", "Ammán", "Raid"},
            {"¿Entre qué dos paises está el lago Titicaca?", "Bolivia y Perú", "Bolivia y Paraguay", "Bolivia y Argentina", "Ninguna de las anteriores"},
            {"¿Qué accidente geográfico se define como un conjunto de islas, islotes y diminutas masas de tierra?", "Aechipiélago", "Península", "Islotes", "Meandro"},
            {"¿Cómo se le llama a una pendiente vertical abrupta?", "Acantilado", "Barranco", "Puente", "Montaña"},
            {"¿Dónde se encuentra el cerro Uritorco?", "Capilla del Monte, Córdoba", "La Falda, Córdoba", "Uspallata, Mendoza", "Jachal, San Juan"},
            {"¿Cuál es el mayor golfo de África?", "Guinea", "Gabés", "Sirte", "Ninguna es correcta"},
            {"¿Dónde está la ciudad de Mostar?", "Bosnia y Herzegovina", "Croacia", "Montenegro", "Serbia"},
            {"¿En cuántas franjas se divide la bandera de Grecia?", "9", "6", "7", "8"},
            {"¿Dónde están las torres Petronas?", "Malasia", "Singapur", "Indonesia", "Tailandia"},
            {"¿Qué país no se encuentra en Asia?", "Comores", "Brunei", "Sri Lanka", "Indonesia"},
            {"¿A qué país se debe ir para visitar el pueblo turístico Sidi Bou Said?", "Túnez", "Libia", "Marruecos", "Egipto"},
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Establecer el contenido de la actividad para utilize el archivo activity_juego_2.xmll.
        setContentView(R.layout.activity_juego_2);

        //Trae la categoria seleccionada en la actividad MenuJuego2Activity
        categoria= getIntent().getIntExtra("Categoria", 0);

        quizScore = findViewById(R.id.quizScore);
        quizTime = findViewById(R.id.quizTime);
        countLabel = findViewById(R.id.countLabel);
        preguntaLabel = findViewById(R.id.preguntaLabel);
        respuestaBtn1 = findViewById(R.id.respuestaBtn1);
        respuestaBtn2 = findViewById(R.id.respuestaBtn2);
        respuestaBtn3 = findViewById(R.id.respuestaBtn3);
        respuestaBtn4 = findViewById(R.id.respuestaBtn4);
        btnPasarPregunta = findViewById(R.id.comodinPasar);
        btnPedirRespuesta = findViewById(R.id.comodinPista);

        //Accion del comodin Pasar
        btnPasarPregunta.setOnClickListener(new View.OnClickListener() {
            // El código en este método se ejecutará cuando se haga clic en el boton "btnJuegarDenuevo".
            @Override
            public void onClick(View view) {
                if(usoComodinPasar == 3){ //Una vez que se use tres veces el boton se inhabilita
                    btnPasarPregunta.setEnabled(false);
                    btnPasarPregunta.setBackgroundColor(Color.rgb(180,180,180));
                } else {
                    pasarPregunta(); //Sino muestra pasa la pregunta
                }

            }
        });

        //Accion del comodin Pista
        btnPedirRespuesta.setOnClickListener(new View.OnClickListener() {
            // El código en este método se ejecutará cuando se haga clic en el boton "btnJuegarDenuevo".
            @Override
            public void onClick(View view) {
                if(usoComodinPista == 3){ //Una vez que se use tres veces el boton se inhabilita
                    btnPedirRespuesta.setEnabled(false);
                    btnPedirRespuesta.setBackgroundColor(Color.rgb(180,180,180));
                } else {
                    mostrarRespuesta(); //Sino muestra la respuesta de la pregunta
                }

            }
        });


        quizScore.setText(String.format(Locale.getDefault(), "%d", score));

        // Crear arreglo auxiliar para cada pregunta desde datos locales

        ArrayList<String> arregloAux; //Arreglo auxiliar para poner los datos del quiz

        //Se llena el arreglo auxiliar segun la categoría elegida
        if (categoria==1){
            nombreCategoria="Logica";
            for (String[] strings : datosQuizLogica) {

                //Se prepara el arreglo a través de un arreglo auxiliar donde se van cargando los datos de datosQuiz
                arregloAux = new ArrayList<>();
                arregloAux.add(strings[0]); //Pregunta
                arregloAux.add(strings[1]); //Respuesta correcta
                arregloAux.add(strings[2]); //OtraRespuesta 1
                arregloAux.add(strings[3]); //OtraRespuesta 2
                arregloAux.add(strings[4]); //OtraRespuesta 3

                // Agrega arregloAux a arregloQuiz

                arregloQuiz.add(arregloAux);

            }

            //Muetra la siguiente pregunta para esta categoria
            mostrarProxPreg();

        } else if (categoria==2){

            nombreCategoria="Ciencia";
            for (String[] strings : datosQuizCiencia) {

                //Se prepara el arreglo a través de un arreglo auxiliar donde se van cargando los datos de datosQuiz
                arregloAux = new ArrayList<>();
                arregloAux.add(strings[0]); //Pregunta
                arregloAux.add(strings[1]); //Respuesta correcta
                arregloAux.add(strings[2]); //OtraRespuesta 1
                arregloAux.add(strings[3]); //OtraRespuesta 2
                arregloAux.add(strings[4]); //OtraRespuesta 3

                // Agrega arregloAux a arregloQuiz

                arregloQuiz.add(arregloAux);

            }

            //Muetra la siguiente pregunta para esta categoria
            mostrarProxPreg();

        } else if (categoria==3){

            nombreCategoria="Entretenimiento";
            for (String[] strings : datosQuizEntretenimiento) {

                //Se prepara el arreglo a través de un arreglo auxiliar donde se van cargando los datos de datosQuiz
                arregloAux = new ArrayList<>();
                arregloAux.add(strings[0]); //Pregunta
                arregloAux.add(strings[1]); //Respuesta correcta
                arregloAux.add(strings[2]); //OtraRespuesta 1
                arregloAux.add(strings[3]); //OtraRespuesta 2
                arregloAux.add(strings[4]); //OtraRespuesta 3

                // Agrega arregloAux a arregloQuiz

                arregloQuiz.add(arregloAux);

            }

            //Muetra la siguiente pregunta para esta categoria
            mostrarProxPreg();

        } else if (categoria==4){

            nombreCategoria="Historia";
            for (String[] strings : datosQuizHistoria) {

                //Se prepara el arreglo a través de un arreglo auxiliar donde se van cargando los datos de datosQuiz
                arregloAux = new ArrayList<>();
                arregloAux.add(strings[0]); //Pregunta
                arregloAux.add(strings[1]); //Respuesta correcta
                arregloAux.add(strings[2]); //OtraRespuesta 1
                arregloAux.add(strings[3]); //OtraRespuesta 2
                arregloAux.add(strings[4]); //OtraRespuesta 3

                // Agrega arregloAux a arregloQuiz

                arregloQuiz.add(arregloAux);

            }

            //Muetra la siguiente pregunta para esta categoria
            mostrarProxPreg();

        } else if (categoria==5){

            nombreCategoria="Geografía";
            for (String[] strings : datosQuizGeo) {

                //Se prepara el arreglo a través de un arreglo auxiliar donde se van cargando los datos de datosQuiz
                arregloAux = new ArrayList<>();
                arregloAux.add(strings[0]); //Pregunta
                arregloAux.add(strings[1]); //Respuesta correcta
                arregloAux.add(strings[2]); //OtraRespuesta 1
                arregloAux.add(strings[3]); //OtraRespuesta 2
                arregloAux.add(strings[4]); //OtraRespuesta 3

                // Agrega arregloAux a arregloQuiz

                arregloQuiz.add(arregloAux);

            }

            //Muetra la siguiente pregunta para esta categoria
            mostrarProxPreg();

        } else if (categoria==6){

            nombreCategoria="Aleatorio";

            //Matriz auxiliar que añade los datos de todas las categorías
            ArrayList<String[]> aleatorio = new ArrayList<>();

            //Llena el arraylist con los datos de todas las categorías
            for (int i= 0; i < datosQuizLogica.length; i++){
                aleatorio.add(datosQuizLogica[i]);
                aleatorio.add(datosQuizCiencia[i]);
                aleatorio.add(datosQuizEntretenimiento[i]);
                aleatorio.add(datosQuizHistoria[i]);
                aleatorio.add(datosQuizCiencia[i]);
            }


            for (int i =0; i < datosQuizGeo.length; i++){

                //Se prepara el arreglo a través de un arreglo auxiliar donde se van cargando los datos de datosQuiz
                arregloAux = new ArrayList<>();
                arregloAux.add(aleatorio.get(i)[0]); //Pregunta
                arregloAux.add(aleatorio.get(i)[1]); //Respuesta correcta
                arregloAux.add(aleatorio.get(i)[2]); //OtraRespuesta 1
                arregloAux.add(aleatorio.get(i)[3]); //OtraRespuesta 2
                arregloAux.add(aleatorio.get(i)[4]); //OtraRespuesta 3

                // Agrega arregloAux a arregloQuiz

                arregloQuiz.add(arregloAux);

            }

            //Muetra la siguiente pregunta para esta categoría
            mostrarProxPreg();



        }



    }

    //Metodo que muestra la siguiente pregunta en la lista
    public void mostrarProxPreg(){

       // Pasarle tiempo al timer
        tiempoRestante=TIEMPO_RESTANTE; // Se le pasa el tiempo por pregunta al tiempo restante de cada pregunta
        startTimer();

        // Actualiza countLabel
        countLabel.setText(String.format(Locale.getDefault(), "%d", quizCount));

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

    /*CountDownTimer es una clase importada de android.os.CountDownTimer
    * Tiene dos métodos por defecto
    * onTick: lleva la porcion de codigo que se corre mientra el timer está descontando tiempo
    * onFinish: lleva la porcion de codigo que se corre al terminarse el tiempo del timer
    * Al crearse un CountDownTimer se debe pasar como parámetro en su constructor el tiempo del timer y
    * la razón de descuento de tiempo en milisegundos
    * msRestantes: es la variable auxiliar a la cual se le descuenta el tiempo
    * El metodo actualizarTimer() actualiza el número de segundos en la interfaz
    * */

    public void startTimer(){
        countDown = new CountDownTimer(tiempoRestante, 1000) { //Crea un nuevo CountDownTimer
            @Override
            public void onTick(long msRestantes) { //Mientras corre
                tiempoRestante=msRestantes;
                actualizarTimer();
            }

            @Override
            public void onFinish() { //Cuando termina
                tiempoRestante=0;
                actualizarTimer();
                correctasSeguidas=0;
                if(quizCount == QUIZ_COUNT) { //Si la cantidad de preguntas respondida es igual a la cantidad de preguntas por ronda
                    sacarPromedioTiempo();
                    mostrarResult(); //Termina el juego y muestra la pantalla de resultado

                } else { //Sino
                    incorrectasSeguidas++;
                    restaScore();
                    quizCount++; //Suma uno a la cantidad de preguntas respondidas
                    mostrarProxPreg(); //Muestra la siguiente pregunta
                }

            }
        }.start();

    }

    //Metodo que actualiza el timer en el view
    private void actualizarTimer(){
        acumTime++;

        int segundos = (int) ((tiempoRestante / 1000) % 60); //Pasa el tiempo de milisegundos a segundos

        String formatoTiempo= String.format(Locale.getDefault(), "%02d", segundos);

        quizTime.setText(formatoTiempo); // Actualiza el timer que se muestra en la interfaz
    }

    //Metodos que actualizan el puntaje en el view
    //Metodo que suma puntaje
    public void sumaScore(){
        score = score + DEFAULT_TOTAL_SCORE+ (15*correctasSeguidas); //Se suma el puntaje por defecto más 15 puntos por respuesta correcta seguida
        formatoScoreSuma= String.format(Locale.getDefault(), "%d", score);

        if(correctasSeguidas>mayorCorrectas){
            mayorCorrectas = correctasSeguidas;
        }

        quizScore.setText(formatoScoreSuma);
    }

    //Metodo que resta puntaje
    public void restaScore(){
        score = score - DEFAULT_DESCUENTO_SCORE - (15*incorrectasSeguidas); //Se resta el descuento por defecto + 15 puntos por cada incorrecta seguida
        if (score<0){
            score=0;
        }
        formatoScoreResta= String.format(Locale.getDefault(), "%d", score);

        if(incorrectasSeguidas>mayorIncorrectas){
            mayorIncorrectas = incorrectasSeguidas;
        }

        quizScore.setText(formatoScoreResta);
    }

    //Metodo que evalúa si la respuesta es correcta

    public void chequearRespuesta(View view){

        countDown.cancel(); //Se termina el timer
        acumAllTime+=acumTime;
        acumTime=0;

        // Obtener el botón que fue apretado
        Button respuestaBtn = findViewById(view.getId());
        // Obtener el texto del boton
        String textoBtn = respuestaBtn.getText().toString();

        //String para guardar si la respuesta es correcta o incorrecta
        String tituloAlerta;

        if (textoBtn.equals(respuestaCorrecta)){
            // Esta correcto
            incorrectasSeguidas=0;
            sumaScore(); //Suma puntaje
            correctasSeguidas++;
            tituloAlerta= "¡Correcto!";
            respuestaCorrectaCount++;

        } else {
            // Esta mal
            correctasSeguidas=0;
            restaScore(); //Resta puntaje
            incorrectasSeguidas++;
            tituloAlerta= "Respuesta incorrecta :(";

        }


        // Crear ventana de diálogo
        AlertDialog.Builder constructor = new AlertDialog.Builder(this);
        constructor.setTitle(tituloAlerta);
        constructor.setMessage("La respuesta correcta es: " + respuestaCorrecta);
        constructor.setPositiveButton("OK", new DialogInterface.OnClickListener() { //Al apretarse ok
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(quizCount == QUIZ_COUNT) { //Si la cantidad de preguntas respondida es igual a la cantidad de preguntas por ronda
                    sacarPromedioTiempo();
                    mostrarResult(); //Termina el juego y muestra la pantalla de resultado

                } else { //Sino
                    quizCount++; //Suma uno a la cantidad de preguntas respondidas
                    mostrarProxPreg(); //Muestra la siguiente pregunta
                }
            }
        });

        constructor.setCancelable(false); //No se permite cancelar o cerrar la ventana
        constructor.show(); //Muestra la ventana emergente

    }

    //Método que abre la actividad ResultadosJuego2Activity
    private void mostrarResult(){

        // Crea un Intent para abrir {@link ResultadosJuego1Activity}
        Intent resultIntent = new Intent(Juego2Activity.this, ResultadosJuego2Activity.class);
        //Se pasan los parámetros necesarios para la actividad de resultado
        resultIntent.putExtra("Respuestas correctas", respuestaCorrectaCount);
        resultIntent.putExtra("Cantidad preguntas", QUIZ_COUNT);
        resultIntent.putExtra("Puntaje total", score);
        resultIntent.putExtra("Categoria", categoria);
        resultIntent.putExtra("Combo correctas", mayorCorrectas);
        resultIntent.putExtra("Combo incorrectas", mayorIncorrectas);
        resultIntent.putExtra("Promedio tiempo", promedioTime);
        resultIntent.putExtra("Total tiempo", totalTimeUsed);
        // Inicia la Activity
        mayorCorrectas=0;
        mayorIncorrectas=0;
        startActivity(resultIntent);
    }


    //Metodo que destruye el cronómetro
    @Override
    protected void onDestroy(){
        super.onDestroy();
        if (countDown != null){
            countDown.cancel();
            acumAllTime+=acumTime;
            acumTime=0;
        }
    }


    // Metodos de los comodines

    //Comodin PASAR
    public void pasarPregunta(){
        countDown.cancel(); //Se termina el timer
        acumAllTime+=acumTime;
        acumTime=0;
        usoComodinPasar++; //Se suma uno a la cantidad de comodin Pista usados
        incorrectasSeguidas=0;
        correctasSeguidas=0;
        if(quizCount == QUIZ_COUNT) { //Si la cantidad de preguntas respondida es igual a la cantidad de preguntas por ronda
            sacarPromedioTiempo();
            mostrarResult(); //Termina el juego y muestra la pantalla de resultado

        } else { //Sino
            quizCount++; //Suma uno a la cantidad de preguntas respondidas
            mostrarProxPreg(); //Muestra la siguiente pregunta
        }
    }
    //Comodin PISTA
    public void mostrarRespuesta(){
        usoComodinPista++; //Se suma uno a la cantidad de comodin Pista usado
        makeText(this, "Respuesta: " + respuestaCorrecta, LENGTH_SHORT).show(); //Se muestra la respuesta
    }


    //Metodo para sacar el promedio de tiempo de respuesta
    public void sacarPromedioTiempo(){
        totalTimeUsed=acumAllTime;
        promedioTime= acumAllTime/10;
    }


}
