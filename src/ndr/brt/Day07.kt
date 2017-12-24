package ndr.brt

class Day07 {
    fun bottomProgram(input: List<String>): Program {
        val programs = input.map { Program(it) }
        val aboves = programs.map { it.above }.flatMap { it }
        return programs.filter { !aboves.contains(it.name) }.first()
    }

    fun expectedWeightToBalanceTower(input: List<String>): Int {
        val programs = input.map { Program(it) }

        programs.forEach { it.childs(programs.filter { that -> it.above.contains(that.name) }) }

        val toBeBalanced = programs.find { it.childs.map { that -> that.sum() }.toSet().size > 1 }!!

        val balancedValue = toBeBalanced.childs.map { it.sum() }.groupBy { it }
                .entries.filter { it -> it.value.size > 1 }
                .first().key

        val unbalanced = toBeBalanced.childs
                .filter { it.sum() != balancedValue }.first()

        return balancedValue - unbalanced.sum() + unbalanced.weight
    }

    class Program(info: String) {
        val name: String
        val weight: Int
        var childs: MutableSet<Program> = mutableSetOf()
        val above: List<String>

        override fun toString(): String {
            return "Program(name='$name', weight=$weight, childs=$childs)"
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

        fun childs(childs: List<Program>) {
            this.childs.addAll(childs)
        }

        fun sum(): Int {
            return weight + childs.map { it.sum() }.sum()
        }

    }

}