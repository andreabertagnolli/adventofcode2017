package ndr.brt

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day01Part1Test {

    @Test
    fun single_digit_always_returns_0() {
        assertEquals(0, captchaPartOne("3"))
    }

    @Test
    fun two_equal_digits_returns_digit_multiply_two() {
        assertEquals(10, captchaPartOne("55"))
    }

    @Test
    fun with_all_equal_digits_returns_the_sum_of_the_digits() {
        assertEquals(4, captchaPartOne("1111"))
    }

    @Test
    fun with_no_matching_digits_returns_0() {
        assertEquals(0, captchaPartOne("1234"))
    }

    @Test
    fun works_with_different_couple_of_digits() {
        assertEquals(3, captchaPartOne("1122"))
    }

    @Test
    fun one_cool_case() {
        assertEquals(9, captchaPartOne("91212129"))
    }

}