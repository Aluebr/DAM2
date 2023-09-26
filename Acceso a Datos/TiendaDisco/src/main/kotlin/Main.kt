import java.io.RandomAccessFile
import java.util.Scanner
val teclado = Scanner(System.`in`)

fun main() {

    val disco = Disco()
    val f_out = RandomAccessFile("Discos.dat", "rw")
    val f_in = RandomAccessFile("Discos.dat","rw");
    // Llamar a la función leeDeTeclado para llenar los datos del disco desde el teclado
    //disco.leeDeTeclado(teclado)
    // Imprimir los datos del disco
    //println("Los datos del disco son:")
    //println(disco.toString())
    //disco.escribeEnFichero(f_out)
    // Cierra el Scanner al finalizar
    //teclado.close()
    //disco.leeDeFichero(f_in)
    val consulta = GestorConsultas()
    println(consulta.buscaCodigo(2))

}