package PDF5

import java.lang.Exception

fun main() {
    var firstNumber = askNumber();
    var secondNumber = askNumber();

    println("Introduce dos números para saber el mayor")
    printNumberGreater(firstNumber,secondNumber);

}

fun askNumber(): Int {
    var isNumber = false;
    var quantity: Int = 0
    while (!isNumber) {

        try {
            println("Introducir número: ");
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

fun printNumberGreater(firstNumber: Int, secondNumber: Int) {
    if (firstNumber > secondNumber) {
        println("El mayor es $firstNumber");
    } else {
        println("El mayor es $secondNumber");
    }
}