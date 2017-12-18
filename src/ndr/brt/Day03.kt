package ndr.brt

import kotlin.math.abs
import kotlin.math.ceil
import kotlin.math.min
import kotlin.math.sqrt

class Day03 {

    fun spiralMemory(input: Int): Int {

        val square = Square(input)
        return square.pivots()
                .map { input - it }
                .map { abs(it) }
                .reduce { a, b -> min(a,b) } + square.distanceFromCenter

    }
    
}

class Square(input: Int) {

    val distanceFromCenter: Int = ((squareLength(input) + 1) / 2) - 1
    private val size: Int = (distanceFromCenter + 1) * 2 - 1
    private val firstPivot: Int = (size - 2)*(size - 2) + distanceFromCenter

    fun pivots(): IntArray {
        return (0..3).map { firstPivot + (size - 1) * it }.toIntArray()
    }

    private fun squareLength(input: Int): Int {
        val ceil = ceil(sqrt(input.toDouble())).toInt()
        return when {
            ceil % 2 == 0 -> ceil + 1
            else -> ceil
        }
    }

}