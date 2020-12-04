package be.krikkrok.fifteen

import be.krikkrok.BaseAoc
import java.security.MessageDigest
import kotlin.system.exitProcess
import kotlin.text.Charsets.UTF_8

class AOC2015_4B: BaseAoc() {
    init {
        val input = "bgvyzdsv"

        (0..10000000).forEach {
            val currentCoin = "$input$it"
            if(md5(currentCoin).toHex().startsWith("000000")){
                println(md5(currentCoin).toHex())
                println(it)
                exitProcess(0)
            }
        }


    }

    fun md5(str: String): ByteArray = MessageDigest.getInstance("MD5").digest(str.toByteArray(UTF_8))
    fun ByteArray.toHex() = joinToString("") { "%02x".format(it) }
}

fun main() {
    AOC2015_4B()
}