fun main() {
    fun part1(input: List<String>): Int {
        var max = 0
        var current = 0
        input.forEach {
            if (it != "") {
                current += it.toInt()
            } else {
                max = maxOf(max, current)
                current = 0
            }
            if (current != 0) {
                max = maxOf(max, current)
            }
        }
        return max
    }

    fun part2(input: List<String>): Int {
        val top3 = intArrayOf(0, 0, 0)
        fun submitTop3(n: Int) {
            var min = Int.MAX_VALUE
            var minIndex = 0
            top3.forEachIndexed { index, num ->
                if (num < min) {
                    min = num
                    minIndex = index
                }
            }
            if (n > min) {
                top3[minIndex] = n
            }
        }
        var current = 0
        input.forEach {
            if (it != "") {
                current += it.toInt()
            } else {
                submitTop3(current)
                current = 0
            }
        }
        if (current != 0) {
            submitTop3(current)
        }
        return top3.sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 24000)
    check(part2(testInput) == 45000)

    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
