package ndr.brt

import org.junit.jupiter.api.Test
import java.nio.file.Files
import java.nio.file.Paths
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class Day04Part1Test {

    val day = Day04()

    @Test
    internal fun valid_passphrase() {
        assertTrue(day.noDuplicateWords("aa bb cc dd ee"))
    }

    @Test
    internal fun with_duplicate_passphrase_is_not_valid() {
        assertFalse(day.noDuplicateWords("aa bb cc dd aa"));
    }

    @Test
    internal fun another_valid_passphrase() {
        assertTrue(day.noDuplicateWords("aa bb cc dd aaa"));
    }

    @Test
    internal fun how_many_valid() {
        val validPassphrases = Files.readAllLines(Paths.get("resources/day04part1")).filter { it -> day.noDuplicateWords(it) }.count()

        println(validPassphrases)
    }

}