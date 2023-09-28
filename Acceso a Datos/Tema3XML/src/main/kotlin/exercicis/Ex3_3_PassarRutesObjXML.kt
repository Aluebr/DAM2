package exercicis

import java.io.EOFException
import java.io.FileInputStream
import java.io.ObjectInputStream
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.transform.OutputKeys
import javax.xml.transform.TransformerFactory
import javax.xml.transform.dom.DOMSource
import javax.xml.transform.stream.StreamResult


fun main() {
    val f = ObjectInputStream(FileInputStream("Rutes.obj"))

    val doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument()
    val arrel = doc.createElement ("rutes")
    doc.appendChild(arrel)

    try {
        while (true) {
            val r = f.readObject() as Ruta

            val ruta = doc.createElement ("ruta")

            val nom = doc.createElement("nom")
            nom.textContent = r.nom
            ruta.appendChild(nom)

            val desnivell = doc.createElement("desnivell")
            desnivell.setTextContent (r.desnivell.toString())
            ruta.appendChild(desnivell)

            val desnivellAcumulat = doc.createElement("desnivellAcumulat")
            desnivell.setTextContent (r.desnivellAcumulat.toString())
            ruta.appendChild((desnivellAcumulat))

            val punts = doc.createElement("punts")
            ruta.appendChild(punts)
            var i = 0;
            for(punt in r.llistaDePunts){
                val rutaPunt = doc.createElement("punt")
                rutaPunt.setAttribute("num",(i+1).toString())
                punts.appendChild(rutaPunt)

                val puntNom = doc.createElement("nom")
                puntNom.textContent = punt.nom
                rutaPunt.appendChild(puntNom)

                val latitud = doc.createElement("latitud")
                latitud.textContent = punt.coord.latitud.toString()
                rutaPunt.appendChild(latitud)

                val longitud = doc.createElement("longitud")
                longitud.textContent = punt.coord.longitud.toString()
                rutaPunt.appendChild(longitud)

                i++
            }

            arrel.appendChild(ruta)
        }

    } catch (eof: EOFException) {
        f.close();
    }
    val trans = TransformerFactory.newInstance().newTransformer()

    trans.setOutputProperty(OutputKeys.INDENT, "yes")
    trans.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2")
    trans.transform(DOMSource(doc), StreamResult("Rutes.xml"))
}
