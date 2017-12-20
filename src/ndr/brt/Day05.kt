package ndr.brt

class Day05 {
    fun stepsToExitFrom(list: IntArray): Int {
        var index = 0
        var steps = 0

        while (index >= 0 && index < list.size) {
            //println(list.map { it.toString() }.joinToString(","))
            val stepTo = list[index]
            list.set(index, stepTo + 1)
            index += stepTo
            steps++
        }
        //println(list.map { it.toString() }.joinToString(","))

        return steps
    }

}