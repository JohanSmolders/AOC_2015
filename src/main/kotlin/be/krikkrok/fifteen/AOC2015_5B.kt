package be.krikkrok.fifteen

import be.krikkrok.BaseAoc
import be.krikkrok.fifteen.pojo.NaughtyOrNiceName
import be.krikkrok.fifteen.pojo.NaughtyOrNiceNameV2

class AOC2015_5B: BaseAoc() {
    init {
        val names = ArrayList<NaughtyOrNiceNameV2>()
        asReader("/2015/AOC2015_5A.txt").forEachLine { name ->
            names.add(NaughtyOrNiceNameV2(name))
        }

        println(names.count())
        println(names.filter { it.isNice() }.count())
    }
}

fun main() {
    AOC2015_5B()
}