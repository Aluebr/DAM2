package PDF7


import java.lang.Exception

fun main() {
    var firstNumber = askInt();
    var secondNumber = askInt();
    var thirdNumber = askInt();

    if(firstNumber > secondNumber && firstNumber > thirdNumber){
        println(firstNumber)
    }else if ( secondNumber > thirdNumber){
        println(secondNumber)
    }else{
        println(thirdNumber)
    }


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