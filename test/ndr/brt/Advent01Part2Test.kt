package ndr.brt

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Advent01Part2Test {

    @Test
    fun first_case() {
        assertEquals(6, captchaPartTwo("1212"))
    }

    @Test
    fun second_case() {
        assertEquals(0, captchaPartTwo("1221"))
    }

    @Test
    fun third_case() {
        assertEquals(4, captchaPartTwo("123425"))
    }

    @Test
    fun forth_case() {
        assertEquals(12, captchaPartTwo("123123"))
    }

    @Test
    fun fifth_case() {
        assertEquals(4, captchaPartTwo("12131415"))
    }

}