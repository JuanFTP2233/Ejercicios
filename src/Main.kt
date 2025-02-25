import java.util.Scanner

class Alcancia {
    private val monedas = mutableMapOf(
        20 to 0,
        50 to 0,
        100 to 0,
        200 to 0,
        500 to 0
    )


    fun agregarMoneda(denominacion: Int) {
        if (monedas.containsKey(denominacion)) {
            monedas[denominacion] = monedas[denominacion]!! + 1
            println("Moneda de $$denominacion agregada.")
        } else {
            println("Denominación no válida.")
        }
    }


    fun contarMonedas() {
        println("Cantidad de monedas en la alcancía:")
        monedas.forEach { (denominacion, cantidad) ->
            println("Monedas de $$denominacion: $cantidad")
        }
    }


    fun calcularTotal(): Int {
        return monedas.entries.sumOf { (denominacion, cantidad) -> denominacion * cantidad }
    }

    fun romperAlcancia(): Map<Int, Int> {
        val contenido = monedas.toMap()
        monedas.replaceAll { _, _ -> 0 }
        println("La alcancía ha sido rota y su contenido vaciado.")
        return contenido
    }
}

fun main() {
    val alcancia = Alcancia()
    val scanner = Scanner(System.`in`)

    println("Bienvenido a la alcancía. Ingresa las monedas que deseas agregar.")

    var continuar = true
    while (continuar) {
        println("Ingresa la denominación de la moneda (20, 50, 100, 200, 500) o escribe '0' para terminar:")
        val input = scanner.nextInt()

        when (input) {
            0 -> continuar = false // Salir del bucle
            20, 50, 100, 200, 500 -> alcancia.agregarMoneda(input)
            else -> println("Denominación no válida. Intenta nuevamente.")
        }
    }

    // Menú Separacion
    var opcion: Int
    do {
        println("\n¿Qué deseas hacer?")
        println("1. Contar monedas")
        println("2. Calcular total ahorrado")
        println("3. Romper la alcancía")
        println("4. Salir")
        print("Elige una opción: ")
        opcion = scanner.nextInt()

        when (opcion) {
            1 -> alcancia.contarMonedas()
            2 -> {
                val totalAhorrado = alcancia.calcularTotal()
                println("Total ahorrado: $$totalAhorrado")
            }
            3 -> {
                val contenido = alcancia.romperAlcancia()
                println("Contenido de la alcancía al romperla: $contenido")
            }
            4 -> println("Saliendo del programa...")
            else -> println("Opción no válida. Intenta nuevamente.")
        }
    } while (opcion != 4)

    scanner.close()
}