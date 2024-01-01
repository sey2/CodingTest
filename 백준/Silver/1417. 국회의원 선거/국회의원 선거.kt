import java.util.Collections
import java.util.PriorityQueue

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()

    val q = PriorityQueue<Int>(Collections.reverseOrder())
    var first = 0

    for(i in 0 until n) {
        val input = br.readLine().toInt()
        if(i == 0) first = input
        else q.add(input)
    }

    var ans = 0

    while(q.isNotEmpty()) {
        if(first > q.peek()) break
        q.add(q.poll() - 1)
        first ++
        ans ++
    }

    println(ans)

}
