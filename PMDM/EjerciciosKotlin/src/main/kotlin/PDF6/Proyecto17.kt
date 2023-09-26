package PDF6

import java.lang.Exception

fun main() {
    println("Introduce un valor comprendido entre 1 y 99")
    val number = askInt();
    val digits = if(number <10) 1 else 2;
    println("Tiene $digits digitos");
}

private fun askInt(): Int {
    var isNumber = false;
    var quantity: Int = 0

    while (!isNumber) {
        try {
            println("Introducir número: ");
            quantity = readLine()!!.toInt();
            if (quantity  <= 99 && quantity >= 1) {
                isNumber = true;
            } else {
                println("Introduce un número entre 1 y 99")
            }

        } catch (e: Exception) {
            println("No es un numero");
        }

    }
    return quantity;
}