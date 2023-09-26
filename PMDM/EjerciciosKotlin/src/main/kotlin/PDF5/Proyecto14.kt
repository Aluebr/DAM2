package PDF5

import java.lang.Exception

fun main() {
    println("Introduce un número entre 1 y 99")
    var numberDigit = askInt();
    if (numberDigit < 10){
        println("Tiene un dígito")
    }else{
        println("Tiene dos dígitos")
    }
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