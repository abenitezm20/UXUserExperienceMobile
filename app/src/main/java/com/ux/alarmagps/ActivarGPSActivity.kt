package com.ux.alarmagps

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.core.app.ActivityCompat
import com.google.android.gms.maps.CameraUpdate
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.MapsInitializer
import com.google.android.gms.maps.model.LatLng

class ActivarGPSActivity : AppCompatActivity() {
    private lateinit var mapView: MapView
    private lateinit var googleMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_activar_gpsactivity)

        val alarmaView: ImageView = findViewById(R.id.botonAtrasGPS)
        alarmaView.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@ActivarGPSActivity, CrearAlarmaActivity::class.java)
            startActivity(intent)
        })

        val ubicacionView: Button = findViewById(R.id.botonGuardarUbicacion)
        ubicacionView.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@ActivarGPSActivity, CrearAlarmaActivity::class.java)
            startActivity(intent)
        })

        mapView = findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync { map ->
            googleMap = map
            val ubicacion = LatLng(4.601737477957504, -74.07200764845754)
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ubicacion, 15F))
        }
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }


}