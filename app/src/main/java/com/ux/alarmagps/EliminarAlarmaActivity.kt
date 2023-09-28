package com.ux.alarmagps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class EliminarAlarmaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eliminar_alarma)

        val alarmaView: ImageView = findViewById(R.id.botonAtrasEliminar)
        alarmaView.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@EliminarAlarmaActivity, MainActivity::class.java)
            startActivity(intent)
        })

        val recyclerView = findViewById<RecyclerView>(R.id.listaAlarmasDel)
        val adapter = EliminarAlarmaAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

    }

}