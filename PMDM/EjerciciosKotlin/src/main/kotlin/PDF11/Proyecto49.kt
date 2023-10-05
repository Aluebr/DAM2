package PDF11

import java.lang.Exception

fun main() {
    var greater = 0;
    var lower = 0;
    for (i in 1..10){
        var numberInput = askInt();
        if(numberInput >= 7){
            greater++;
        }else{
            lower++
        }
    }
    println("Mayor o igual a 7: $greater");
    println("Menores a 7: $lower");

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