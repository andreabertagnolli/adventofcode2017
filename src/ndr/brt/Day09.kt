package ndr.brt

class Day09 {
    fun score(input: String): Output {
        val closedGroups = mutableListOf<Int>()

        var level = 0
        var garbage = false
        var previous = 'x'
        var garbageSize = 0

        input.forEach { it ->
            if (previous != '!') {
                if (garbage && it != '>' && it != '!') garbageSize++
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

        return Output(closedGroups.sum(), garbageSize)
    }

    class Output(val score:Int, val garbage: Int)

}