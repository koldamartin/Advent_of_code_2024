import java.io.File

fun processNumbers(numbers: List<Int>): Boolean {
    val isIncreasing = numbers[1] > numbers[0]
    for (i in 0 until numbers.size - 1) {
        val difference: Int
        if (isIncreasing) {
            difference = numbers[i + 1] - numbers[i]
        } else {
            difference = numbers[i] - numbers[i + 1]
        }

        if (difference < 1 || difference > 3) {
            return false
        }

        if (i == numbers.size - 2) {
            return true
        }
    }
    return false
}

fun main() {
    var sumB = 0
    val file = File("src/input_day_2.txt")

    file.useLines { lines ->
        lines.forEach { line ->
            val numbers = line.split(" ").map { it.toInt() }
            var isValidLine = false
            for (i in numbers.indices) {
                val newList = numbers.toMutableList().apply { removeAt(i) }
                if (processNumbers(newList)) {
                    isValidLine = true
                    break
                }
            }
            if (isValidLine) {
                sumB += 1
            }
        }
    }

    println("\nTotal Sum part B: $sumB")
}