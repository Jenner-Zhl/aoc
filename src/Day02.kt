const val ROCK = "A"
const val ROCK_RESPONSE = "X"
const val PAPER = "B"
const val PAPER_RESPONSE = "Y"
const val SCISSORS = "C"
const val SCISSORS_RESPONSE = "Z"

const val SCORE_ROCK = 1
const val SCORE_PAPER = 2
const val SCORE_SCISSORS = 3

const val SCORE_DRAW = 3
const val SCORE_WIN = 6

enum class Response(val s: String) {
    WIN("Z"),
    DRAW("Y"),
    LOSE("X")
}

fun main() {

    val resultMap = HashMap<String, Int>()
    val resultMap2 = HashMap<String, Int>()

    fun score(shape: String, response: String): Int {
        var res = 0
        if (response == ROCK_RESPONSE) {
            res += SCORE_ROCK
            if (shape == ROCK) {
                res += SCORE_DRAW
            } else if (shape == SCISSORS) {
                res += SCORE_WIN
            }
        } else if (response == PAPER_RESPONSE) {
            res += SCORE_PAPER
            if (shape == PAPER) {
                res += SCORE_DRAW
            } else if (shape == ROCK) {
                res += SCORE_WIN
            }
        } else if (response == SCISSORS_RESPONSE) {
            res += SCORE_SCISSORS
            if (shape == SCISSORS) {
                res += SCORE_DRAW
            } else if (shape == PAPER) {
                res += SCORE_WIN
            }
        }

        return res
    }

    fun winScore(shape: String): Int {
        return when(shape) {
            ROCK -> SCORE_PAPER
            PAPER -> SCORE_SCISSORS
            SCISSORS -> SCORE_ROCK
            else -> 0
        }
    }

    fun loseScore(shape: String): Int {
        return when(shape) {
            ROCK -> SCORE_SCISSORS
            PAPER -> SCORE_ROCK
            SCISSORS -> SCORE_PAPER
            else -> 0
        }
    }

    fun drawScore(shape: String): Int {
        return when(shape) {
            ROCK -> SCORE_ROCK
            PAPER -> SCORE_PAPER
            SCISSORS -> SCORE_SCISSORS
            else -> 0
        }
    }

    fun score2(shape: String, response: String): Int {
        var res = 0
        when(response) {
            Response.LOSE.s -> res += loseScore(shape)
            Response.DRAW.s -> res += drawScore(shape) + SCORE_DRAW
            Response.WIN.s -> res += winScore(shape) + SCORE_WIN
        }
        return res
    }

    fun initMap() {
        val shapes = arrayOf(ROCK, PAPER, SCISSORS)
        val responseShapes = arrayOf(ROCK_RESPONSE, PAPER_RESPONSE, SCISSORS_RESPONSE)

        shapes.forEach { shape ->
            responseShapes.forEach {
                val key = "$shape $it"
                val score = score(shape, it)
                val score2 = score2(shape, it)
                resultMap[key] = score
                resultMap2[key] = score2
                println("$key : $score | $score2")
            }
        }
    }

    fun part1(input: List<String>): Int {
        var sum = 0
        val input = readInput("Day02")
        input.forEach {
            sum += resultMap[it]!!
        }
        return sum
    }

    fun part2(input: List<String>): Int {
        var sum = 0
        input.forEach {
            sum += resultMap2[it]!!
        }
        return sum
    }

    initMap()

    val input = readInput("Day02")

    part1(input).println()
    part2(input).println()
}
