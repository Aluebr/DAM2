package PDF6

import PDF5.askNumber
import java.lang.Exception

fun main() {
    print("Ingrese un valor entero:")
    val number = askNumber()
    val resultado = if (number % 2 == 0) {
        print("Cuadrado:")
        number * number
    } else {
        print("Cubo:")
        number * number * number
    }
    print(resultado)
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