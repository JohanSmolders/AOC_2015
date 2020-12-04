package be.krikkrok.fifteen.pojo

data class NaughtyOrNiceName(val name: String) {
    fun isNice(): Boolean {
        return nameContainsAtLeastThreeVowels() &&
                twoConsecutiveCharactersAreTheSame() && noNaughtyStrings()

    }

    private fun noNaughtyStrings() =
        !name.contains("ab") && !name.contains("cd") && !name.contains("pq") && !name.contains("xy")

    private fun twoConsecutiveCharactersAreTheSame() = name.windowed(2).filter { it[0] == it[1] }.count() > 0
    private fun nameContainsAtLeastThreeVowels() =
        name.chars().filter { listOf('a', 'e', 'i', 'o', 'u').contains(it.toChar()) }.count() >= 3
}
