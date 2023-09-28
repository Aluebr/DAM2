package PDF8

fun main() {
    print("Ingrese día:")
    val dia = readLine()!!.toInt()
    print("Ingrese mes:")
    val mes = readLine()!!.toInt()
    print("Ingrese Año:")
    val año = readLine()!!.toInt()
    if (mes == 1 || mes == 2 || mes == 3)
        print("Corresponde al primer trimestre");
}