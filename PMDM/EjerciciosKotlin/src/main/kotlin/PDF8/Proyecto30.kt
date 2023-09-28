package PDF8

import java.lang.Exception

fun main() {
    var firstNumber = askInt()
    var secondNumber = askInt()
    var thirdNumber = askInt()

    var greatestNumber = greaterNumber(firstNumber,secondNumber,thirdNumber)
    var lowestNumber = lowerNumber(firstNumber,secondNumber,thirdNumber)

    println("Mayor: $greatestNumber \nMenor: $lowestNumber");
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

private fun greaterNumber(firstNumber:Int,secondNumber:Int,thirdNumber:Int):Int{
    var greater:Int;
    if(firstNumber > secondNumber && firstNumber > thirdNumber){
        greater = firstNumber;
    }else if(secondNumber > thirdNumber){
        greater = secondNumber;
    }else{
        greater = thirdNumber;
    }
    return greater;
}
private fun lowerNumber(firstNumber:Int,secondNumber:Int,thirdNumber:Int):Int{
    var greater:Int;
    if(firstNumber < secondNumber && firstNumber < thirdNumber){
        greater = firstNumber;
    }else if(secondNumber < thirdNumber){
        greater = secondNumber;
    }else{
        greater = thirdNumber;
    }
    return greater;
}