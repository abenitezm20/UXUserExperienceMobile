package com.ux.alarmagps

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EliminarAlarmaAdapter : RecyclerView.Adapter<EliminarAlarmaAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.alarma_card_layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val alarma = AlarmasManager.obtenerElemento(position)
        if(alarma != null) {
            holder.etiqueta.text = alarma.etiqueta
            holder.hora.text = alarma.hora
            holder.dias.text = alarma.dias
            holder.opcionEliminar.visibility = View.VISIBLE
        }
        holder.itemView.setOnClickListener(View.OnClickListener { onClickListener(alarma, position) })
    }

    private fun onClickListener(alarma: Alarmas?, position: Int) {
        if (alarma != null) {
            Log.d("ACA", alarma.etiqueta)
            eliminarAlarma(position)
        }
    }

    override fun getItemCount(): Int {
        return AlarmasManager.obtenerLista().size
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

    fun eliminarAlarma(posicion: Int) {
        AlarmasManager.borrarElemento(posicion)
        this.notifyItemRemoved(posicion)
    }

}