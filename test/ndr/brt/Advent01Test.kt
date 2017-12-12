package ndr.brt

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Advent01Test {

    @Test
    fun single_digit_always_returns_0() {
        assertEquals(0, captcha("3"))
    }

    @Test
    fun two_equal_digits_returns_digit_multiply_two() {
        assertEquals(10, captcha("55"))
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
    fun works_with_different_couple_of_digits() {
        assertEquals(3, captcha("1122"))
    }

    @Test
    fun one_cool_case() {
        assertEquals(9, captcha("91212129"))
    }

}