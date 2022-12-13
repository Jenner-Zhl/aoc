fun main() {

    val regex = Regex("[-,]")

    fun processInput(input: List<String>, block: (List<Int>) -> Boolean): Int {
        var count = 0
        input.forEach {line ->
            val numbers = line.split(regex).map { it.toInt() }
            if (block(numbers)) {
                count++
                println(line)
            }

        }
        return count
    }

    fun part1(input: List<String>): Int {
        return processInput(input) {numbers ->
            (numbers[0] - numbers[2]) * (numbers[1] - numbers[3]) <= 0
        }
    }


    fun part2(input: List<String>): Int {
        return processInput(input) {numbers ->
            numbers[0] <= numbers[3] && numbers[1] >= numbers[2]
        }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day04_test")
//    check(part1(testInput) == 2)
    check(part2(testInput) == 4)

    val input = readInput("Day04")
//    part1(input).println()
    part2(input).println()
}
