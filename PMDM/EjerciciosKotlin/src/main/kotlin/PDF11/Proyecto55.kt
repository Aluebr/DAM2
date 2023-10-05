package PDF11

import java.lang.Exception

fun main() {
    var numberInput = askInt();
    for(i in numberInput..numberInput*10 step numberInput){
        println(i)
    }

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