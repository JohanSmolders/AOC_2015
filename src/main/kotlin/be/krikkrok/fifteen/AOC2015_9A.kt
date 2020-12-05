package be.krikkrok.fifteen

import be.krikkrok.BaseAoc
import be.krikkrok.fifteen.pojo.CircuitCommand
import be.krikkrok.fifteen.pojo.CircuitOperation
import be.krikkrok.fifteen.pojo.FlightDistance
import be.krikkrok.fifteen.util.StringPermutator
import kotlin.collections.HashMap


class AOC2015_9B : BaseAoc() {

    val alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

    init {

        val mappedCities: HashMap<String, String> = HashMap()
        val distances = ArrayList<FlightDistance>()
        asReader("/2015/AOC2015_9A.txt").forEachLine { line ->
            val from = line.substring(0, line.indexOf(" to"))
            val to = line.substring(line.indexOf("to ") + 3, line.indexOf(" ="))
            val distance = line.substring(line.indexOf("= ") + 2).toInt()
            distances.add(FlightDistance(from, to, distance))
        }

        val from = distances.map { it.from }.distinct()
        val to = distances.map { it.to }.distinct()

        val distinctCities = from.union(to).distinct()

        (distinctCities.indices).forEach { index ->
            mappedCities[alphabet[index].toString()] = distinctCities[index]
        }


        var lowestDistance  = 9999999;
        StringPermutator().permute(alphabet.substring(0, distinctCities.size), 0, distinctCities.size - 1) { item ->
            val totalDistance = item.windowed(2).sumBy { fromTo ->
                val from = mappedCities[fromTo[0].toString()]
                val to = mappedCities[fromTo[1].toString()]
                distances.first { (it.from == from && it.to == to) || (it.from == to && it.to == from) }.distance
            }
            if(totalDistance < lowestDistance){
                lowestDistance = totalDistance
            }
        }

        println(lowestDistance)
    }
}

fun main() {
    AOC2015_9B()
}