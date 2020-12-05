package be.krikkrok.fifteen

import be.krikkrok.BaseAoc
import be.krikkrok.fifteen.pojo.CircuitCommand
import be.krikkrok.fifteen.pojo.CircuitOperation
import be.krikkrok.fifteen.pojo.FlightDistance
import be.krikkrok.fifteen.util.StringPermutator
import kotlin.collections.HashMap


class AOC2015_10A : BaseAoc() {

    var input = "3113322113"
    val times = 40

    init {
        (1..times).forEach {
            println(it)
            input = lookAndSay(input)
        }

        println(input.length)
    }

    fun lookAndSay(input: String): String {
        var output = ""

        var currentChar = 'A'
        var currentCount = 0

        input.forEach { c: Char ->
            when (currentChar) {
                'A' -> {
                    currentChar = c
                    currentCount++
                }
                c -> {
                    currentCount++
                }
                else -> {
                    output = "$output$currentCount$currentChar"
                    currentChar = c
                    currentCount = 1
                }
            }
        }

        return "$output$currentCount$currentChar"
    }
}

fun main() {
    AOC2015_10A()
}