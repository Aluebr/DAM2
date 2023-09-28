package PDF9

import java.lang.Exception

fun main() {
    var number = 1;
    var sum = 0;
    while (number <= 10){
        var valor =  askInt()
        sum += valor
        number++
    }
    println("La suma de los valores es: $sum");
    var average = sum/10
    println("El promedio es: $average");
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