package exercicis

import exemples.Empleat
import java.io.EOFException
import java.io.FileInputStream
import java.io.ObjectInputStream

val obj_read = ObjectInputStream(FileInputStream("Rutes.obj"))
fun main() {
    try {
        while (true) {
            var ruta = obj_read.readObject() as Ruta
            ruta.mostrarRuta();
        }
    } catch (eof: EOFException) {
        obj_read.close()
    }
}
