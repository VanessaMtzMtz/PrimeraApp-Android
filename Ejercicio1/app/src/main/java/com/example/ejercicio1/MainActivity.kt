package com.example.ejercicio1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var etNombre: EditText
    private lateinit var etCorreo: EditText
    private lateinit var etFecha: EditText
    private lateinit var etNumCuenta: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etNombre = findViewById(R.id.etNombre)
        etCorreo = findViewById(R.id.etCorreo)
        etFecha = findViewById(R.id.etFecha)
        etNumCuenta = findViewById(R.id.etNumCuenta)

    }

    fun clickButton(view: View) {
        if(etNombre.text.toString()!= "" && etCorreo.text.toString() != "" &&
            etFecha.text.toString() != "" && etNumCuenta.text.toString() != ""){
            val intent = Intent(this,MainActivity2::class.java)
            val nombreUs = etNombre.text.toString()
            val correoUs = etCorreo.text.toString()
            val fechaNac = etFecha.text.toString()
            val numCuenta = etNumCuenta.text.toString()
            val edad = calculoEdad(fechaNac)

            //Para enviar los datos del usuario a nuestro otro Activity
            val parametros = Bundle()
            //parametros.putString("textPersonName")
            intent.putExtras(parametros)
            startActivity(intent)
        }else{
            Toast.makeText(this, "No dejes ningun campo vacío",Toast.LENGTH_LONG).show()
        }


    }

    fun calculoEdad(fecha: String): Int{
        val fechaNacDate:Date=SimpleDateFormat("dd/mm/yyyy").parse(fecha)
        val fechaActual=Date(System.currentTimeMillis())

        return 1
    }

}