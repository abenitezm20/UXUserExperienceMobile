package com.ux.alarmagps

import android.widget.Toast

object AlarmasManager {
    private var flagIngreso: Boolean = true
    private val listaAlarmas = mutableListOf<Alarmas>()

    fun obtenerLista(): List<Alarmas> {
        if(listaAlarmas.isEmpty() && flagIngreso) {
            this.agregarAlarma(Alarmas("Despertar", "06:30 AM", "Lun, Mar, Mie, Jue, Vie"))
            this.agregarAlarma(Alarmas("Museo del Oro", "08:00 AM", "Dom"))
            flagIngreso = false
        }
        return listaAlarmas.toList()
    }

    fun obtenerElemento(indice: Int): Alarmas? {
        return if (indice >= 0 && indice < listaAlarmas.size) {
            listaAlarmas[indice]
        } else {
            null
        }
    }

    fun modificarElemento(indice: Int, nuevaAlarma: Alarmas): Boolean {
        return if (indice >= 0 && indice < listaAlarmas.size) {
            listaAlarmas[indice] = nuevaAlarma
            true
        } else {
            false
        }
    }

    fun borrarElemento(indice: Int): Boolean {
        //var indice = obtenerIndice(alarma)
        return if (indice >= 0 && indice < listaAlarmas.size) {
            listaAlarmas.removeAt(indice)
            true
        } else {
            false
        }
    }

    fun agregarAlarma(alarma: Alarmas) {
        listaAlarmas.add(alarma)
    }

    fun yaExiste(etiqueta: String) : Boolean {
        return listaAlarmas.any{it.etiqueta == etiqueta}
    }

    fun obtenerIndice(alarma: Alarmas): Int {
        var indice: Int
        if(alarma.etiqueta == "Despertar"){
            indice = 0
        }
        else if (alarma.etiqueta == "Museo del Oro"){
            indice = 1
        }
        else {
            indice = 2
        }
        return indice
    }

}
