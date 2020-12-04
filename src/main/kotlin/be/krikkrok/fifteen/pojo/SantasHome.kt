package be.krikkrok.fifteen.pojo

data class SantasHome(val x: Int, val y: Int, var presents: Int = 1) {

    fun addPresent(){
        presents++
    }

    fun isHome(x: Int, y: Int) = (this.x == x && this.y == y)
}