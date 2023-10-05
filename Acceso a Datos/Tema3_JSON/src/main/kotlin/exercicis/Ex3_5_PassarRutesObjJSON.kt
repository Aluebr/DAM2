
package exercicis


import com.squareup.moshi.Moshi
import java.io.EOFException
import java.io.File
import java.io.FileInputStream
import java.io.ObjectInputStream

import com.squareup.moshi.*

class Rutes(var rutes: MutableList<Ruta> = mutableListOf<Ruta>())

val archivoObj = ObjectInputStream(FileInputStream("Rutes.obj"))

fun main() {
    val rutes = mutableListOf<Ruta>()

    val moshi = Moshi.Builder().build()

    while (true){
        try {


        val rutas = archivoObj.readObject() as Ruta

            val ruta = Ruta(rutas.nom,rutas.desnivell,rutas.desnivellAcumulat,rutas.llistaDePunts)
            rutes.add(ruta)
        }catch (e: EOFException){
        break;
        }
    }

    val adapter2 = moshi.adapter(Rutes::class.java)
    val json2 = adapter2.indent("  ").toJson(Rutes(rutes))

    File("Rutes.json").writeText(json2)


}


