package PDF10

import java.lang.Exception

fun main() {
    do{
        println("Introduce números entre 0 y 999. 0 para detener");
        var numberInput = askInt();
        if(numberInput <10){
            println("Tiene 1 dígito")
        }else if(numberInput <100){
            println("Tiene 2 dígitos")
        }else{
            println("Tiene 3 dígitos")
        }
    }while (numberInput != 0)
    println("Saliendo del programa")
}

private fun askInt(): Int {
    var isNumber = false;
    var quantity: Int = 0

    while (!isNumber) {
        try {
            println("Introducir número: ");
            quantity = readLine()!!.toInt();
            if (quantity <= 999 && quantity >= 0) {
                isNumber = true;
            } else {
                println("Introduce un número entre 0 y 999")
            }

        } catch (e: Exception) {
            println("No es un numero");
        }

    }
    return quantity;
}