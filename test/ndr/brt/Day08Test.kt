package ndr.brt

import org.junit.jupiter.api.Test
import java.nio.file.Files
import java.nio.file.Paths
import kotlin.test.assertEquals

class Day08Test {
    val day = Day08()

    @Test
    internal fun part1() {
        val input = "b inc 5 if a > 1\n" +
                "a inc 1 if b < 5\n" +
                "c dec -10 if a >= 1\n" +
                "c inc -20 if c == 10"

        assertEquals(1, day.largestValue(input.split("\n")));
    }

    @Test
    internal fun part1_solution() {
        val lines = Files.readAllLines(Paths.get("resources/day08"))

        assertEquals(5215, day.largestValue(lines));
    }

    @Test
    internal fun part2() {
        val input = "b inc 5 if a > 1\n" +
                "a inc 1 if b < 5\n" +
                "c dec -10 if a >= 1\n" +
                "c inc -20 if c == 10"

        assertEquals(10, day.largestValueEver(input.split("\n")));
    }

    @Test
    internal fun part2_solution() {
        val lines = Files.readAllLines(Paths.get("resources/day08"))

        assertEquals(6419, day.largestValueEver(lines));
    }
}