package be.krikkrok.fifteen

import be.krikkrok.BaseAoc
import be.krikkrok.fifteen.pojo.LightCommand
import be.krikkrok.fifteen.pojo.LightCommandType

class AOC2015_6A : BaseAoc() {
    init {
        var lights = Array(1000) { IntArray(1000) { 0 } }

        asReader("/2015/AOC2015_6A.txt").forEachLine { name ->
            println("Executing $name")
            toCommand(name).let { lightCommand ->
                (lightCommand.startX() .. lightCommand.endX()).forEach { x ->
                    (lightCommand.startY() .. lightCommand.endY()).forEach { y ->

                        when (lightCommand.on) {
                            LightCommandType.ON -> lights[x][y] = 1
                            LightCommandType.OFF -> lights[x][y] = 0
                            LightCommandType.TOGGLE -> lights[x][y] = if (lights[x][y] == 0) 1 else 0
                        }
                    }
                }
            }
        }

        lights.forEach { array ->
            array.forEach {
                if (it == 1) {
                    print("#")
                } else {
                    print(".")
                }

            }
            println()

        }

        println(lights.sumOf { row -> row.filter { it == 1 }.count() })
    }

    private fun toCommand(line: String): LightCommand {
        return when {
            line.startsWith("turn off ") -> {
                LightCommand(LightCommandType.OFF, line.replace("turn off ", ""))
            }
            line.startsWith("turn on ") -> {
                LightCommand(LightCommandType.ON, line.replace("turn on ", ""))
            }
            line.startsWith("toggle ") -> {
                LightCommand(LightCommandType.TOGGLE, line.replace("toggle ", ""))
            }
            else -> throw RuntimeException("Couldn't find command for $line")
        }
    }
}

fun main() {
    AOC2015_6A()
}