fun main() {
    fun findCommonTypes(s: String): Set<Char> {
        val res = HashSet<Char>()
        val size = s.length
        val compartmentSize = size / 2
        val firstSet = HashSet<Char>(compartmentSize)
        for (i in 0 until compartmentSize) {
            val c = s[i]
            firstSet.add(c)
        }
        for (i in compartmentSize until size) {
            val c = s[i]
            if (firstSet.contains(c)) {
                res.add(c)
            }
        }

        return res
    }

    fun scoreOf(type: Char): Int {
        val res = if (type.isUpperCase()) {
            type - 'A' + 27
        } else {
            type - 'a' + 1
        }
        println("$type : $res")
        return res
    }

    fun part1(input: List<String>): Int {
        var totalScore = 0
        input.forEach {
            println(it)
            findCommonTypes(it).forEach {type ->
                totalScore += scoreOf(type)
            }
        }

        return totalScore
    }

    fun findCommonType(s: String, s1: String, s2: String): Char {
        val firstSet = hashSetOf<Char>()
        s.forEach {
            firstSet.add(it)
        }
        firstSet.forEach {
            if (s1.contains(it) && s2.contains(it)) {
                return it
            }
        }

        throw IllegalArgumentException()
    }

    fun part2(input: List<String>): Int {
        var totalScore = 0
        for (i in 0 until input.size / 3) {
            val j = i * 3
            val type = findCommonType(input[j], input[j + 1], input[j + 2])
            totalScore += scoreOf(type)
        }
        return totalScore
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 157)
    check(part2(testInput) == 70)

    val input = readInput("Day03")
    part1(input).println()
    part2(input).println()
}
