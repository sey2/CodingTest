fun main() = with(System.`in`.bufferedReader()) {
    val commandCount = readLine().toInt()

    val customQ: CustomQueue<Int> = CustomQueueImpl()

    repeat(commandCount) {
        val input = readLine().split(" ")

        when (input[0]) {
            "push" -> customQ.push(input[1].toInt())
            "pop" -> println(customQ.pop())
            "size" -> println(customQ.size())
            "empty" -> println(customQ.empty())
            "front" -> println(customQ.front())
            "back" -> println(customQ.back())
        }
    }
}

interface CustomQueue<T> {
    fun push(item: T)

    fun pop(): Any

    fun size(): Int

    fun empty(): Int

    fun front(): Any

    fun back(): Any
}

class CustomQueueImpl<T : Any> : CustomQueue<T> {
    private val queue = arrayListOf<T>()
    private var end = 0

    override fun push(item: T) {
        queue.add(end++, item)
    }

    override fun pop(): Any {
        return if (empty() == 1) -1 else {
            end --
            queue.removeFirst()
        }
    }

    override fun size(): Int {
        return queue.size
    }

    override fun empty(): Int {
        return if (end == 0) 1 else 0
    }

    override fun front(): Any {
        return if (empty() == 1) -1 else queue[0]
    }

    override fun back(): Any {
        return if (empty() == 1) -1 else queue[end - 1]
    }

}