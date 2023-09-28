package PDF7


import java.lang.Exception

fun main() {
    var firstNumber = askInt();
    var secondNumber = askInt();
    var thirdNumber = askInt();


    var average = average(firstNumber,secondNumber,thirdNumber);

    if(average >= 7){
        println("Promocionado")
    }else if(average >= 4 && average < 7){
        println("Regular")
    }else{
        println("Reprobado")
    }
}

private fun average(f:Int,s:Int,t:Int):Float{
    var average:Float = (f + s + t) / 3F
    return average;
}
private fun askInt(): Int {
    var isNumber = false;
    var quantity: Int = 0

    while (!isNumber) {
        try {
            println("Introducir número: ");
            quantity = readLine()!!.toInt();
            if (quantity  <= 10 && quantity >= 1) {
                isNumber = true;
            } else {
                println("Introduce un número entre 1 y 10")
            }

        } catch (e: Exception) {
            println("No es un numero");
        }

    }
    return quantity;
}