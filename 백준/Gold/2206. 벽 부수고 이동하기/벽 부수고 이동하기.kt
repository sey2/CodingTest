import java.util.PriorityQueue

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val arr = Array(n) { IntArray(m) }

    repeat(n) {
        val input = br.readLine()
        for (i in input.indices) {
            arr[it][i] = input[i] - '0'
        }
    }

    println(bfs(Node(0, 0, 0, 0), n, m, arr))

}

val dx = arrayListOf(0, 0, -1, 1)
val dy = arrayListOf(-1, 1, 0, 0)

fun bfs(start: Node, n: Int, m: Int, arr: Array<IntArray>): Int {
    val pq = PriorityQueue<Node> { o1, o2 -> o1.cost - o2.cost }
    val visited = Array(n) { Array(m) { BooleanArray(2) } }
    pq.add(start)
    visited[start.y][start.x][0] = true
    visited[start.y][start.x][1] = true

    while (pq.isNotEmpty()) {
        val cur = pq.poll()

        if (cur.y == n - 1 && cur.x == m - 1) return cur.cost + 1

        for (i in dx.indices) {
            val ny = dy[i] + cur.y
            val nx = dx[i] + cur.x

            if (check(ny, nx, n, m)) {
                if (arr[ny][nx] == 0) {
                    if (cur.wall == 0) {
                        if (visited[ny][nx][0]) continue
                        visited[ny][nx][0] = true
                        pq.add(Node(ny, nx, cur.cost + 1, 0))
                    } else {
                        if (visited[ny][nx][1]) continue
                        visited[ny][nx][1] = true
                        pq.add(Node(ny, nx, cur.cost + 1, 1))
                    }
                }
                else {
                    if (cur.wall == 0) {
                        visited[ny][nx][1] = true
                        pq.add(Node(ny, nx, cur.cost + 1, 1))
                    }
                }
            }

        }
    }

    return -1
}

fun check(ny: Int, nx: Int, n: Int, m: Int) = (ny in 0 until n) && (nx in 0 until m)

data class Node(val y: Int, val x: Int, val cost: Int, val wall: Int)