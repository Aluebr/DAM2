package PDF12

import java.lang.Exception

fun main() {

    val noteOne = askInt()
    val noteTwo = askInt()
    val noteThree = askInt()

    var promedio = (noteOne + noteTwo + noteThree) / 3

    when {
        promedio >= 7 -> println("Promocionado")
        promedio >= 4 -> println("Regular")
        else -> println("Libre")
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