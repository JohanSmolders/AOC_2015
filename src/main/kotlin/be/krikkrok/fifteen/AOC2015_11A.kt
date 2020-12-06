package be.krikkrok.fifteen

import be.krikkrok.BaseAoc
import be.krikkrok.fifteen.pojo.CircuitCommand
import be.krikkrok.fifteen.pojo.CircuitOperation
import be.krikkrok.fifteen.pojo.FlightDistance
import be.krikkrok.fifteen.pojo.SantaPassword
import be.krikkrok.fifteen.util.StringPermutator
import kotlin.collections.HashMap


class AOC2015_11A : BaseAoc() {

    init {
        println(SantaPassword("cqjxjnds").nextValidPassword())
    }

}

fun main() {
    AOC2015_11A()
}