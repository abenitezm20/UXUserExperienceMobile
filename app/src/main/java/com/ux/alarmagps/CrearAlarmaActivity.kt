package com.ux.alarmagps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView

class CrearAlarmaActivity : AppCompatActivity() {
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
    }
}