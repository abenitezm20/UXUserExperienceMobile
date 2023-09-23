package com.ux.alarmagps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView

class EliminarAlarmaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eliminar_alarma)

        val alarmaView: ImageView = findViewById(R.id.botonAtrasEliminar)
        alarmaView.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@EliminarAlarmaActivity, MainActivity::class.java)
            startActivity(intent)
        })
    }
}