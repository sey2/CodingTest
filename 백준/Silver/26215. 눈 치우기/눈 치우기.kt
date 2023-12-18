import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Collections
import java.util.PriorityQueue


fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val q = PriorityQueue<Int>(Collections.reverseOrder())

    val input = br.readLine().split(" ").map { it.toInt() }
    repeat(n) {
        q.add(input[it])
    }

    var ans = 0
    while(!q.isEmpty()) {
       if(q.size >= 2) {
           val first = q.poll()
           ans += q.peek()
           q.add(first - q.poll())
       } else {
           ans += q.poll()
       }
    }

    println(if(ans > 1440) -1 else ans)

}
