package PDF11

import java.lang.Exception

fun main() {
    var sum = 0;
    var j = 0;
    for (i in 1.. 10){
        var numberInput = askInt()
        sum+= numberInput;
        j++
    }
    println("Suma: $sum")
    println("Promedio: "+ (sum/j).toString())
}

private fun askInt(): Int {
    var isNumber = false;
    var quantity: Int = 0

    while (!isNumber) {
        try {
            println("Introducir número: ");
            quantity = readLine()!!.toInt();
            isNumber = true
        } catch (e: Exception) {
            println("No es un numero");
        }

    }
    return quantity;
}