package ndr.brt

import org.junit.jupiter.api.Test
import java.nio.file.Files
import java.nio.file.Paths
import kotlin.test.assertEquals

class Day05Test {

    val day = Day05()

    @Test
    internal fun exit_from_list_part1() {
        assertEquals(5, day.stepsToExitFrom(intArrayOf(0, 3, 0, 1, -3)));
    }

    @Test
    internal fun exit_from_list_part2() {
        assertEquals(10, day.stepsToExitPart2(intArrayOf(0, 3, 0, 1, -3)));
    }

    @Test
    internal fun valid_passphrases_part1() {
        val validPassphrases = Files.readAllLines(Paths.get("resources/day05")).map{ it.toInt() }

        println(day.stepsToExitFrom(validPassphrases.toIntArray()))
    }

    @Test
    internal fun valid_passphrases_part2() {
        val validPassphrases = Files.readAllLines(Paths.get("resources/day05")).map{ it.toInt() }

        println(day.stepsToExitPart2(validPassphrases.toIntArray()))
    }
}