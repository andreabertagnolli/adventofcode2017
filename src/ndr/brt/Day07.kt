package ndr.brt

class Day07 {
    fun bottomProgram(input: List<String>): String {
        val programs = input.map { Program(it) }
        val aboves = programs.map { it.above }.flatMap { it }
        return programs.filter { !aboves.contains(it.name) }.first().name
    }

    class Program(info: String) {
        val name: String
        private val weight: Int
        val above: List<String>

        override fun toString(): String {
            return "Program(name='$name', weight=$weight, above=$above)"
        }

        init {
            val tokens = info.split(" ")
            this.name = tokens[0]
            this.weight = tokens[1].substring(1, tokens[1].length-1).toInt()
            if (info.contains("->")) {
                this.above = info.substring(info.indexOf("->") + 3).split(", ")
            }
            else {
                this.above = listOf()
            }
        }


    }

}