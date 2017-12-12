package ndr.brt

fun captcha (input: String): Int =
    when {
        input.length == 1 -> 0

        else -> input.plus(input.get(0))
                    .map { it -> it.toString().toInt() }
                    .map { it -> Step(0, it) }
                    .reduce({
                        a, b -> when { a.value == b.value -> { Step(a.sum + b.value, b.value) } else -> Step(a.sum, b.value) }
                    }).sum
    }

class Step(val sum: Int, val value: Int)
