package ndr.brt

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day03Part2Test {
    val day = Day03()

    @Test
    internal fun first_value_larger_than_1_is_2() {
        assertEquals(2, day.firstValueLargerThan(1))
    }

    @Test
    internal fun first_value_larger_than_3_is_4() {
        assertEquals(4, day.firstValueLargerThan(3))
    }

    @Test
    internal fun first_value_larger_than_7_is_10() {
        assertEquals(10, day.firstValueLargerThan(7))
    }

    @Test
    internal fun first_value_larger_than_28_is_54() {
        assertEquals(54, day.firstValueLargerThan(28))
    }

    @Test
    internal fun first_value_larger_than_265149_is_() {
        assertEquals(266330, day.firstValueLargerThan(265149))
    }
}