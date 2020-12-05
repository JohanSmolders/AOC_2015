package be.krikkrok.fifteen

import be.krikkrok.BaseAoc
import be.krikkrok.fifteen.pojo.CircuitCommand
import be.krikkrok.fifteen.pojo.CircuitOperation
import kotlin.collections.HashMap


class AOC2015_8A : BaseAoc() {


    init {
        var stringCode = 0
        var characterCode = 0

        asReader("/2015/AOC2015_8A.txt").forEachLine { line ->
            stringCode += line.trim().length

            val unQuoted =  line.trim().substring(1, line.trim().length -1)

            characterCode +=  unQuoted.replace(Regex("\\\\x[a-f0-9][a-f0-9]"), "-").replace("\\\\", "\\").replace("\\\"", "\"").length

        }

        println(stringCode-characterCode)
    }
}

fun main() {
   AOC2015_8A()
}