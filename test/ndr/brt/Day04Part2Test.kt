package ndr.brt

import org.junit.jupiter.api.Test
import java.nio.file.Files
import java.nio.file.Paths
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class Day04Part2Test {
    val day = Day04()

    @Test
    internal fun valid_passphrase() {
        assertTrue(day.noDuplicateAnagrams("abcde fghij"))
    }

    @Test
    internal fun not_valid_passphrase() {
        assertFalse(day.noDuplicateAnagrams("abcde xyz ecdab"))
    }

    @Test
    internal fun other_valid_passphrases() {
        assertTrue(day.noDuplicateAnagrams("a ab abc abd abf abj"))
        assertTrue(day.noDuplicateAnagrams("iiii oiii ooii oooi oooo"))
    }

    @Test
    internal fun another_invalid_passphrase() {
        assertFalse(day.noDuplicateAnagrams("oiii ioii iioi iiio"))
    }

    @Test
    internal fun valid_passphrases() {
        val validPassphrases = Files.readAllLines(Paths.get("resources/day04")).filter { it -> day.noDuplicateAnagrams(it) }.count()

        println(validPassphrases)
    }
}