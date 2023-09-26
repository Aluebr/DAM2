package PDF4

import java.lang.Exception
import java.util.Scanner

val scanner = Scanner(System.`in`)
fun main() {
    var result=0;
    calculatePerimeterBySide();
}

private fun calculatePerimeterBySide(){
 var isNumber = false;
    while (!isNumber) {

     try {
         println("Introduce un numero: ");
         var squareSide = readLine()!!.toInt();
         var squarePerimeter = squareSide * 4;
         isNumber = true;
         println("El perimetro del cuadrado es: $squarePerimeter")
     } catch (e: Exception) {
         println("No es un numero");
     }
 }
}