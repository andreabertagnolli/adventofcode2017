package ndr.brt

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day02Part2Test {

    @Test
    internal fun first_row_checksum() {
        assertEquals(4, evenlyDivisibleChecksum("5 9 2 8"));
    }

    @Test
    internal fun second_row_checksum() {
        assertEquals(3, evenlyDivisibleChecksum("9 4 7 3"));
    }

    @Test
    internal fun third_row_checksum() {
        assertEquals(2, evenlyDivisibleChecksum("3 8 6 5"));
    }

    @Test
    internal fun first_case() {
        val checksum = evenlyDivisibleChecksum("5\t9\t2\t8\n" +
                "9\t4\t7\t3\n" +
                "3\t8\t6\t5")

        assertEquals(9, checksum);
    }

}