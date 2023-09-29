package exercicis

import javax.swing.*
import java.awt.*
import org.w3c.dom.Document
import org.w3c.dom.Element
import javax.xml.parsers.DocumentBuilderFactory


class Finestra : JFrame() {

    init {
        var doc: Document
        // sentències per a omplir doc
        doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("Rutes.xml")
        val arrel = doc.getDocumentElement()  // apuntarà a l'element arrel
        val llista = arrel.getElementsByTagName("ruta")


        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setTitle("Punts d'una ruta")
        setSize(400, 300)
        setLayout(BorderLayout())

        val panell1 = JPanel(FlowLayout())
        val panell2 = JPanel(BorderLayout())
        add(panell1,BorderLayout.NORTH)
        add(panell2,BorderLayout.CENTER)

        val llistaRutes = arrayListOf<String>()
        for (i in 0 until llista.length) {
            val ruta = llista.item(i) as Element
            val nomRuta = ruta.getElementsByTagName("nom")
            val nom = nomRuta.item(0).textContent
            llistaRutes.add(nom)
        }


        val combo = JComboBox(llistaRutes.toArray())
        panell1.add(combo)

        panell2.add(JLabel("Llista de punts de la ruta:"),BorderLayout.NORTH)
        val area = JTextArea()
        panell2.add(area)

        combo.addActionListener{
            // accions quan s'ha seleccionat un element del combobox,
            // i que han de consistir en omplir el JTextArea
            area.text = ""
            val ruta = llista.item(combo.selectedIndex) as Element
            val puntsRuta = ruta.getElementsByTagName("punts")
            val punt = puntsRuta.item(0) as Element

            var puntNode = punt.getElementsByTagName("punt")
            var nom = punt.getElementsByTagName("nom")
            var latitud = punt.getElementsByTagName("latitud")
            var longitud = punt.getElementsByTagName("longitud")

            for (i in 0 until puntNode.length) {

                val nomPunt = nom.item(i).textContent
                val latitudPunt = latitud.item(i).textContent
                val longitudPunt = longitud.item(i).textContent
                area.text += "$nomPunt ($latitudPunt,$longitudPunt)\n"
            }



        }
    }
}

fun main(args: Array<String>) {
    EventQueue.invokeLater {
        Finestra().isVisible = true
    }
}