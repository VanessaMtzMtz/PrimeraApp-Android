package com.example.ejercicio1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity2 : AppCompatActivity() {
    private lateinit var tvSaludo: TextView
    private lateinit var tvFecha: TextView
    private lateinit var tvEdad: TextView
    private lateinit var tvAnimal: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        tvSaludo = findViewById(R.id.tvSaludo)
        tvFecha = findViewById(R.id.tvFecha)
        tvEdad = findViewById(R.id.tvEdad)
        tvAnimal = findViewById(R.id.tvAnimal)

        val nombre = getIntent().getStringExtra("nombre")
        val correo = getIntent().getStringExtra("correo")
        val fecha = getIntent().getStringExtra("fecha")
        val cuenta = getIntent().getStringExtra("cuenta")
        val edad = getIntent().getStringExtra("edad")

        tvSaludo.setText("Hola "+ nombre +", tu correo es: "+ correo + ", y tu número de cuenta es: "+ cuenta)
        tvEdad.setText("Tu edad es: "+ edad)
        tvFecha.setText("Naciste el: "+ fecha +", por lo tanto tu animal en el horóscopo chino es:")

    }
    //Boton regresar
    fun clickButtonRegresar(view: View) {
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }
}