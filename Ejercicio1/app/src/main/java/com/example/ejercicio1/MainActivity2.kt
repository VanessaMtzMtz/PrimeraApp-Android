package com.example.ejercicio1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    private lateinit var tvSaludo: TextView
    private lateinit var tvFecha: TextView
    private lateinit var tvEdad: TextView
    private lateinit var tvAnimal: TextView
    private lateinit var animalHor: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        tvSaludo = findViewById(R.id.tvSaludo)
        tvFecha = findViewById(R.id.tvFecha)
        tvEdad = findViewById(R.id.tvEdad)
        tvAnimal = findViewById(R.id.tvAnimal)
        animalHor = findViewById(R.id.animalHor)

        val nombre = getIntent().getStringExtra("nombre")
        val correo = getIntent().getStringExtra("correo")
        val fecha = getIntent().getStringExtra("fecha")
        val cuenta = getIntent().getStringExtra("cuenta")
        val edad = getIntent().getStringExtra("edad")
        val añoChino = getIntent().getStringExtra("añoChino")

        tvSaludo.setText("Hola "+ nombre +", tu correo es: "+ correo + ", y tu número de cuenta es: "+ cuenta)
        tvEdad.setText("Tu edad es: "+ edad)
        tvFecha.setText("Naciste el: "+ fecha +", por lo tanto tu animal en el horóscopo chino es:")

        if (añoChino.equals("1924")||añoChino.equals("1936")
            ||añoChino.equals("1948")||añoChino.equals("1960")
            ||añoChino.equals("1972")||añoChino.equals("1984")
            ||añoChino.equals("1996")||añoChino.equals("2008")
            ||añoChino.equals("2020")){
            animalHor.setImageResource(R.drawable.rata)
            tvAnimal.setText("RATA")
        }else if(añoChino.equals("1925")||añoChino.equals("1937")
            ||añoChino.equals("1949")||añoChino.equals("1961")
            ||añoChino.equals("1973")||añoChino.equals("1985")
            ||añoChino.equals("1997")||añoChino.equals("2009")
            ||añoChino.equals("2021")){
            animalHor.setImageResource(R.drawable.toro)
            tvAnimal.setText("BUEY")
        }else if(añoChino.equals("1926")||añoChino.equals("1938")
            ||añoChino.equals("1950")||añoChino.equals("1962")
            ||añoChino.equals("1974")||añoChino.equals("1986")
            ||añoChino.equals("1998")||añoChino.equals("2010")){
            animalHor.setImageResource(R.drawable.tigre)
            tvAnimal.setText("TIGRE")
        }else if(añoChino.equals("1927")||añoChino.equals("1939")
            ||añoChino.equals("1951")||añoChino.equals("1963")
            ||añoChino.equals("1975")||añoChino.equals("1987")
            ||añoChino.equals("1999")||añoChino.equals("2011")){
            animalHor.setImageResource(R.drawable.conejo)
            tvAnimal.setText("CONEJO")
        }else if(añoChino.equals("1928")||añoChino.equals("1940")
            ||añoChino.equals("1952")||añoChino.equals("1964")
            ||añoChino.equals("1976")||añoChino.equals("1988")
            ||añoChino.equals("2000")||añoChino.equals("2012")){
            animalHor.setImageResource(R.drawable.dragon)
            tvAnimal.setText("DRAGON")
        }else if(añoChino.equals("1929")||añoChino.equals("1941")
            ||añoChino.equals("1953")||añoChino.equals("1965")
            ||añoChino.equals("1977")||añoChino.equals("1989")
            ||añoChino.equals("2001")||añoChino.equals("2013")){
            animalHor.setImageResource(R.drawable.serpiente)
            tvAnimal.setText("SERPIENTE")
        }else if(añoChino.equals("1930")||añoChino.equals("1942")
            ||añoChino.equals("1954")||añoChino.equals("1966")
            ||añoChino.equals("1978")||añoChino.equals("1990")
            ||añoChino.equals("2002")||añoChino.equals("2014")){
            animalHor.setImageResource(R.drawable.caballo)
            tvAnimal.setText("CABALLO")
        }else if(añoChino.equals("1931")||añoChino.equals("1943")
            ||añoChino.equals("1955")||añoChino.equals("1967")
            ||añoChino.equals("1979")||añoChino.equals("1991")
            ||añoChino.equals("2003")||añoChino.equals("2015")){
            animalHor.setImageResource(R.drawable.cabra)
            tvAnimal.setText("CABRA")
        }else if(añoChino.equals("1932")||añoChino.equals("1944")
            ||añoChino.equals("1956")||añoChino.equals("1968")
            ||añoChino.equals("1980")||añoChino.equals("1992")
            ||añoChino.equals("2004")||añoChino.equals("2016")){
            animalHor.setImageResource(R.drawable.mono)
            tvAnimal.setText("MONO")
        }else if(añoChino.equals("1933")||añoChino.equals("1945")
            ||añoChino.equals("1957")||añoChino.equals("1969")
            ||añoChino.equals("1981")||añoChino.equals("1993")
            ||añoChino.equals("2005")||añoChino.equals("2017")){
            animalHor.setImageResource(R.drawable.gallo)
            tvAnimal.setText("GALLO")
        }else if(añoChino.equals("1934")||añoChino.equals("1946")
            ||añoChino.equals("1958")||añoChino.equals("1970")
            ||añoChino.equals("1982")||añoChino.equals("1994")
            ||añoChino.equals("2006")||añoChino.equals("2018")){
            animalHor.setImageResource(R.drawable.perro)
            tvAnimal.setText("PERRO")
        }
        else if(añoChino.equals("1935")||añoChino.equals("1947")
            ||añoChino.equals("1959")||añoChino.equals("1971")
            ||añoChino.equals("1983")||añoChino.equals("1995")
            ||añoChino.equals("2007")||añoChino.equals("2019")){
            animalHor.setImageResource(R.drawable.cerdo)
            tvAnimal.setText("CERDO")
        }else{
            animalHor.setImageResource(R.drawable.warning)
            tvAnimal.setText("ERROR")
        }

    }
    //Boton regresar
    fun clickButtonRegresar(view: View) {
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }
}