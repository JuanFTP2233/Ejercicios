import java.util.Random

fun main() {
    println("Ingrese el número de tiradas:")
    val numeroTiradas = readLine()?.toIntOrNull() ?: 0

    if (numeroTiradas <= 0) {
        println("El número de tiradas debe ser mayor que 0.")
        return
    }

    val contador = IntArray(6) { 0 }

    val random = Random()

    for (i in 1..numeroTiradas) {
        val resultado = random.nextInt(6) + 1
        println("Tirada $i: $resultado")
        contador[resultado - 1]++
    }

    println("\nResumen de tiradas:")
    for (i in 0 until 6) {
        println("Número ${i + 1}: ${contador[i]} veces")
    }
}

