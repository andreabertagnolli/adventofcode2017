package ndr.brt

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class Day03Part1Test {

    val day = Day03()

    @Test
    internal fun square_1() {
        assertEquals(0, day.spiralMemory(1));
    }

    @Test
    internal fun square_2() {
        assertEquals(1, day.spiralMemory(2));
    }

    @Test
    internal fun square_9() {
        assertEquals(2, day.spiralMemory(9));
    }

    @Test
    internal fun square_11() {
        assertEquals(2, day.spiralMemory(11));
    }

    @Test
    internal fun square_12() {
        assertEquals(3, day.spiralMemory(12))
    }

    @Test
    internal fun square_23() {
        assertEquals(2, day.spiralMemory(23))
    }

    @Test
    internal fun square_1024() {
        assertEquals(31, day.spiralMemory(1024))
    }

    internal class CentralNumbers {

        @Test
        internal fun square_0() {
            assertTrue(intArrayOf(1, 1, 1, 1) contentEquals  SquarePart1(0).pivots())
        }

        @Test
        internal fun square_1() {
            assertTrue(intArrayOf(2, 4, 6, 8) contentEquals SquarePart1(1).pivots())
        }

        @Test
        internal fun square_2() {
            assertTrue(intArrayOf(11, 15, 19, 23) contentEquals SquarePart1(2).pivots())
        }

    }

    internal class FirstCentralNumber {
        @Test
        internal fun first_central_number_0() {
            assertEquals(1, SquarePart1(0).firstPivot)
        }

        @Test
        internal fun first_central_number_1() {
            assertEquals(2, SquarePart1(1).firstPivot)
        }

        @Test
        internal fun first_central_number_2() {
            assertEquals(11, SquarePart1(2).firstPivot)
        }

        @Test
        internal fun first_central_number_4() {
            assertEquals(53, SquarePart1(4).firstPivot)
        }
    }

    internal class SquareLength {
        @Test
        internal fun length_square_0() {
            assertEquals(1, SquarePart1(0).size)
        }

        @Test
        internal fun length_square_1() {
            assertEquals(3, SquarePart1(1).size)
        }

        @Test
        internal fun length_square_3() {
            assertEquals(7, SquarePart1(3).size)
        }

    }
}

