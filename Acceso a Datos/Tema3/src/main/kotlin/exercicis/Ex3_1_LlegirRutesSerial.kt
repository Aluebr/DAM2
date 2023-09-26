import java.io.FileInputStream
import java.io.DataInputStream

fun main(args: Array<String>) {
    val f = DataInputStream(FileInputStream("Rutes.dat"))

    while (f.available() > 0) {
        System.out.println("Ruta: " + f.readUTF())
        System.out.println("Desnivell: " + f.readInt())
        System.out.println("Desnivell acumulat: " + f.readInt())
        var numPunts = f.readInt();
        System.out.println("Té: " + numPunts + " punts")
        for (i in 1 until  numPunts +1)

        System.out.println("Punt $i: " + f.readUTF() + " ("+f.readDouble()+","+f.readDouble()+")")

    }
    f.close()
}