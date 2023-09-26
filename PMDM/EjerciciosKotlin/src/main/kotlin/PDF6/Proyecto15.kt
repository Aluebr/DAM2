package PDF6

import PDF5.askNumber
import java.lang.Exception

fun main() {
    var firstNumber = askNumber();
    var secondNumber = askNumber();

    var greater = if (firstNumber > secondNumber) firstNumber else secondNumber
    println("El mayor es $greater");
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