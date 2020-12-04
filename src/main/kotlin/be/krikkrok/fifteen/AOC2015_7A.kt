package be.krikkrok.fifteen

import be.krikkrok.BaseAoc
import be.krikkrok.fifteen.pojo.CircuitCommand
import be.krikkrok.fifteen.pojo.CircuitOperation
import kotlin.collections.HashMap


class AOC2015_7A : BaseAoc() {
    val wires = HashMap<String, Int>()

    var listCommand = ArrayList<CircuitCommand>()
    init {
        asReader("/2015/AOC2015_7A.txt").forEachLine { command ->
            listCommand.add(CircuitCommand(command))
        }

        while (listCommand.size > 0){
            val availableCommands = listCommand.filter { (it.first == null || wires.containsKey(it.first)) && (it.second == null || wires.containsKey(it.second)) }
            listCommand = listCommand.minus(availableCommands.toTypedArray()) as ArrayList<CircuitCommand>

            println("Executing ${availableCommands.size}")
            println("Left ${listCommand.size}")
            availableCommands.forEach { circuitCommand ->
                when(circuitCommand.operation){
                    CircuitOperation.ASSIGN -> wires[circuitCommand.wire] = circuitCommand.value!!
                    CircuitOperation.ASSIGNWIRE -> wires[circuitCommand.wire] = wires[circuitCommand.first]!!
                    CircuitOperation.OR -> wires[circuitCommand.wire] = wires[circuitCommand.first]!! or wires[circuitCommand.second]!!
                    CircuitOperation.AND -> wires[circuitCommand.wire] = wires[circuitCommand.first]!! and wires[circuitCommand.second]!!
                    CircuitOperation.ANDVALUE -> wires[circuitCommand.wire] = wires[circuitCommand.first]!! and circuitCommand.value!!
                    CircuitOperation.ORVALUE -> wires[circuitCommand.wire] = wires[circuitCommand.first]!! or circuitCommand.value!!
                    CircuitOperation.RSHIFT -> wires[circuitCommand.wire] = wires[circuitCommand.first]!! shr circuitCommand.value!!
                    CircuitOperation.LSHIFT -> wires[circuitCommand.wire] = wires[circuitCommand.first]!! shl circuitCommand.value!!
                    CircuitOperation.NOT -> wires[circuitCommand.wire] = 65535 - wires[circuitCommand.first]!!
                }
            }
        }


        println("A ${wires["a"]}")


    }
}

fun main() {
    AOC2015_7A()
}