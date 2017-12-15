package ndr.brt

fun corruptionChecksum(input: String): Int {
    return input.split("\n")
            .map({ it.split("\t", " ")
                    .map { it.toInt() }
                    .map { MaxMin(it, it) }
                    .reduce { a, b -> MaxMin(minOf(a.min, b.min), maxOf(a.max, b.max)) }
                    .difference()
            })
            .sum()
}


class MaxMin(val min: Int, val max: Int) {

    fun difference(): Int = max - min

}