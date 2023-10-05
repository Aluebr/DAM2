package PDF12


import java.lang.Exception

fun main() {
    var total = 0
    for (i in 1..5){
        println("Introduce tres valores: ")
        var firstNumber = askInt()
        var secondNumber = askInt()
        var thirdNumber = askInt()

        total += when{
            firstNumber > secondNumber && firstNumber > thirdNumber -> firstNumber
            secondNumber > thirdNumber -> secondNumber
            else -> thirdNumber
        }
    }
    println("El valor total de la suma de los mayores es: $total")
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