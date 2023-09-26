package PDF5

import java.lang.Exception

fun main() {
    isPromoted();
}
private fun askInt(): Int {
    var isNumber = false;
    var quantity: Int = 0
    while (!isNumber) {

        try {
            println("Introducir número: ");
            quantity = readLine()!!.toInt();
            if (quantity  <= 10 && quantity >= 0) {
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

fun isPromoted(){
    println("Introduce tus 3 notas")
    var firstNumber= askNumbers();
    var secondNumber = askNumber();
    var thirdNumber = askNumber();

    var average = (firstNumber + secondNumber + thirdNumber) / 3
    if(average >= 7){
        println("Promocionado");
    }else{
        println("No promocionado");
    }

}