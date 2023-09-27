import java.io.EOFException
import java.io.IOException
import java.io.RandomAccessFile
import java.io.Serializable
import java.util.*

class Disco : Serializable {
    /**
     * Devuelve el codigo del disco
     * @return
     */
    var codigo = 0
    var titulo: String? = null
    var autor: String? = null
    var precio = 0.0
    var cantidad = 0

    /**
     * Constructor de un Solucion.Disco sin argumentos
     */

    constructor() // fin de constructor sin argumentos

    /**
     * Constructor de un Solucion.Disco con argumentos
     * @param    codigo        codigo del disco
     * @param    titulo        titulo del disco
     * @param    autor        autor del disco
     * @param    precio        precio del disco
     * @param    cantidad    ejemplares disponibles del disco
     */
    constructor(codigo: Int, titulo: String?, autor: String?, precio: Double, cantidad: Int) {
        this.codigo = codigo
        this.titulo = titulo
        this.autor = autor
        this.precio = precio
        this.cantidad = cantidad
    } // fin de constructor con argumentos

    /**
     * Escribe los datos de un disco en una cadena y la devuelve
     * @return    cadena con los datos del disco
     */
    override fun toString(): String {
        var cadena = ""
        cadena += "TITULO: " + titulo + ". CODIGO: " + codigo + "\n"
        cadena += """
             AUTOR: ${autor}
             PRECIO: ${precio}. CANTIDAD: ${cantidad}
             """.trimIndent()
        return cadena
    } // fin de toString

    /**
     * Lee los datos de un disco de un stream de entrada
     */
    fun leeDeTeclado(teclado: Scanner?) {

        println("Introduce el codigo del disco:")
        val codigo = teclado!!.nextInt()
        teclado?.nextLine()
        println("Introduce el título del disco:")
        val titulo = teclado.nextLine()

        println("Introduce el autor del disco:")
        val autor = teclado.nextLine()

        println("Introduce el precio del disco:")
        val precio = teclado.nextDouble()

        println("Introduce la cantidad de ejemplares disponibles del disco:")
        val cantidad = teclado.nextInt()

        // Verificar que los valores no sean nulos antes de asignarlos al objeto Disco
        if (codigo!=null && titulo != null && autor != null && precio != null && cantidad != null) {
            this.codigo = codigo
            this.titulo = titulo
            this.autor = autor
            this.precio = precio
            this.cantidad = cantidad
        } else {
            println("Error: Alguno de los valores ingresados es nulo.")
        }
    }

    /**
     * Escribe los datos de un disco en la posicion actual de un fichero
     * @param    stream    stream asociado al fichero
     */

    fun escribeEnFichero(stream: RandomAccessFile?) {

        if (stream == null) {
            println("Error: El archivo no está abierto.")
            return
        }else{
            stream.writeInt(codigo);
            stream.writeUTF(titulo);
            stream.writeUTF(autor);
            stream.writeDouble(precio)
            stream.writeInt(cantidad)
        }
    }

    /**
     * Lee los datos de un disco de la posicion actual de un fichero
     * @param    stream    stream asociado al fichero
     * @throws    EOFException, IOException
     */
    @Throws(EOFException::class, IOException::class)
    fun leeDeFichero(stream: RandomAccessFile?) {
        try {
            while (true) {
                codigo = stream?.readInt()!!;
                titulo = stream?.readUTF()
                autor = stream?.readUTF()
                precio = stream?.readDouble()!!;
                cantidad = stream?.readInt()!!;

                var disco = Disco(codigo, titulo, autor, precio, cantidad).toString()
                println(disco)
                println()
            }
        }catch (e: EOFException){
            //
        }

    }

    companion object {
        /**
         * Clase que permite escribir y leer un Solucion.Disco de teclado y en un fichero de acceso directo
         */
        private const val serialVersionUID = 1L //¿Recordáis para qué sirve?
    }
}