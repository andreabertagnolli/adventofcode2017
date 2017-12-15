package ndr.brt

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day02Part1Test {

    @Test
    internal fun first_row_checksum() {
        assertEquals(8, corruptionChecksum("5 1 9 5"));
    }

    @Test
    internal fun second_row_checksum() {
        assertEquals(4, corruptionChecksum("7 5 3"));
    }

    @Test
    internal fun third_row_checksum() {
        assertEquals(6, corruptionChecksum("2 4 6 8"));
    }

    @Test
    internal fun first_case() {
        val checksum = corruptionChecksum("5\t1\t9\t5\n" +
                "7\t5\t3\n" +
                "2\t4\t6\t8")

        assertEquals(18, checksum);
    }

}