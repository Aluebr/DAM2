package PDF5

import java.lang.Exception

fun main() {

    salaryOverThreeThousand(askQuantity())

}

fun askQuantity(): Double {
    var isNumber = false;
    var quantity: Double = 0.0
    while (!isNumber) {

        try {
            println("Introduce la cantidad: ");
            quantity = readLine()!!.toDouble();
            if (quantity > 0) {
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

fun salaryOverThreeThousand(salary: Double) {
    if (salary > 3000) {
        println("Tienes que pagar las tasas");
    }else{
        println("No tienes que pagar");
    }
}