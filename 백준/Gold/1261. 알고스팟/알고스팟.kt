import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()

    val (m, n) = br.readLine().split(" ").map { it.toInt() }
    val graph = Array(n) { IntArray(m) }

    for (i in 0 until n) {
        val input = br.readLine()
        for (j in 0 until m) {
            graph[i][j] = input[j] - '0'
        }
    }

    println(bfs(Node(0, 0, 0), n, m, graph))

}

val dx = arrayOf(0, 0, -1, 1)
val dy = arrayOf(-1, 1, 0, 0)

fun bfs(start: Node, n: Int, m: Int, graph: Array<IntArray>): Int {
    val pq: PriorityQueue<Node> = PriorityQueue()
    pq.add(start)

    val visited = Array(n) { BooleanArray(m) }
    visited[start.y][start.x] = true

    while (pq.isNotEmpty()) {
        val cur = pq.poll()

        if (cur.y == n - 1 && cur.x == m - 1) return cur.cost

        for (i in 0..3) {
            val ny = dy[i] + cur.y
            val nx = dx[i] + cur.x

            if (check(ny, nx, n, m, visited)) {
                val nextCost = if (graph[ny][nx] == 1) cur.cost + 1 else cur.cost
                pq.add(Node(ny, nx, nextCost))
                visited[ny][nx] = true
            }
        }
    }

    return -1
}

fun check(ny: Int, nx: Int, n: Int, m: Int, visited: Array<BooleanArray>): Boolean =
    (ny in 0 until n) && (nx in 0 until m) && !visited[ny][nx]

data class Node(val y: Int, val x: Int, val cost: Int): Comparable<Node> {
    override fun compareTo(o: Node): Int
            = this.cost - o.cost
}
