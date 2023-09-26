package exercicis

import java.io.DataInputStream
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.ObjectOutputStream
;
val f_in = DataInputStream(FileInputStream("Rutes.dat"))
val f_out = ObjectOutputStream(FileOutputStream("Rutes.obj"))



fun main(){

    readDat();

}

fun readDat(){


    while (f_in.available() > 0) {
        var rutaNom = f_in.readUTF();
        var desnivell = f_in.readInt();
        var desnivellAcumulat = f_in.readInt();
        var numPunts = f_in.readInt();
        var llistaDePunts: MutableList<PuntGeo> = mutableListOf() ;
        for (i in 1 until numPunts +1) {

            var nomPunt = f_in.readUTF();
            var latitud = f_in.readDouble();
            var longitud = f_in.readDouble();
            llistaDePunts.add(PuntGeo(nomPunt, Coordenades(latitud,longitud)))

        }
        var ruta = Ruta(rutaNom,desnivell,desnivellAcumulat, llistaDePunts)
        f_out.writeObject(ruta);
        ruta.mostrarRuta();




    }

}
