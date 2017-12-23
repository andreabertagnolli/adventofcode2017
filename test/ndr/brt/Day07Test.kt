package ndr.brt

import org.junit.jupiter.api.Test
import java.nio.file.Files.readAllLines
import java.nio.file.Paths
import kotlin.test.assertEquals

class Day07Test {

    val day = Day07()

    @Test
    internal fun part1() {
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

        assertEquals("tknk", day.bottomProgram(input.split("\n")))
    }

    @Test
    internal fun part1_solution() {
        val lines = readAllLines(Paths.get("resources/day07"))
        assertEquals("aaa", day.bottomProgram(lines))
    }
}