package PDF11

fun main() {
    var multiple3 = 0;
    var multiple5 = 0;
    var multiple9 = 0;

    for(i in 1..10000) {
        if (i % 3 == 0)
            multiple3++
        if (i % 5 == 0)
            multiple5++
        if (i % 8 == 0)
            multiple9++
    }
    println("Cantidad de múltiplos de 3: $multiple3")
    println("Cantidad de múltiplos de 5: $multiple5")
    println("Cantidad de múltiplos de 9: $multiple9")
}
