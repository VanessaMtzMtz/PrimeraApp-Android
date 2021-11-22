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
        val formatoMActual = SimpleDateFormat("MM")
        val formatoDActual = SimpleDateFormat("dd")

        val aActual = formatoAActual.format(fActual)
        val mActual = formatoMActual.format(fActual)
        val dActual = formatoDActual.format(fActual)

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
            val datePickerDialog = DatePickerDialog(this, DatePickerDialog.OnDateSetListener {
                    datePicker, año, mes, dia -> etFecha.text ="$dia / ${mes+1} / $año"
                    añoChino= año
                    if((mes+1)<mesActual){
                        edad=(añoActual-año)
                    }
                    else {
                        if ((mes+1) > mesActual) {
                            edad = (añoActual - año) - 1
                        }
                        else {
                            if (dia <= diaActual) {
                                edad = (añoActual - año)
                            }
                            else {
                                edad = (añoActual - año) - 1
                            }
                        }
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
}