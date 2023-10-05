import javax.swing.*
import java.awt.*
import com.squareup.moshi.Moshi
import exercicis.Ruta
import java.io.File
class Rutes(var rutes: MutableList<Ruta> = mutableListOf<Ruta>())
class FinestraJSON : JFrame() {

    init {
        var llistaRutes: ArrayList<Ruta> = arrayListOf()
        val json = File("Rutes.json").readText()
        val moshi = Moshi.Builder().build();
        val adapter = moshi.adapter(Rutes::class.java)
        val rutas = adapter.fromJson(json)
        for (r in rutas!!.rutes){
            llistaRutes.add(r)
        }


        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setTitle("JSON: Punts d'una ruta")
        setSize(400, 300)
        setLayout(BorderLayout())

        val panell1 = JPanel(FlowLayout())
        val panell2 = JPanel(BorderLayout())
        add(panell1, BorderLayout.NORTH)
        add(panell2, BorderLayout.CENTER)

        var nomsLlistaRutes = arrayListOf<String>()
        // sentències per a omplir l'ArrayList anterior amb el nom de les rutes
        for (n in llistaRutes){
            nomsLlistaRutes.add(n.nom)
        }
        val combo = JComboBox(nomsLlistaRutes.toArray())
        panell1.add(combo)

        panell2.add(JLabel("Llista de punts de la ruta:"), BorderLayout.NORTH)
        val area = JTextArea()
        panell2.add(area)

        combo.addActionListener {
            area.text = ""
            // accions quan s'ha seleccionat un element del combobox,
            // i que han de consistir en omplir el JTextArea
            for (i in 0 until  llistaRutes[combo.selectedIndex].llistaDePunts.size){
                var puntActual = llistaRutes[combo.selectedIndex].llistaDePunts[i]
                area.text += "${puntActual.nom} (${puntActual.coord.latitud},${puntActual.coord.longitud})\n"

            }


        }
    }
}

fun main(args: Array<String>) {
    EventQueue.invokeLater {
        FinestraJSON().isVisible = true
    }
}