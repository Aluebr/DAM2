package PDF12

import java.lang.Exception

fun main() {
    var sum = 0
    for (i in 1..10){
        val salary = askInt()


        sum += when{
            salary > 5000 -> {
                println("Sueldo alto")
                salary
            }
            salary > 2000 -> {
                println("Sueldo medio")
                0
            }
            else -> {
                println("Sueldo bajo")
                0
            }
        }

    }
    println("Costes totales: $sum")

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