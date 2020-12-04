package be.krikkrok.fifteen

import be.krikkrok.BaseAoc
import be.krikkrok.fifteen.pojo.SantasHome
import java.util.concurrent.atomic.AtomicInteger

class AOC2015_3A: BaseAoc() {
    init {

        var currentX = 0
        var currentY = 0
        val homes = arrayListOf(SantasHome(currentX, currentY))
        asReader("/2015/AOC2015_3A.txt").forEachLine { commands ->
            commands.chars().forEach { command ->
                when(command.toChar()){
                    '^' -> currentX--
                    'v' -> currentX++
                    '<' -> currentY--
                    '>' -> currentY++
                    else -> println("Unknown command: ${command.toChar()}")
                }

                homes.filter { it.isHome(currentX, currentY) }.firstOrNull()?.let {
                    it.addPresent()
                } ?: run {
                    homes.add(SantasHome(currentX, currentY))
                }
            }

            println("Santa visited ${homes.size} homes")
        }

    }
}

fun main() {
    AOC2015_3A()
}