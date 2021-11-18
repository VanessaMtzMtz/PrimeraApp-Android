package com.example.ejercicio1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val bundle = intent.extras

        val usuarioNombre = bundle?.getString("usuario")
        Toast.makeText(this,"¡Hola  $usuarioNombre", Toast.LENGTH_LONG).show()

    }
}