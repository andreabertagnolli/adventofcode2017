package ndr.brt

import kotlin.math.abs
import kotlin.math.ceil
import kotlin.math.min
import kotlin.math.sqrt

class Day03 {
    fun spiralMemory(input: Int): Int {

        //1° quadrato = 1^2, 2 quadrato = 3^2, 3° quadrato = 5^2
        val distanceFromCenter = distanceFromCenter(input)

        return Square(distanceFromCenter).centralNumbers()
                .map { input - it }
                .map { abs(it) }
                .reduce { a, b -> min(a,b) } + distanceFromCenter

    }

    fun squareLength(input: Int): Int {
        val ceil = ceil(sqrt(input.toDouble())).toInt()
        return when {
            ceil % 2 == 0 -> ceil + 1
            else -> ceil
        }
    }


    fun distanceFromCenter(input: Int): Int {
        return ((squareLength(input) + 1) / 2) -1
    }

}

class Square(val distanceFromCenter: Int) {

    fun length(): Int = (distanceFromCenter + 1)*2 - 1

    fun firstCentralNumber(): Int {
        return (length() - 2)*(length() - 2) + distanceFromCenter
    }

    fun centralNumbers(): IntArray {

        return intArrayOf(firstCentralNumber(), firstCentralNumber() + (length() -1)*1, firstCentralNumber() + (length()-1)*2, firstCentralNumber() + (length()-1)*3)
    }

}