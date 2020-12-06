package be.krikkrok.fifteen.pojo

data class SantaPassword(var password: String) {
    val alphabet = "abcdefghijklmnopqrstuvwxyz"

    fun nextValidPassword(): String {
        do {
            val chars = password.toCharArray()
            charsIncrease(chars, 7)
            password = chars.concatToString()
        } while (!isPasswordValid())
        return password
    }

    private fun charsIncrease(chars: CharArray, i: Int) {
        chars[i] = chars[i] + 1
        if (chars[i].toInt() >= 97 + 26) {
            chars[i] = 'a'
            charsIncrease(chars, i - 1)
        }
    }

    fun isPasswordValid(): Boolean {
        return isCorrectLength() && doesntContainInvalidCharacters() && containsThreeConsecutive() && twoNonOverLappingPairs()
    }

    private fun twoNonOverLappingPairs(): Boolean {
        val indexesWithPairs =
            password.windowed(2).mapIndexed { index: Int, s: String -> if (s[0] == s[1]) index else null }
                .filterNotNull()
        val nextList = indexesWithPairs.toMutableList()
        indexesWithPairs.forEach {
            if (nextList.contains(it) && nextList.contains(it + 1)) {
                nextList.remove(it)
            }
        }

        return nextList.size >= 2

    }

    private fun containsThreeConsecutive(): Boolean =
        alphabet.windowed(3).firstOrNull { password.contains(it) } != null


    private fun isCorrectLength() = password.length == 8

    private fun doesntContainInvalidCharacters() =
        password.toCharArray().toList().minus(arrayOf('i', 'o', 'l')).size == 8
}