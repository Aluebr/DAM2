package PDF12

import java.lang.Exception

fun main() {
    var numberInput = askInt()

    when{
        numberInput == 0 -> println("Número nulo")
        numberInput > 0 -> println("Número positivo")
        else -> println("Número negativo")
    }

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