package ndr.brt

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Advent01Test {

    @Test
    internal fun single_digit_always_returns_0() {
        assertEquals(0, captcha("3"))
    }

    @Test
    internal fun two_equal_digits_returns_digit_multiply_two() {
        assertEquals(15, captcha("555"))
    }

    @Test
    fun with_all_equal_digits_returns_the_sum_of_the_digits() {
        assertEquals(4, captcha("1111"))
    }

    @Test
    fun with_no_matching_digits_returns_0() {
        assertEquals(0, captcha("1234"))
    }

    @Test
    fun baubau() {
        assertEquals(3, captcha("1122"))
    }

    @Test
    fun baubaufds() {
        assertEquals(9, captcha("91212129"))
    }

}