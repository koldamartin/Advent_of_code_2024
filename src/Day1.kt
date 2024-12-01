import java.io.File

fun main() {
    val file = File("src/input_day_1.txt")
    val leftList = mutableListOf<Int>()
    val rightList = mutableListOf<Int>()

    file.forEachLine { line ->
        val (left, right) = line.split("   ")
        leftList.add(left.toInt())
        rightList.add(right.toInt())
    }
    sumPartB(leftList, rightList)
    sumPartA(leftList, rightList)
}

fun sumPartA(leftList: MutableList<Int>, rightList: MutableList<Int>) {
    var totalSum = 0

    while (leftList.isNotEmpty() && rightList.isNotEmpty()) {
        val minLeft = leftList.minOrNull()
        val minRight = rightList.minOrNull()

        if (minLeft != null && minRight != null) {
            totalSum += Math.abs(minLeft - minRight)
            leftList.remove(minLeft)
            rightList.remove(minRight)
        } else {
            break
        }
    }
    println("\nTotal Sum part A: $totalSum")
}

fun sumPartB(leftList: MutableList<Int>, rightList: MutableList<Int>) {
    var totalSum = 0

    for (num in leftList) {
        val count = rightList.count { it == num }
        totalSum += (num * count)
    }
    println("\nTotal Sum part B: $totalSum")
}