package be.krikkrok.fifteen.pojo

class LightCommand(val on: LightCommandType, val square: String){
    fun startX() = square.substring(0, square.indexOf(",")).toInt()
    fun startY() = square.substring(square.indexOf(",")+1, square.indexOf(" ")).toInt()
    fun endX() = square.substring(square.indexOf("h ")+2, square.lastIndexOf(",")).toInt()
    fun endY() = square.substring(square.lastIndexOf(",") + 1 ).toInt()
}

fun main() {
    println(LightCommand(LightCommandType.ON, "240,129 through 703,297").endY())
}