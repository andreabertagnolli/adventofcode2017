package ndr.brt

class Day07 {
    fun bottomProgram(input: List<String>): String {
        val programs = input.map { Program(it) }
        val aboves = programs.map { it.above }.flatMap { it }
        return programs.filter { !aboves.contains(it.name) }.first().name
    }

    fun expectedWeightToBalanceTower(input: List<String>): Int {

        val programs = input.map { Program(it) }

        val toBeBalanced = programs.filter { it.above.isNotEmpty() }.map {
            programs.filter { that -> it.above.contains(that.name) }.map { subProgram ->
                Sum(subProgram, subProgram.weight + programs.filter { that -> subProgram.above.contains(that.name) }.map { that -> that.weight }.sum())
            }
        }.filter { it.map { that -> that.sum }.toSet().size > 1 }.first()

        println(toBeBalanced)

        val balancedValue = toBeBalanced.map { it.sum }.groupBy { it }.entries.filter { it -> it.value.size>1 }.first().key

        val unbalanced = toBeBalanced.filter { it.sum != balancedValue }.first()
        println(toBeBalanced)


        // 251 + x = 243          68 + x
        return balancedValue - unbalanced.sum + unbalanced.program.weight
    }

    class Sum(val program:Program, val sum:Int) {
        override fun toString(): String {
            return "Sum(program=${program.name}:${program.weight}, sum=$sum)"
        }
    }

    class Program(info: String) {
        val name: String
        val weight: Int

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