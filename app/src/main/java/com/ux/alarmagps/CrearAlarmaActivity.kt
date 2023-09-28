package com.ux.alarmagps

import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import java.util.Calendar

class CrearAlarmaActivity : AppCompatActivity() {

    private lateinit var horaText: TextView
    private var flagHora: Boolean = true

    private lateinit var btnLunes :BotonDiaSemana
    private lateinit var btnMartes :BotonDiaSemana
    private lateinit var btnMiercoles :BotonDiaSemana
    private lateinit var btnJueves :BotonDiaSemana
    private lateinit var btnViernes :BotonDiaSemana
    private lateinit var btnSabado :BotonDiaSemana
    private lateinit var btnDomingo :BotonDiaSemana

    private lateinit var nombreAlarma: EditText

    private var textoDias = mutableListOf("", "", "", "", "", "", "")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_alarma)

        val alarmaView: ImageView = findViewById(R.id.botonAtrasCrear)
        alarmaView.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@CrearAlarmaActivity, MainActivity::class.java)
            startActivity(intent)
        })

        val gpsBoton: Button = findViewById(R.id.botonActivarGPS)
        gpsBoton.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@CrearAlarmaActivity, ActivarGPSActivity::class.java)
            startActivity(intent)
        })

        val textoError: TextView = findViewById(R.id.alarmaError)
        textoError.text = ""
        val botonGuardar: Button = findViewById(R.id.botonGuardarAlarma)
        botonGuardar.setOnClickListener(View.OnClickListener {
            registrarAlarma(textoError)
        })

        horaText = findViewById(R.id.horaText)
        horaText.setOnClickListener(View.OnClickListener {
            showTimePickerDialog()
        })

        val textoDias: TextView = findViewById(R.id.textoDias)

        btnDomingo = BotonDiaSemana(findViewById(R.id.btnDomingo), 0, "Dom")
        btnLunes = BotonDiaSemana(findViewById(R.id.btnLunes), 1, "Lun")
        btnMartes = BotonDiaSemana(findViewById(R.id.btnMartes), 2, "Mar")
        btnMiercoles = BotonDiaSemana(findViewById(R.id.btnMiercoles), 3, "Mie")
        btnJueves = BotonDiaSemana(findViewById(R.id.btnJueves), 4, "Jue")
        btnViernes = BotonDiaSemana(findViewById(R.id.btnViernes), 5, "Vie")
        btnSabado = BotonDiaSemana(findViewById(R.id.btnSabado), 6, "Sab")

        configurarListener(btnDomingo, textoDias)
        configurarListener(btnLunes, textoDias)
        configurarListener(btnMartes, textoDias)
        configurarListener(btnMiercoles, textoDias)
        configurarListener(btnJueves, textoDias)
        configurarListener(btnViernes, textoDias)
        configurarListener(btnSabado, textoDias)

        nombreAlarma = findViewById(R.id.nombreAlarmaText)
    }

    private fun configurarListener(btnDia: BotonDiaSemana, textView: TextView) {
        btnDia.btn.setOnClickListener(View.OnClickListener {
            btnDia.estado = !btnDia.estado
            if (btnDia.estado) {
                btnDia.btn.setBackgroundResource(R.drawable.boton_dias_on)
                btnDia.btn.setTextColor(ContextCompat.getColor(this, R.color.white))
                textoDias[btnDia.posicion.toInt()] = btnDia.nombre
            } else {
                btnDia.btn.setBackgroundResource(R.drawable.boton_dias_off)
                btnDia.btn.setTextColor(ContextCompat.getColor(this, R.color.secundario))
                textoDias[btnDia.posicion.toInt()] = ""
            }

            val valoresDias = textoDias.filter { it != null && it.isNotBlank() }
            textView.text = valoresDias.joinToString(", ")
        })
    }

    private fun showTimePickerDialog() {
        val calendar = Calendar.getInstance()

        if(flagHora) {
            calendar.set(Calendar.HOUR_OF_DAY, 7)
            calendar.set(Calendar.MINUTE, 0)
            flagHora = false
        } else {
            val tmp: String = horaText.text.split(" ")[0]
            val dos = tmp.split(":")
            calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(dos[0]))
            calendar.set(Calendar.MINUTE, Integer.parseInt(dos[1]))
        }

        val hourOfDay = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        val timePickerDialog = TimePickerDialog(
            this,
            R.style.TimePickerTheme,
            { view, hourOfDay, minute ->
                val formattedHour = if (hourOfDay > 12) {
                    hourOfDay - 12
                } else if (hourOfDay == 0) {
                    12
                } else {
                    hourOfDay
                }
                val time = String.format("%02d:%02d", formattedHour, minute)
                val amPm = if (hourOfDay >= 12) "PM" else "AM"
                horaText.text = "$time $amPm"
            },
            hourOfDay,
            minute,
            false
        )
        timePickerDialog.show()
    }

    private fun registrarAlarma(textoError: TextView) {
        val valoresDias = textoDias.filter { it != null && it.isNotBlank() }
        val intent = Intent(this@CrearAlarmaActivity, MainActivity::class.java)

        if (nombreAlarma.text == null || nombreAlarma.text.toString().isEmpty()) {
            textoError.text = "El nombre es obligatorio*"
            return
        } else {
            intent.putExtra("etiquetaAlarma", nombreAlarma.text.toString())
            intent.putExtra("horaAlarma", horaText.text.toString())
            intent.putExtra("diasAlarma", valoresDias.joinToString(", "))
        }

        startActivity(intent)
    }
}