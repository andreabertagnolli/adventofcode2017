package ndr.brt

class Day09 {
    fun score(input: String): Int {
        val closedGroups = mutableListOf<Int>()

        var level = 0
        var garbage = false
        var previous = 'x'

        input.forEach { it ->
            if (previous != '!') {
                when (it) {
                    '{' -> if (!garbage) level++
                    '}' -> if (!garbage) closedGroups.add(level--)
                    '<' -> garbage = true
                    '>' -> garbage = false
                    else -> null
                }
                previous = it
            }
            else {
                previous = 'x'
            }
        }

        return closedGroups.sum()
    }

}