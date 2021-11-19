package com.example.ejercicio1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val bundle = intent.extras

        val usuarioNombre = bundle?.getString("usuario")

        val tvSaludo = findViewById<TextView>(R.id.tvSaludo)
        val tvFecha = findViewById<TextView>(R.id.tvFecha)
        val tvEdad = findViewById<TextView>(R.id.tvEdad)
        val tvAnimal = findViewById<TextView>(R.id.tvAnimal)
    }
}