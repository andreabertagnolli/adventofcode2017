package ndr.brt

import org.junit.jupiter.api.Test
import java.nio.file.Files.readAllLines
import java.nio.file.Paths
import kotlin.test.assertEquals

class Day07Test {

    val day = Day07()

    private val testInput: String
        get() {
            val input = "pbga (66)\n" +
                    "xhth (57)\n" +
                    "ebii (61)\n" +
                    "havc (66)\n" +
                    "ktlj (57)\n" +
                    "fwft (72) -> ktlj, cntj, xhth\n" +
                    "qoyq (66)\n" +
                    "padx (45) -> pbga, havc, qoyq\n" +
                    "tknk (41) -> ugml, padx, fwft\n" +
                    "jptl (61)\n" +
                    "ugml (68) -> gyxo, ebii, jptl\n" +
                    "gyxo (61)\n" +
                    "cntj (57)"
            return input
        }

    @Test
    internal fun part1() {
        assertEquals("tknk", day.bottomProgram(testInput.split("\n")))
    }

    @Test
    internal fun part1_solution() {
        val lines = readAllLines(Paths.get("resources/day07"))
        assertEquals("vvsvez", day.bottomProgram(lines))
    }

    @Test
    internal fun part2() {
        assertEquals(60, day.expectedWeightToBalanceTower(testInput.split("\n")))
    }

    @Test
    internal fun solution_part2() {
        val lines = readAllLines(Paths.get("resources/day07"))
        assertEquals(60, day.expectedWeightToBalanceTower(lines))
    }
}