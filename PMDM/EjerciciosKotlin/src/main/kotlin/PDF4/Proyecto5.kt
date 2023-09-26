package PDF4


import java.util.Scanner
var result = 0;
val sc = Scanner(System.`in`);


fun main() {
    var (firstNumber, secondNumber) = askNumbers();


    println("Suma: ${plusNumbers(firstNumber, secondNumber)}");
    println("Multiplicacion: ${productNumbers(firstNumber, secondNumber)}");

}

private fun askNumbers():Pair<Int,Int>{
    println("Introduce el primer valor: ");
    var firstNumber = sc.nextInt();
    println("Introduce el segundo valor: ");
    var secondNumber = sc.nextInt();
    return Pair(firstNumber,secondNumber);

}
fun plusNumbers(firstNumber: Int, secondNumber: Int):Int {
    result = firstNumber + secondNumber;
    return result;
}

fun productNumbers(firstNumber: Int, secondNumber: Int):Int {
    result = firstNumber * secondNumber;
    return result;
}