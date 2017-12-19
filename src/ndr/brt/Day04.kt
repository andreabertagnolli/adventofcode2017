package ndr.brt

class Day04 {
    fun noDuplicateWords(input: String): Boolean {
        return input.split(" ").distinct().count() == input.split(" ").count()
    }

}