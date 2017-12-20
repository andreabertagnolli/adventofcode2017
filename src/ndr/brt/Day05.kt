package ndr.brt

class Day05 {
    fun stepsToExitFrom(list: IntArray): Int {
        var index = 0
        var steps = 0

        while (index >= 0 && index < list.size) {
            val stepTo = list[index]
            list.set(index, stepTo + 1)
            index += stepTo
            steps++
        }

        return steps
    }

    fun stepsToExitPart2(list: IntArray): Int {
        var index = 0
        var steps = 0

        while (index >= 0 && index < list.size) {
            val stepTo = list[index]
            var futureValue = when {
                stepTo >= 3 -> stepTo -1
                else -> stepTo +1
            }

            list.set(index, futureValue)
            index += stepTo
            steps++
        }

        return steps
    }

}