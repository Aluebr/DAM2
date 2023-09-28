package PDF7

import java.lang.Exception

fun main() {
    println("Dime el número de preguntas del exámen:")
    var quantityAnswers = askInt();
    println("Dime el número total de respuestas correctas");
    var correctAnswers = askInt();

    var percentage =  correctAnswers * 100 / quantityAnswers

    if(percentage >=90){
        println("Nivel máximo")
    }else if(percentage >= 75){
        println("Nivel medio")
    }else if(percentage >= 50){
        println("Nivel regular")
    }else{
        println("Fuera de nivel")
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