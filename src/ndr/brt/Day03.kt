package ndr.brt

import kotlin.math.abs
import kotlin.math.ceil
import kotlin.math.min
import kotlin.math.sqrt

class Day03 {

    fun spiralMemory(input: Int): Int {

        val square = SquarePart1(input)
        return square.pivots()
                .map { input - it }
                .map { abs(it) }
                .reduce { a, b -> min(a,b) } + square.distanceFromCenter

    }

    fun firstValueLargerThan(input: Int): Int {

        val grid = Grid()

        (0..150).forEach{ grid.addSquare() }

        return grid.squares
                .map { it.value }
                .filter { it > input }
                .reduce { a, b -> min(a,b) }
    }

}

class Grid {

    val squares: MutableList<Square> = mutableListOf()

    fun addSquare() {
        when {
            squares.isEmpty() -> squares.add(Square(Point(0,0),1, Direction.RIGHT))

            canGoTo(squares.last().desiredDirection) -> goTo(squares.last().desiredDirection)

            else -> goTo(squares.last().desiredDirection.previous())
        }

    }

    private fun canGoTo(desiredDirection: Direction): Boolean {

        val actual = squares.last().coordinate
        val nextCoordinate = when (desiredDirection) {
            Direction.UP -> actual.goUp()
            Direction.LEFT -> actual.goLeft()
            Direction.DOWN -> actual.goDown()
            Direction.RIGHT -> actual.goRight()
        }

        return squares.map { it.coordinate }
                .contains(nextCoordinate).not()
    }

    private fun goTo(direction: Direction) {

        val last = squares.last()
        when(direction) {
            Direction.UP -> add(last.coordinate.goUp(), direction.next())
            Direction.LEFT -> add(last.coordinate.goLeft(), direction.next())
            Direction.DOWN -> add(last.coordinate.goDown(), direction.next())
            Direction.RIGHT -> add(last.coordinate.goRight(), direction.next())
        }

    }

    private fun add(coordinate: Point, direction: Direction) {
        squares.add(Square(coordinate, valueIn(coordinate), direction))
    }

    private fun valueIn(coordinate: Point) = squares
            .filter { it.coordinate.x >= coordinate.x-1 && it.coordinate.x <= coordinate.x+1 }
            .filter { it.coordinate.y >= coordinate.y-1 && it.coordinate.y <= coordinate.y+1 }
            .map { it.value }
            .sum()

}

class Point(val x: Int, val y: Int) {
    fun goLeft(): Point = Point(x-1, y)
    fun goRight(): Point = Point(x+1, y)
    fun goUp(): Point = Point(x, y+1)
    fun goDown(): Point = Point(x, y-1)

    override fun toString(): String {
        return "(%s, %s)".format(x, y)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Point

        if (x != other.x) return false
        if (y != other.y) return false

        return true
    }

    override fun hashCode(): Int {
        var result = x
        result = 31 * result + y
        return result
    }

}

class Square(val coordinate: Point, val value: Int, val desiredDirection: Direction) {

    override fun toString(): String {
        return "%s -> %s (desired direction: %s)".format(coordinate, value, desiredDirection)
    }

}

enum class Direction {
    UP, DOWN, LEFT, RIGHT;

    fun next() = when (this) {
        UP -> LEFT
        LEFT -> DOWN
        DOWN -> RIGHT
        RIGHT -> UP
    }

    fun previous() = when (this) {
        UP -> RIGHT
        LEFT -> UP
        DOWN -> LEFT
        RIGHT -> DOWN
    }
}

class SquarePart1(input: Int) {

    val distanceFromCenter: Int = ((squareLength(input) + 1) / 2) - 1
    val size: Int = (distanceFromCenter + 1) * 2 - 1
    val firstPivot: Int = (size - 2)*(size - 2) + distanceFromCenter

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