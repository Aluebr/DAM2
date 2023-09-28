package PDF8

import PDF3.firstNumber
import PDF5.askNumber
import java.lang.Exception

fun main() {
    var firstNumber = askNumber();
    var secondNumber = askNumber();
    var thirdNumber = askNumber();

    var cubo = firstNumber * secondNumber * thirdNumber
    if (firstNumber == secondNumber && firstNumber == thirdNumber) {
        println("El cubo de $firstNumber es $cubo")
    }else{
        println("Los lados no son iguales")
    }
}

private fun askInt(): Int {
    var isNumber = false;
    var quantity: Int = 0

    while (!isNumber) {
        try {
            println("Introducir número: ");
            quantity = readLine()!!.toInt();
            if (quantity <= 10 && quantity >= 1) {
                isNumber = true;
            } else {
                println("Introduce un número entre 1 y 10")
            }

        } catch (e: Exception) {
            println("No es un numero");
        }

    }
    return quantity;
}