import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val graph = arrayListOf<ArrayList<Int>>()
    val parent = Array(n + 1) { 0 }
    val visited = Array(n + 1) { false }

    for (i in 0..n) graph.add(arrayListOf())

    repeat(n - 1) {
        val input = br.readLine().split(" ").map { it.toInt() }

        graph[input[0]].add(input[1])
        graph[input[1]].add(input[0])
    }

    val q: Queue<Int> = LinkedList()
    q.add(1)

    while (!q.isEmpty()) {
        val cur = q.poll()
        visited[cur] = true

        for (next in graph[cur]) {
            if (!visited[next]) {
                parent[next] = cur
                q.add(next)
            }
        }
    }

    for (i in 2..n) {
        println(parent[i])
    }

}

