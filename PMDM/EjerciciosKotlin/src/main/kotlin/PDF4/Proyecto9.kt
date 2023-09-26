package PDF4


import java.lang.Exception
import java.util.*

var productTotal = 0
var sumTotal = 0

fun main(){

    askNumbers()
}

private fun askNumbers() {
    var input = Scanner(System.`in`)

    var firstNumber = 0
    var seconNumber = 0
    var thirdNumber = 0
    var fourthNumber = 0


    try {
        println("Introduce el primer número:")
        firstNumber = input.nextInt()
        println("Introduce el segundo número:")
        seconNumber = input.nextInt()
        println("Introduce el tercer número:")
        thirdNumber = input.nextInt()
        println("Introduce el cuarto número:")
        fourthNumber = input.nextInt()
    } catch (e: Exception) {
        println("No has introducido un número")
    }

    comprobations(firstNumber, seconNumber, thirdNumber, fourthNumber)
}

private fun comprobations(

    firstNumber: Int,
    seconNumber: Int,
    thirdNumber: Int,
    fourthNumber: Int
) {
    if (firstNumber != 0 && seconNumber != 0 && thirdNumber != 0 && fourthNumber != 0) {
        sumFirst(firstNumber, seconNumber)
        productSecond(thirdNumber, fourthNumber)
        println("La suma de $firstNumber y $seconNumber es $sum")
        println("La multiplicación de $thirdNumber y $fourthNumber es $product")
    } else {
        println("")
    }
}

fun sum(firstNumber: Int , secondNumber: Int, thirdNumber:Int,fourthNumber: Int):Int{

    sum = firstNumber + secondNumber + thirdNumber + fourthNumber
    return sum
}

fun product(firstNumber: Int , secondNumber: Int, thirdNumber:Int,fourthNumber: Int):Int{

    product = firstNumber * secondNumber * thirdNumber * fourthNumber
    return  product

}