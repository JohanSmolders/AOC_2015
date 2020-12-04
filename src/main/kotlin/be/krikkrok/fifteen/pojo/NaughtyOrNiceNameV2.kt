package be.krikkrok.fifteen.pojo

data class NaughtyOrNiceNameV2(val name: String) {
    fun isNice(): Boolean {
        return twoLettersSameWithOtherInBetween()
                && twoNonOverLappingAreTheSame()
    }

    private fun twoNonOverLappingAreTheSame(): Boolean {
        val parts = name.windowed(2).map { it }

        return parts.indices.filter { current ->

            parts.indices.filter { it != current && it != (current + 1) && it != (current - 1) }.filter {
                parts[current] == parts[it]
            }.count() > 0

        }.count() > 0
    }


    private fun twoLettersSameWithOtherInBetween() =
        name.windowed(3).filter { it[0] == it[2]  }.count() > 0

}