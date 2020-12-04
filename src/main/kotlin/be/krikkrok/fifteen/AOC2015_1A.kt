package be.krikkrok.fifteen

import be.krikkrok.BaseAoc

class AOC2015_1A: BaseAoc() {
    init {
        val input = asResource("/2015/AOC2015_1A.txt").readText()
        val positive = input.count { c: Char -> c == '(' }
        val negative = input.count { c: Char -> c == ')' }

        println(positive - negative)
    }
}

fun main() {
    AOC2015_1A()
}