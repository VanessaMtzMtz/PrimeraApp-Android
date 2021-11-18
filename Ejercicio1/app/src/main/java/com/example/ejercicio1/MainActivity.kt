package com.example.ejercicio1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun clickButton(view: android.view.View) {
        val intent = Intent(this,MainActivity2::class.java)
        //Para enviar los datos del usuario a nuestro otro Activity
        val parametros = Bundle()
        //parametros.putString("textPersonName")
        intent.putExtras(parametros)
        startActivity(intent)

    }
}