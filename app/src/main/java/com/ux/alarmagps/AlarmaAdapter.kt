package com.ux.alarmagps

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class AlarmaAdapter: RecyclerView.Adapter<AlarmaAdapter.ViewHolder>() {

    val etiquetas = arrayOf("Despertar", "Museo del Oro")
    val horas = arrayOf("06:30 AM", "08:00 AM")
    val dias = arrayOf("Lun, Mar, Mie, Jue, Vie", "Dom")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.alarma_card_layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.etiqueta.text = etiquetas[position]
        holder.hora.text = horas[position]
        holder.dias.text = dias[position]
        holder.opcionEliminar.visibility = View.VISIBLE
    }

    override fun getItemCount(): Int {
        return etiquetas.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var etiqueta: TextView
        var hora: TextView
        var dias: TextView
        var opcionEliminar : ImageView

        init {
            etiqueta = itemView.findViewById(R.id.etiquetaAlarmaCV)
            hora = itemView.findViewById(R.id.horaAlarmaCV)
            dias = itemView.findViewById(R.id.diasAlarmaCV)
            opcionEliminar = itemView.findViewById(R.id.opcionEliminarCV)
        }
    }

}