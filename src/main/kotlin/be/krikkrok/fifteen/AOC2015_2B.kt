package be.krikkrok.fifteen

import be.krikkrok.BaseAoc
import java.util.concurrent.atomic.AtomicInteger

class AOC2015_2B: BaseAoc() {
    val current = AtomicInteger(0)

    init {
        asReader("/2015/AOC2015_2A.txt").forEachLine {
            val split = it.split("x")
            val height = split[0].toInt()
            val width = split[1].toInt()
            val length = split[2].toInt()

            val bow = width * length * height

            val sorted = listOf(height, width, length).sorted()

            current.addAndGet(sorted[0] + sorted[0] + sorted[1] + sorted[1] + bow)

        }

        println(current.get())
    }
}

fun main() {
    AOC2015_2B()
}