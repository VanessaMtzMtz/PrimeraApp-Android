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

    fun clickButton(view: View) {//Botón ingresar
        if(etNombre.text.toString()!= "" && etCorreo.text.toString() != "" &&
            etFecha.text.toString() != "" && etNumCuenta.text.toString() != ""){
            val nombreUs = etNombre.text.toString()
            val correoUs = etCorreo.text.toString()
            val fechaNac = etFecha.text.toString()
            val numCuenta = etNumCuenta.text.toString()
            val edadUs = calculoEdad(fechaNac)

            //Para enviar los datos del usuario a nuestro otro Activity
            val intent = Intent(this,MainActivity2::class.java)
            intent.putExtra("nombre",nombreUs)
            intent.putExtra("correo",correoUs)
            intent.putExtra("fecha",fechaNac)
            intent.putExtra("cuenta",numCuenta)
            intent.putExtra("edad",edadUs.toString())

            startActivity(intent)
        }else{
            Toast.makeText(this, "No dejes ningun campo vacío",Toast.LENGTH_LONG).show()
        }


    }

    fun calculoEdad(fecha: String): Int{
        lateinit var fechaNacDate:Date
        try{
            fechaNacDate=SimpleDateFormat("dd/mm/yyyy").parse(fecha)
        }
        catch(e:Exception){
            Toast.makeText(this, "El formato de fecha no es correcto",Toast.LENGTH_LONG).show()
        }
        val fechaActual=Date(System.currentTimeMillis())
        val diferenciaFechasMili = fechaActual.getTime()-fechaNacDate.getTime()
        val segundos= diferenciaFechasMili/1000
        val minutos= segundos/60
        var horas=minutos/60
        var dias = horas/24
        var años= dias/365
        return años.toInt()
    }

}