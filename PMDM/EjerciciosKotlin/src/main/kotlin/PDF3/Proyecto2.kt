package PDF3

val firstNumber: Int = 30;
val secondNumber: Int = 200;

var result = 0;
fun main() {


    println("Suma: ${plusNumbers(firstNumber, secondNumber)}");
    println("Multiplication: ${productNumbers(firstNumber, secondNumber)}");



}
fun plusNumbers(firstNumber: Int, secondNumber: Int):Int {
    result = firstNumber + secondNumber;
    return result;
}

fun productNumbers(firstNumber: Int, secondNumber: Int):Int {
    result = firstNumber * secondNumber;
    return result;
}