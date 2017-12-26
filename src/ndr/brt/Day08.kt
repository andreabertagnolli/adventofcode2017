package ndr.brt

class Day08 {
    fun largestValue(instructions: List<String>): Int {
        val register = Register()

        instructions.map { Instruction(it) }
                .map { register.apply(it) }

        return register.max()
    }

    class Register {
        private val register = mutableMapOf<String, Int>()

        fun apply(instruction: Instruction) {
            if (test(instruction.condition)) {
                val actual = register.getOrDefault(instruction.variable, 0)

                val next = when (instruction.operation) {
                    "inc" -> actual + instruction.quantity
                    "dec" -> actual - instruction.quantity
                    else -> throw RuntimeException()
                }

                register.put(instruction.variable, next)
            }
        }

        fun max(): Int {
            return register.maxBy { it.value }!!.value
        }

        fun test(condition: Condition): Boolean {
            return condition.test(register.getOrDefault(condition.variable, 0))
        }

        override fun toString(): String {
            return register.map { e -> "%s -> %s".format(e.key, e.value) }.joinToString { it }
        }
    }

    class Instruction(definition: String) {
        val variable: String
        val operation: String
        val quantity: Int
        val condition: Condition

        init {
            val parts = definition.split(" ")
            this.variable = parts[0]
            this.operation = parts[1]
            this.quantity = parts[2].toInt()
            this.condition = Condition(parts[4], parts[5], parts[6].toInt())
        }

        override fun toString(): String {
            return "%s %s %s".format(variable, operation, quantity)
        }
    }

    class Condition(val variable: String, val operator: String, val quantity: Int) {
        fun test(value: Int): Boolean = when(operator) {
                ">" -> value > quantity
                ">=" -> value >= quantity
                "<" -> value < quantity
                "<=" -> value <= quantity
                "==" -> value == quantity
                "!=" -> value != quantity
                else -> throw RuntimeException()
        }

        override fun toString(): String {
            return "Is %s %s %s?".format(variable, operator, quantity)
        }
    }

}