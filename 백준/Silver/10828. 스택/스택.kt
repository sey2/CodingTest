import kotlin.Exception

fun main() = with(System.`in`.bufferedReader()) {
    var commandCount = readLine().toInt()
    val stack: Stack<Int> = StackImpl()

    repeat(commandCount) {
        val input = readLine().split(" ")

        when(input[0]) {
            "push" -> stack.push(Integer.parseInt(input[1]))
            "pop" -> safeResult { stack.pop() }
            "size" -> println(stack.size())
            "empty" -> println(stack.empty())
            "top" -> safeResult { stack.top() }
        }
    }
}

inline fun <T> safeResult(execute: () -> T): Any? {
    return try {
        val result = execute()
        println(result)
        result
    } catch (exception: Exception) {
        println(-1)
        -1
    }
}

interface Stack<T> {
    fun push(num: T)

    fun pop(): T

    fun size(): Int

    fun empty(): Int

    fun top(): T
}

class StackImpl<T> : Stack<T> {
    private var arr = arrayListOf<T>()
    private var top = -1

    companion object {
        const val MAX_SIZE = 100001
    }

    override fun push(num: T) {
        if (top == MAX_SIZE) {
            throw Exception("Stack is OverFlow")
        }
        arr.add(++top, num)
    }

    override fun pop(): T {
        if (top < 0) {
            throw Exception("Stack is UnderFlow")
        }
        return arr[top--]
    }

    override fun size(): Int {
        return top+1
    }

    override fun empty(): Int {
        return if(top == -1) 1 else 0
    }

    override fun top(): T {
        if(empty() == -1) throw Exception("Stack is Empty")
        return arr[top]
    }

}