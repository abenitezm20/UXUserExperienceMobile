package com.ux.alarmagps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val agregarAlarmaView: ImageView = findViewById(R.id.botonAgregarAlarma)
        agregarAlarmaView.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@MainActivity, CrearAlarmaActivity::class.java)
            startActivity(intent)
        })

        val eliminarAlarmaView: ImageView = findViewById(R.id.botonEliminarAlarma)
        eliminarAlarmaView.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@MainActivity, EliminarAlarmaActivity::class.java)
            startActivity(intent)
        })

    }
}