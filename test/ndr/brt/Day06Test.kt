package ndr.brt

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day06Test {
    val day = Day06()

    @Test
    internal fun part1() {
        assertEquals(5, day.stepsBeforeInfiniteLoop(intArrayOf(0, 2, 7, 0)))
    }

    @Test
    internal fun part1_solution() {
        assertEquals(6681, day.stepsBeforeInfiniteLoop(intArrayOf(4,1,15,12,0,9,9,5,5,8,7,3,14,5,12,3)))
    }

    @Test
    internal fun part2() {
        assertEquals(4, day.cyclesInInfiniteLoop(intArrayOf(0, 2, 7, 0)))
    }

    @Test
    internal fun part2_solution() {
        assertEquals(4, day.cyclesInInfiniteLoop(intArrayOf(4,1,15,12,0,9,9,5,5,8,7,3,14,5,12,3)))
    }
}