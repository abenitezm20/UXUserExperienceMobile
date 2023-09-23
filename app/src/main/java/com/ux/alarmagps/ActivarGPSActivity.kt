package com.ux.alarmagps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView

class ActivarGPSActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_activar_gpsactivity)

        val alarmaView: ImageView = findViewById(R.id.botonAtrasGPS)
        alarmaView.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@ActivarGPSActivity, CrearAlarmaActivity::class.java)
            startActivity(intent)
        })
    }
}