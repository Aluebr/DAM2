package PDF4

import java.lang.Exception
import java.util.Scanner


fun main() {
    

    calculateCost(askCost(), askQuantity())




    

}
fun calculateCost(article:Double,quantity:Int){

    var total = article * quantity;
    println("El precio total es: $total");
}

fun askCost():Double{
    var article:Double = 0.0;
    var bool = false;

    while (!bool && article <= 0.0) {
        try {
            println("Introduzca el precio del artículo: ")
            article = readLine()!!.toDouble();
            if (article != 0.0 && article > 0.0){
                bool = true;
            }else{
                println("No en precio válido")
                bool = false;
            }

        } catch (e: Exception) {
           println("No es un número válido")
        }

    }
    return article;
}
fun askQuantity():Int {
    var isNumber = false;
    var quantity: Int = 0
    while (!isNumber) {

        try {
            println("Introduce la cantidad: ");
            quantity = readLine()!!.toInt();
            if (quantity > 0) {
                isNumber = true;
            } else {
                println("Introduce un número superior a 0")
            }

        } catch (e: Exception) {
            println("No es un numero");
        }

    }
    return quantity;
}