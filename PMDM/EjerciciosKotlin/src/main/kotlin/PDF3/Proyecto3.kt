package PDF3

fun main() {

    val side = 50
    val perimeter = calculatePerimeter(side)
    val surface = calculateSurface(side)

    println("The perimeter of a square with a side of $side is $perimeter " +
            "and the surface is $surface")
}

fun calculatePerimeter(side:Int):Int{

    val perimeter = side * 4
    return perimeter
}

fun calculateSurface(side: Int):Int{

    val surface = side * side
    return surface
}