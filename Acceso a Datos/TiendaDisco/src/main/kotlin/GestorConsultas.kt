import java.io.File
import java.io.FileNotFoundException
import java.io.IOException
import java.io.RandomAccessFile

class GestorConsultas {
    var stream: RandomAccessFile? = null

    /**
     * Constructor del gestor de consultas de la tienda.
     * Abre el fichero con los datos de prueba.
     * Si no existe, lo crea
     */
    init {
        creaFichero("discosDAML.dat")
    }

    /**
     * Crea / abre el fichero en disco
     * @param nombreFichero nombre del fichero en disco
     */
    private fun creaFichero(nombreFichero: String) {
        try {
            val exists = File(nombreFichero).exists()
            stream = RandomAccessFile(nombreFichero, "rw")
            if (!exists) {
                creaDiscosPorDefecto()
            }
        } catch (e: FileNotFoundException) {
            println("Error al abrir el fichero: $nombreFichero")
            System.exit(0)
        }
    }

    private fun creaDiscosPorDefecto() {
        val disco1 = Disco(1, "Que voy a hacer", "Los Planetas", 20.0, 5)
        disco1.escribeEnFichero(stream)
        val disco2 = Disco(2, "La voz del presidente", "Viva Suecia", 35.0, 1)
        disco2.escribeEnFichero(stream)
        val disco3 = Disco(3, "La revolución sexual", "La casa azul", 20.0, 10)
        disco3.escribeEnFichero(stream)
        val disco4 = Disco(4, "Finisterre", "Vetusta Morla", 40.0, 5)
        disco4.escribeEnFichero(stream)
        val disco5 = Disco(5, "Paradise", "Coldplay", 35.0, 2)
        disco5.escribeEnFichero(stream)
    }

    /**
     * Cierra el flujo/stream asociado al fichero de discos.
     */
    fun cierraGestor() {
        try {
            stream!!.close()
        } catch (e: IOException) {
            println("No se ha podido cerrar el fichero")
        }
    }

    /**
     * Metodo auxiliar privado que busca un disco con un codigo dado y devuelve su posicion en el fichero
     * Si no lo encuentra, devuelve -1
     * @param    codigoBuscado    codigo del disco buscado
     * @return                    byte de inicio del registro en el fichero
     */
     fun buscaCodigo(codigoBuscado: Int): Long {
        try {
            val randomAccessFile = RandomAccessFile("discosDAML.dat", "rw")
            val disco = Disco()

            while (randomAccessFile.filePointer < randomAccessFile.length()) {
                val byteInicio = randomAccessFile.filePointer // Guarda la posición del inicio del registro

                // Lee un registro completo
                disco.codigo = randomAccessFile.readInt()
                disco.titulo = randomAccessFile.readUTF()
                disco.autor = randomAccessFile.readUTF()
                disco.precio = randomAccessFile.readDouble()
                disco.cantidad = randomAccessFile.readInt()

                if (disco.codigo == codigoBuscado) {
                    randomAccessFile.close()
                    return byteInicio
                }


            }

            randomAccessFile.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }

        return -1
    }

    private fun posicionaFichero(posicion: Long) {
        try {
            stream!!.seek(posicion)
        } catch (e: IOException) {
            println("Error posicionando el puntero al inicio del fichero")
            System.exit(0)
        }
    }

    /**
     * Devuelve un vector con los autores de discos en el catalog de la tienda
     * @return    Vector de cadenas con los autores
     */
    /*fun listaAutores(): Array<String> {
        val Disco = Disco()
        //IMPLEMENTAR

    }*/

    private fun hashArray(autores: HashSet<String>): Array<String?> {
        val lista = arrayOfNulls<String>(autores.size)
        var i = 0
        for (`val` in autores) lista[i++] = `val`
        return lista
    }

    /**
     * Busca los discos de un determinado autor en el fichero y los devuelve como un vector de cadenas
     * Si no hay ninguno, devuelve el vector vacio
     * @param    autorBuscado    autor del disco buscado
     * @return                    Vector de cadenas asociadas a los discos del autor
     */
    /*fun buscaAutor(autorBuscado: String?): Array<String> {
        val Disco = Disco()
        //IMPLEMENTAR
    }*/

    /**
     * Da de alta un ejemplar del disco con un codigo dado y devuelve una cadena con sus datos
     * Si el disco no estaba en el fichero, devuelve la cadena vacía
     * @param    codigoBuscado    codigo del disco buscado
     * @return                    cadena con informacion del disco
     */
    fun altaDisco(codigoBuscado: Int): String {
        val posicion = buscaCodigo(codigoBuscado)
        //IMPLEMENTAR
        return ""
    }

    /**
     * Da de baja un ejemplar del disco con un codigo dado y devuelve una cadena con sus datos
     * Si no hay ninguno, devuelve una cadena vacía
     * @return            cadena con informacion del disco
     */
    fun bajaDisco(codigoBuscado: Int): String {
        val posicion = buscaCodigo(codigoBuscado)
        //IMPLEMENTAR
        return ""
    }
}