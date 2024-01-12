import java.util.PriorityQueue

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()

    val arr = Array(n) { IntArray(n) }
    for (i in 0 until n) {
        val input = br.readLine()

        for (j in 0 until n) {
            arr[i][j] = input[j] - '0'
        }
    }

    println(bfs(Node(0, 0, 0), n, arr))

}

val dx = arrayOf(0, 0, -1, 1)
val dy = arrayOf(1, -1, 0, 0)

fun bfs(start: Node, n: Int, arr: Array<IntArray>): Int {
    val pq = PriorityQueue<Node>()
    pq.add(start)
    val visited = Array(n) { BooleanArray(n) }
    visited[start.y][start.x] = true

    while (!pq.isEmpty()) {
        val cur = pq.poll()

        if(cur.y == n-1 && cur.x == n-1) return cur.count

        for (i in 0..3) {
            val ny = dy[i] + cur.y
            val nx = dx[i] + cur.x

            if (check(ny, nx, n, visited)) {
                val nCount = if (arr[ny][nx] == 0) cur.count + 1 else cur.count
                pq.add(Node(ny, nx, nCount))
                visited[ny][nx] = true
            }
        }
    }

    return -1
}

fun check(ny: Int, nx: Int, n: Int, visited: Array<BooleanArray>) =
    (ny in 0 until n) && (nx in 0 until n) && !visited[ny][nx]

class Node(val y: Int, val x: Int, val count: Int) : Comparable<Node> {
    override fun compareTo(o: Node) = this.count - o.count
}



