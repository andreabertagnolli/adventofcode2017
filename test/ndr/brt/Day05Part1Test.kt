package ndr.brt

import org.junit.jupiter.api.Test
import java.nio.file.Files
import java.nio.file.Paths
import kotlin.test.assertEquals

class Day05Part1Test {

    val day = Day05()

    @Test
    internal fun exit_from_list() {
        assertEquals(5, day.stepsToExitFrom(intArrayOf(0, 3, 0, 1, -3)));
    }

    @Test
    internal fun valid_passphrases() {
        val validPassphrases = Files.readAllLines(Paths.get("resources/day05")).map{ it.toInt() }

        println(day.stepsToExitFrom(validPassphrases.toIntArray()))
    }
}