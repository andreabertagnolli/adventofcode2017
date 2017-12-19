package ndr.brt

class Day04 {
    fun noDuplicateWords(input: String): Boolean {
        return input.split(" ").distinct().count() == input.split(" ").count()
    }

    fun noDuplicateAnagrams(input: String): Boolean {
        return input.split(" ")
                .map { String(it.toCharArray().sortedArray()) }
                .distinct()
                .count() == input.split(" ").count()
    }

}