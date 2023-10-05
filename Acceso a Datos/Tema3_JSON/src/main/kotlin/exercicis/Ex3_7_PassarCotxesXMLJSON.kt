package exercicis

import org.json.JSONArray
import org.json.JSONObject
import org.w3c.dom.Element
import java.io.FileWriter
import javax.xml.parsers.DocumentBuilderFactory

fun main(args: Array<String>) {

    val doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse("cotxes.xml")
    val arrel = doc.getDocumentElement()  // apuntarà a l'element arrel
    val llista = arrel.getElementsByTagName("vehiculo")
    val oferta = JSONObject()
    val vehiculos = JSONArray()


    for (i in 0 until llista.getLength()) {
        val vehiculoXML = llista.item(i) as Element

        val vehiculo = JSONObject()
        vehiculo.put("marca",vehiculoXML.getElementsByTagName("modelo").item(0).textContent)

        val modelo = JSONObject()
        val modeloXML = vehiculoXML.getElementsByTagName("modelo").item(0) as Element

        modelo.put("color",modeloXML.getAttribute("color"))
        modelo.put("nombre_modelo",modeloXML.textContent)
        vehiculo.put("modelo",modelo)


        val motor = JSONObject()
        val motorXML = vehiculoXML.getElementsByTagName("motor").item(0) as Element

        motor.put("combustible",motorXML.getAttribute("combustible"))
        motor.put("nombre_motor",motorXML.textContent)
        vehiculo.put("motor",motor)

        vehiculo.put("kilometros", vehiculoXML.getElementsByTagName("kilometros").item(0).textContent)
        vehiculo.put("precio_inicial", vehiculoXML.getElementsByTagName("precio_inicial").item(0).textContent)
        vehiculo.put("precio_oferta", vehiculoXML.getElementsByTagName("precio_oferta").item(0).textContent)
        vehiculo.put("matricula", vehiculoXML.getElementsByTagName("matricula").item(0).textContent)

        val extras = JSONArray()
        val extrasXML = vehiculoXML.getElementsByTagName("extra")

        for(j in 0 until extrasXML.length){
            val extra = JSONObject()
            val extraML = extrasXML.item(j) as Element
            extra.put("valor",extraML.getAttribute("valor"))
            extra.put("nombre_extra",extraML.textContent)
            extras.put(extra)
        }
        vehiculo.put("extra",extras)

        val fotos = JSONArray()
        val fotosXML = vehiculoXML.getElementsByTagName("foto")

        for(k in 0 until fotosXML.length){
            fotos.put(fotosXML.item(k).textContent)
        }
        vehiculo.put("foto",fotos)
        vehiculos.put(vehiculo)
    }
    oferta.put("oferta",JSONObject().put("vehiculos",vehiculos))
    val cotxesJson = FileWriter("cotxes.json")
    cotxesJson.write(oferta.toString(4))
    cotxesJson.close()
}


