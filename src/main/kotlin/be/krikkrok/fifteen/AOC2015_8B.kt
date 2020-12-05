package be.krikkrok.fifteen

import be.krikkrok.BaseAoc
import be.krikkrok.fifteen.pojo.CircuitCommand
import be.krikkrok.fifteen.pojo.CircuitOperation
import kotlin.collections.HashMap


class AOC2015_8B : BaseAoc() {


    init {
        var stringCode = 0
        var encoded = 0

        asReader("/2015/AOC2015_8A.txt").forEachLine { line ->
            stringCode += line.trim().length
            encoded += line.trim().length + line.trim().filter { c: Char -> c == '"' || c == '\\' }.count() + 2
        }

        println(encoded - stringCode)
    }
}

fun main() {
    AOC2015_8B()
}