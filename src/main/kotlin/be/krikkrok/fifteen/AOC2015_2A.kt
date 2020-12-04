package be.krikkrok.fifteen

import be.krikkrok.BaseAoc
import java.util.concurrent.atomic.AtomicInteger

class AOC2015_2A: BaseAoc() {
    val current = AtomicInteger(0)

    init {
        asReader("/2015/AOC2015_2A.txt").forEachLine {
            val split = it.split("x")
            val height = split[0].toInt()
            val width = split[1].toInt()
            val length = split[2].toInt()

            val top = width * length
            val side = width  * height
            val front = length * height

            val rest = listOf(top, side, front).min()!!

            current.addAndGet(rest + (2*top) + (2*side) + (2*front))

        }

        println(current.get())
    }
}

fun main() {
    AOC2015_2A()
}