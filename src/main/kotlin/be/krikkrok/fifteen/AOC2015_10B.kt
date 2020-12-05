package be.krikkrok.fifteen

import be.krikkrok.BaseAoc
import be.krikkrok.fifteen.pojo.CircuitCommand
import be.krikkrok.fifteen.pojo.CircuitOperation
import be.krikkrok.fifteen.pojo.FlightDistance
import be.krikkrok.fifteen.util.StringPermutator
import kotlin.collections.HashMap

class AOC2015_10B : BaseAoc() {

    var input = "3113322113"
    val times = 50

    init {
        (1..times).forEach {
            println(it)
            input = lookAndSay(input)
        }

        println(input.length)
    }

    fun lookAndSay(input: String): String {
        var output = StringBuilder()

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
                    output = output.append("$currentCount$currentChar")
                    currentChar = c
                    currentCount = 1
                }
            }
        }

        output = output.append("$currentCount$currentChar")
        return output.toString()
    }
}

fun main() {
    AOC2015_10B()
}