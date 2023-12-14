import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val stack = ArrayDeque<Int>()
    val sb = StringBuilder()

    repeat(n) {
        val input = br.readLine().split(" ")

        when (input[0]) {
            "1" -> stack.addLast(input[1].toInt())
            "2" -> sb.append(if (stack.isNotEmpty()) stack.removeLast() else -1).append("\n")
            "3" -> sb.append(stack.size).append("\n")
            "4" -> sb.append(if (stack.isEmpty()) 1 else 0).append("\n")
            "5" -> sb.append(if (stack.isNotEmpty()) stack.last() else -1).append("\n")
        }
    }
    print(sb.toString())
}
