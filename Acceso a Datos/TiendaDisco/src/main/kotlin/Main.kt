import java.io.RandomAccessFile
import java.util.Scanner
val teclado = Scanner(System.`in`)
val gestor = GestorConsultas();

fun main() {
    gestor.stream = RandomAccessFile("discosDAML.dat", "rw")

    mainMenu();
    /*var autores = gestor.listaAutores()
    for(autor in autores){
        println(autor)
    }*/

}
fun mainMenu(){
    val gestor = GestorConsultas()
    gestor.stream = RandomAccessFile("discosDAML.dat", "rw")

    var continuar = true
    while (continuar) {
        println("Menú de opciones:")
        println("1. Salir del programa")
        println("2. Listar los autores en el catálogo")
        println("3. Buscar un autor o grupo")
        println("4. Comprar un disco")
        println("5. Revender un ejemplar")

        print("Seleccione una opción: ")
        val opcion = readLine()?.toIntOrNull()

        when (opcion) {
            1 -> {
                continuar = false
                gestor.cierraGestor()
                println("Saliendo del programa.")
            }
            2 -> {
                val autores = gestor.listaAutores()
                println("Autores en el catálogo:")
                for (autor in autores) {
                    println(autor)
                }
            }
            3 -> {
                print("Ingrese el nombre del autor o grupo: ")
                val nombre = readLine()
                /*val discos = gestor.buscaAutor(nombre)
                if (discos.isNotEmpty()) {
                    println("Discos de $nombre:")
                    for (disco in discos) {
                        println(disco)
                    }
                } else {
                    println("No se encontraron discos para $nombre.")
                }*/
            }
            4 -> {
                print("Ingrese el código del disco a comprar: ")
                val codigoCompra = readLine()?.toIntOrNull()
                if (codigoCompra != null) {
                    val mensaje = gestor.altaDisco(codigoCompra)
                    if (mensaje.isNotEmpty()) {
                        println("Disco comprado:")
                        println(mensaje)
                    } else {
                        println("No se encontró un disco con código $codigoCompra.")
                    }
                } else {
                    println("Entrada inválida. Ingrese un número válido.")
                }
            }
            5 -> {
                print("Ingrese el código del disco a revender: ")
                val codigoRevender = readLine()?.toIntOrNull()
                if (codigoRevender != null) {
                    val mensaje = gestor.bajaDisco(codigoRevender)
                    if (mensaje.isNotEmpty()) {
                        println("Disco revendido:")
                        println(mensaje)
                    } else {
                        println("No se encontró un disco con código $codigoRevender.")
                    }
                } else {
                    println("Entrada inválida. Ingrese un número válido.")
                }
            }
            else -> println("Opción no válida. Por favor, seleccione una opción válida.")
        }
    }
}

    //disco.leeDeFichero(gestor.stream)

    //val f_out = RandomAccessFile("discosDAML.dat", "rw")
    //val f_in = RandomAccessFile("discosDAML.dat","rw");
    // Llamar a la función leeDeTeclado para llenar los datos del disco desde el teclado
    //disco.leeDeTeclado(teclado)
    // Imprimir los datos del disco
    //println("Los datos del disco son:")
    //println(disco.toString())
    //disco.escribeEnFichero(f_out)
    // Cierra el Scanner al finalizar
    //teclado.close()
    //disco.leeDeFichero(f_in)



    // Realiza cualquier acción necesaria con los datos leídos





