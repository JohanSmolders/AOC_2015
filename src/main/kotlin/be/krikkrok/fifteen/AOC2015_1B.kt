package be.krikkrok.fifteen

import be.krikkrok.BaseAoc
import java.lang.System.exit
import java.util.concurrent.atomic.AtomicInteger

class AOC2015_1B: BaseAoc() {
    init {
        val current = AtomicInteger(0)

        asResource("/2015/AOC2015_1A.txt").readText().forEachIndexed{index: Int, c: Char ->
            if(if(c == '('){
                    current.incrementAndGet()
                }else{
                    current.decrementAndGet()
                } == -1 ){
                println(index+1)
                exit(0)
            }
        }

    }
}

fun main() {
    AOC2015_1B()
}