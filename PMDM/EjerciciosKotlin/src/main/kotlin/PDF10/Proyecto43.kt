package PDF10

import java.lang.Exception

fun main() {

    var sum = 0;
    var i = 0;
    do {
        var numberInput = askInt()
        sum += numberInput
        i++


    }while (numberInput != 0);
    i--
    var average = (sum/i)
    println("Promedio: $average")

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