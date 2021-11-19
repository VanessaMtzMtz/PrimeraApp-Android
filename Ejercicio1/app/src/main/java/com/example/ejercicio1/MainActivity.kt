package com.example.ejercicio1

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var etNombre: EditText
    private lateinit var etCorreo: EditText
    private lateinit var etFecha: TextView
    private lateinit var etNumCuenta: EditText
    private lateinit var butCalendar: Button
    private val fActual=Date(System.currentTimeMillis())
    private var añoActual:Int =0
    private var mesActual:Int =0
    private var diaActual:Int =0
    var edad:Int =0
    var añoChino:Int =0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etNombre = findViewById(R.id.etNombre)
        etCorreo = findViewById(R.id.etCorreo)
        etFecha = findViewById(R.id.etFecha)
        etNumCuenta = findViewById(R.id.etNumCuenta)
        butCalendar = findViewById(R.id.butCalendar)

        fechaActual(fActual)
        datePicker(etFecha, butCalendar)
    }

    private fun fechaActual(fActual: Date) {
        val formatoAActual = SimpleDateFormat("yyyy")
        val formatoMActual = SimpleDateFormat("mm")
        val formatoDActual = SimpleDateFormat("dd")

        val aActual = formatoAActual.format(Date())
        val mActual = formatoMActual.format(Date())
        val dActual = formatoDActual.format(Date())

        añoActual = Integer.parseInt(aActual)
        mesActual = Integer.parseInt(mActual)
        diaActual = Integer.parseInt(dActual)
    }

    fun datePicker(etFecha:TextView, butCalendar:Button) {
        val calendario = Calendar.getInstance()
        val dia = calendario.get(Calendar.DAY_OF_MONTH)
        val mes = calendario.get(Calendar.MONTH)
        val año = calendario.get(Calendar.YEAR)

        butCalendar.setOnClickListener{
            val datePickerDialog = DatePickerDialog(
                this, DatePickerDialog.OnDateSetListener { datePicker, año, mes, dia ->
                    etFecha.text ="$dia / $mes  / $año"
                    añoChino= año
                    val nAño: Int = añoActual - año
                    val nMes: Int = ((mesActual * 30) + diaActual)
                    val nDias: Int = (mes * 30) + dia + 30
                    val resFDias: Int = nMes - nDias
                    if (resFDias < 0) {
                        etFecha.text = "Fecha inválida"
                    } else {
                        edad = nAño
                    }
                }, año, mes, dia)
            datePickerDialog.show()
        }
    }



    fun clickButton(view: View) {//Botón ingresar
        if(etNombre.text.toString()!= "" && etCorreo.text.toString() != "" &&
            etFecha.text.toString() != "" && etNumCuenta.text.toString() != ""){
            val nombreUs = etNombre.text.toString()
            val correoUs = etCorreo.text.toString()
            val fechaNac = etFecha.text.toString()
            val numCuenta = etNumCuenta.text.toString()
            val edadUs = edad.toString()
            val añoChinoH = añoChino.toString()

            //Para enviar los datos del usuario a nuestro otro Activity
            val intent = Intent(this,MainActivity2::class.java)
            intent.putExtra("nombre",nombreUs)
            intent.putExtra("correo",correoUs)
            intent.putExtra("fecha",fechaNac)
            intent.putExtra("cuenta",numCuenta)
            intent.putExtra("edad",edadUs)
            intent.putExtra("añoChino",añoChinoH)

            startActivity(intent)
        }else{
            Toast.makeText(this, "No dejes ningun campo vacío",Toast.LENGTH_LONG).show()
        }


    }

    /*fun calculoEdad(fecha: String): Int{
        lateinit var fechaNacDate:Date
        try{
            fechaNacDate=SimpleDateFormat("dd/mm/yyyy").parse(fecha)
        }
        catch(e:Exception){
            Toast.makeText(this, "El formato de fecha no es correcto",Toast.LENGTH_LONG).show()
        }
        val fActual=Date(System.currentTimeMillis())
        val diferenciaFechasMili = fechaActual.getTime()-fechaNacDate.getTime()
        val segundos= diferenciaFechasMili/1000
        val minutos= segundos/60
        var horas=minutos/60
        var dias = horas/24
        var años= dias/365
        return años.toInt()
    }*/

}