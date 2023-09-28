package PDF9

import java.lang.Exception

fun main() {
    var numberInput = askInt();
    var number = 1;
    while (number <= numberInput){
        println(number)
        number++
    }
}

private fun askInt(): Int {
    var isNumber = false;
    var quantity: Int = 0

    while (!isNumber) {
        try {
            println("Introducir número: ");
            quantity = readLine()!!.toInt();
            isNumber = true;

        } catch (e: Exception) {
            println("No es un numero");
        }

    }
    return quantity;
}