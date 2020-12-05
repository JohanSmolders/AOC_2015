package be.krikkrok.fifteen.util

class StringPermutator {
    fun permute(str: String?, l: Int, r: Int, listener: ((mutation: String)->Unit)) {
        var str = str
        if (l == r) listener.invoke(str!!) else {
            for (i in l..r) {
                str = swap(str!!, l, i)
                permute(str, l + 1, r, listener)
                str = swap(str!!, l, i)
            }
        }
    }

    private fun swap(a: String, i: Int, j: Int): String? {
        val temp: Char
        val charArray = a.toCharArray()
        temp = charArray[i]
        charArray[i] = charArray[j]
        charArray[j] = temp
        return String(charArray)
    }
}