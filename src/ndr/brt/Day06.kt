package ndr.brt

class Day06 {
    fun stepsBeforeInfiniteLoop(input: IntArray): Any {

        val knownSituations: MutableSet<Memory> = mutableSetOf(
                Memory(input.mapIndexed { index, it -> Block(index, it) })
        )

        var duplicated = false
        var steps = 0

        while (!duplicated) {

            duplicated = !knownSituations.add(
                knownSituations.last().reallocate()
            )
            steps++

        }

        return steps
    }

    fun cyclesInInfiniteLoop(input: IntArray): Int {
        val knownSituations: MutableSet<Memory> = mutableSetOf(
                Memory(input.mapIndexed { index, it -> Block(index, it) })
        )

        while (true) {
            val newSituation = knownSituations.last().reallocate()
            if (!knownSituations.add(newSituation)) {
                return knownSituations.size - knownSituations.indexOf(newSituation)
            }
        }

    }

    class Block(val index: Int, var value: Int) {

        fun clone() = Block(index, value)

        fun increase() = Block(index, value + 1)

        override fun toString(): String = value.toString()

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as Block

            if (index != other.index) return false
            if (value != other.value) return false

            return true
        }

        override fun hashCode(): Int {
            var result = index
            result = 31 * result + value
            return result
        }

    }
    class Memory(var blocks: List<Block>) {

        fun clone(): Memory {
            return Memory(blocks.map { it.clone() })
        }

        override fun toString(): String {
            return blocks.joinToString(",", "[", "]")
        }
        fun maxValue(): Int = blocks.maxBy { it.value }!!.value

        fun maxIndex(): Int = blocks.maxBy { it.value }!!.index

        fun setMemory(index: Int, value: Int) {
            blocks.get(index).value = value
        }

        fun size() = blocks.size

        fun increase(index: Int): Memory {
            return Memory(blocks.mapIndexed { idx, block -> when {
                idx == index -> block.increase()
                else -> block
            } } )
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as Memory

            if (blocks != other.blocks) return false

            return true
        }

        override fun hashCode(): Int {
            return blocks.hashCode()
        }


        fun reallocate(): Memory {
            var reallocate = clone()

            val maxIndex = reallocate.maxIndex()
            val maxValue = reallocate.maxValue()

            reallocate.setMemory(maxIndex, 0)

            (1..maxValue).forEach {
                reallocate = reallocate.increase((maxIndex + it) % size())
            }
            return reallocate
        }

    }
}