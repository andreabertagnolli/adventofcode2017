package ndr.brt

import org.junit.jupiter.api.Test
import java.nio.file.Files
import java.nio.file.Paths
import kotlin.test.assertEquals

class Day09Test {
    val day = Day09()

    @Test
    internal fun with_one_block_returns_one() {
        assertEquals(1, day.score("{}").score)
    }

    @Test
    internal fun nested_group_count_double() {
        assertEquals(3, day.score("{{}}").score)
    }

    @Test
    internal fun double_nested_group() {
        assertEquals(6, day.score("{{{}}}").score)
    }

    @Test
    internal fun two_nested() {
        assertEquals(5, day.score("{{},{}}").score)
    }

    @Test
    internal fun various_group() {
        assertEquals(16, day.score("{{{},{},{{}}}}").score)
    }

    @Test
    internal fun simple_garbage() {
        assertEquals(1, day.score("{<a>,<a>,<a>,<a>}").score)
    }

    @Test
    internal fun nested_garbage() {
        assertEquals(9, day.score("{{<ab>},{<ab>},{<ab>},{<ab>}}").score)
    }

    @Test
    internal fun nested_negate_garbage() {
        assertEquals(9, day.score("{{<!!>},{<!!>},{<!!>},{<!!>}}").score)
    }

    @Test
    internal fun negate_garbage_closing() {
        assertEquals(3, day.score("{{<a!>},{<a!>},{<a!>},{<ab>}}").score)
    }

    @Test
    internal fun part1_solution() {
        val lines = Files.readAllLines(Paths.get("resources/day09"))

        assertEquals(13154, day.score(lines.get(0)).score);
    }

    @Test
    internal fun garbage_size() {
        assertEquals(10, day.score("<{o\"i!a,<{i<a>").garbage)
    }

    @Test
    internal fun part2_solution() {
        val lines = Files.readAllLines(Paths.get("resources/day09"))

        assertEquals(6369, day.score(lines.get(0)).garbage);
    }
}