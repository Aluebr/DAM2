import java.io.RandomAccessFile
import java.util.Scanner
val teclado = Scanner(System.`in`)
val gestor = GestorConsultas();

fun main() {
    gestor.stream = RandomAccessFile("discosDAML.dat", "rw")

    mainMenu();

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
                val discos = gestor.buscaAutor(nombre)
                if (discos.isNotEmpty()) {
                    println("Discos de $nombre:")
                    for (disco in discos) {
                        println("$disco \n")
                    }
                } else {
                    println("No se encontraron discos para $nombre.")
                }
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








