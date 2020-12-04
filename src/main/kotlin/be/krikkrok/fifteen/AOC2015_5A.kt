package be.krikkrok.fifteen

import be.krikkrok.BaseAoc
import be.krikkrok.fifteen.pojo.NaughtyOrNiceName

class AOC2015_5A: BaseAoc() {
    init {
        val names = ArrayList<NaughtyOrNiceName>()
        asReader("/2015/AOC2015_5A.txt").forEachLine { name ->
            names.add(NaughtyOrNiceName(name))
        }

        println(names.count())
        println(names.filter { it.isNice() }.count())
    }
}

fun main() {
    AOC2015_5A()
}