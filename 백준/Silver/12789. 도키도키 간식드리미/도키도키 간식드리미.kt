import java.util.*
import kotlin.collections.ArrayDeque

fun main() {
    val br = System.`in`.bufferedReader()
    var n = br.readLine().toInt()
    val q = ArrayDeque<Int>()
    val input = br.readLine().split(" ").map { it.toInt() }

    repeat(n) {
        q.add(input[it])
    }

    val stack = Stack<Int>()
    while(q.isNotEmpty()){
        val min = q.min()

        if (stack.isNotEmpty() && (stack.peek() == min || stack.peek() < min)) {
            stack.pop()
            continue
        }

        if (q.first() == min) {
            q.removeFirst()
            continue
        } else {
            stack.push(q.removeFirst())
        }
    }

    while (stack.size > 1 && stack.peek() < stack[stack.size - 2]) {
        stack.pop()
    }

    if (stack.size <= 1) println("Nice") else println("Sad")
}