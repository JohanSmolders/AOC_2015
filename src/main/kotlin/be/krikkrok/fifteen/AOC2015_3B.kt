package be.krikkrok.fifteen

import be.krikkrok.BaseAoc
import be.krikkrok.fifteen.pojo.Location
import be.krikkrok.fifteen.pojo.SantasHome
import java.util.concurrent.atomic.AtomicInteger

class AOC2015_3B: BaseAoc() {
    val homes = arrayListOf(SantasHome(0, 0, 2))

    init {

        var real  = true
        val santa = Location()
        val robotSanta = Location()


        asReader("/2015/AOC2015_3A.txt").forEachLine { commands ->
            commands.chars().forEach { command ->
                val current = if (real) santa else robotSanta
                when(command.toChar()){
                    '^' -> current.x--
                    'v' -> current.x++
                    '<' -> current.y--
                    '>' -> current.y++
                    else -> println("Unknown command: ${command.toChar()}")
                }

                homes.filter { it.isHome(current.x, current.y) }.firstOrNull()?.let {
                    it.addPresent()
                } ?: run {
                    homes.add(SantasHome(current.x, current.y))
                }

                real = !real
            }

            println("Santa visited ${homes.size} homes")
        }

    }
}

fun main() {
    AOC2015_3B()
}