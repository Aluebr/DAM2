package PDF10

import java.lang.Exception

fun main() {

    var quant1 = 0.0;
    var quant2 = 0.0;
    var quant3 = 0.0;

    do {
        println("Introduce pesos")
        var numberInput = askDouble()
        if(numberInput > 10.2){
            quant1++
        }else if(numberInput >= 9.8){
            quant2++
        }else if(numberInput > 0){
            quant3++
        }

    }while (numberInput != 0.0);
    println("Piezas aptas: ${quant1.toInt()}")
    println("Piezas con un peso superior a 10.2: ${quant2.toInt()}")
    println("Piezas con un peso inferior a 9.8: ${quant3.toInt()}")

}


private fun askDouble(): Double {
    var isNumber = false;
    var quantity: Double = 0.0

    while (!isNumber) {
        try {
            println("Introducir número: ");
            quantity = readLine()!!.toDouble();
            isNumber = true
        } catch (e: Exception) {
            println("No es un numero");
        }

    }
    return quantity;
}