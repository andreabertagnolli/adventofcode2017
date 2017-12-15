package ndr.brt

fun corruptionChecksum(input: String): Int = input.split("\n")
            .map({ it.split("\t", " ")
                    .map { it.toInt() }
                    .map { MaxMin(it, it) }
                    .reduce { a, b -> MaxMin(minOf(a.min, b.min), maxOf(a.max, b.max)) }
                    .difference()
            })
            .sum()

fun evenlyDivisibleChecksum(input: String): Int = input.split("\n")
            .map { row -> row.split(" ", "\t").map { it.toInt() } }
            .map({ rowNumbers ->
                rowNumbers.filter { high -> rowNumbers
                        .filter { it != high }
                        .filter { low -> high % low == 0 }
                        .isNotEmpty()
                }.first().div(
                        rowNumbers.filter { low -> rowNumbers
                                .filter { it != low }
                                .filter { high -> high % low == 0 }
                                .isNotEmpty()
                        }.first())
            })
            .sum()

class MaxMin(val min: Int, val max: Int) {
    fun difference(): Int = max - min
}