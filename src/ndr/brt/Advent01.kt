package ndr.brt

fun captchaPartOne(input: String): Int = when {
    input.length == 1 -> 0

    else -> input.plus(input[0])
                .map { it -> it.toString().toInt() }
                .map { Step(it) }
                .reduce({
                    a, b -> when {
                        a.value == b.value -> a.increase(b) else -> a.ignore(b)
                    }
                }).sum
}

fun captchaPartTwo(input: String): Int {
    val halfWay = input.length / 2

    return input.filterIndexed({ i, it -> it == input.get((i + halfWay) % input.length) })
            .map { it.toString() }
            .map { it.toInt() }
            .sum()
}

class Step(val sum: Int, val value: Int) {
    constructor(value: Int) : this(0, value)

    fun ignore(that: Step): Step {
        return Step(this.sum, that.value)
    }

    fun increase(that: Step): Step {
        return Step(this.sum + that.value, that.value)
    }
}
