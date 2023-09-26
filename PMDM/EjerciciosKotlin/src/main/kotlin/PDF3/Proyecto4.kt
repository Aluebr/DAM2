package PDF3

val firstWeight:Float = 25F;
val secondWeight:Float = 90F;
val thirdWeight:Float = 50F;


fun main() {
    println("La media es: ${calculateWeight(firstWeight, secondWeight, thirdWeight)}")
}

fun calculateWeight(firstWeight:Float,secondWeight:Float,thirdWeight:Float):Float{
    var average = (firstWeight + secondWeight + thirdWeight) / 3;
    return average;
}