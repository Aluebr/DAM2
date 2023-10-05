package exercicis

import java.io.DataInputStream
import java.io.FileInputStream
import java.io.Serializable

    class Ruta (var nom: String, var desnivell: Int, var desnivellAcumulat: Int, var llistaDePunts: MutableList<PuntGeo>): Serializable {
    companion object {
        private const val serialVersionUID: Long = 1
    }

    fun addPunt(p: PuntGeo){
        llistaDePunts.add(p)
    }

    fun getPunt(i: Int): PuntGeo{
        return llistaDePunts.get(i)
    }

    fun getPuntNom(i: Int): String {
        return llistaDePunts.get(i).nom
    }

    fun getPuntLatitud(i: Int): Double {
        return llistaDePunts.get(i).coord.latitud
    }

    fun getPuntLongitud(i: Int): Double {
        return llistaDePunts.get(i).coord.longitud
    }

    fun size(): Int {
        return llistaDePunts.size
    }

    fun mostrarRuta() {
        val f = DataInputStream(FileInputStream("Rutes.dat"))

        while (f.available() > 0) {
            System.out.println("Ruta: " + nom)
            System.out.println("Desnivell: " + desnivell)
            System.out.println("Desnivell acumulat: " + desnivellAcumulat)

            System.out.println("Té: " + size() + " punts")
            for (i in 1 until  size() +1)

                System.out.println("Punt $i: " + getPuntNom(i) + " ("+getPuntLatitud(i)+","+getPuntLongitud(i)+")")

        }
        }



}