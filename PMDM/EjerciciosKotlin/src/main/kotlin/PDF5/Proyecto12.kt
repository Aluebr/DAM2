package PDF5

import PDF4.result
import java.lang.Exception

fun main() {
    println("Introduce dos números para saber el mayor")
    var firstNumber = askNumbers();
    var secondNumber = askNumbers();

    conditionGreaterNumber(firstNumber,secondNumber);


}

fun askNumbers(): Int {
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

fun conditionGreaterNumber(firstNumber:Int,secondNumber:Int){
    if (firstNumber < secondNumber) {
        println("Suma: ${plusNumbers(firstNumber,secondNumber)} ");
        println("Resta: ${minusNumbers(firstNumber,secondNumber)} ");

    } else {
        println("Multiplicacion: ${productNumbers(firstNumber,secondNumber)} ");
        println("Division: ${divideNumbers(firstNumber,secondNumber)} ");
    }
}

fun plusNumbers(firstNumber: Int, secondNumber: Int):Int {
    result = firstNumber + secondNumber;
    return result;
}

fun minusNumbers(firstNumber: Int, secondNumber: Int):Int {
    result = firstNumber - secondNumber;
    return result;
}
fun productNumbers(firstNumber: Int, secondNumber: Int):Int {
    result = firstNumber * secondNumber;
    return result;
}
fun divideNumbers(firstNumber: Int, secondNumber: Int):Int {
    result = firstNumber / secondNumber;
    return result;
}
