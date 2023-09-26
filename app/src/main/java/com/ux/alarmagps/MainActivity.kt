package com.ux.alarmagps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

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

        val recyclerView = findViewById<RecyclerView>(R.id.listaAlarmasRV)
        val adapter = AlarmaAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        procesarAlarma(adapter)
    }

    private fun procesarAlarma(adapter: AlarmaAdapter) {
        val bundle = intent.extras

        val etiquetaAlarma = bundle?.getString("etiquetaAlarma")
        val horaAlarma = bundle?.getString("horaAlarma")
        val diasAlarma = bundle?.getString("diasAlarma")

        if (etiquetaAlarma != null && horaAlarma != null && diasAlarma != null) {
            val alarma = Alarmas(etiquetaAlarma, horaAlarma, diasAlarma)
            adapter.agregarAlarma(alarma)
        }

    }
}