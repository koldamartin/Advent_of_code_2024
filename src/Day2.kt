import java.io.File

fun main() {
    var sumA = 0
    val file = File("src/input_day_2.txt")
    file.useLines { lines ->
        lines.forEach { line ->
            val numbers = line.split(" ").map { it.toInt() }

            val isIncreasing = numbers[1] > numbers[0]
            for (i in 0 until numbers.size - 1) {
                val difference: Int
                if (isIncreasing) {
                    difference = numbers[i + 1] - numbers[i]
                } else {
                    difference = numbers[i] - numbers[i + 1]
                }

                if (difference < 1 || difference > 3) {
                    break
                }

                if (i == numbers.size - 2) {
                    sumA += 1
                }
            }
        }
    }
    println("\nTotal Sum part A: $sumA")
}
