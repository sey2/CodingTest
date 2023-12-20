import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    var n = br.readLine().toInt()
    val q: Queue<Pair<String, Int>> = LinkedList()

    repeat(n) {
        val input = br.readLine().split(" ")
        q.add(Pair(input[0], input[1].toInt()))
    }

    while(q.size > 1) {
        val cur = q.poll()

        repeat(cur.second-1) {
            q.add(q.poll())
        }

        q.poll()
    }

    println(q.poll().first)

}