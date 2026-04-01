import java.lang.Math.pow
import java.util.LinkedList
import java.util.Queue
import kotlin.math.max

val dx = intArrayOf(0, 0, -1, 1)
val dy = intArrayOf(1, -1, 0, 0)

fun main() {
    val (n, m) = readln().trim().split(" ").map { it.toInt() }
    val grid = Array(n) { readln().trim().split(" ").map { it.toInt() }.toIntArray() }

    var ans = 0

    for (gridCol in 0.. n - 1) {
        for (gridRow in 0 .. n - 1) {

            // 마름모 모양을 지키면서 이동할 수 있는 최대 K번 만큼 반복
            for (k in 0 .. n + 3) {
                val goldCount = bfs(grid, Graph(gridCol, gridRow, k), n)

                val goldPrice = m * goldCount

                if (goldPrice < (k*k + (k+1) * (k+1) )) continue

                ans = max(goldCount, ans)
            }
        }
    }

    println(ans)
}

fun bfs(
    graph: Array<IntArray>,
    start: Graph,
    n: Int,
): Int {
    val q: Queue<Graph> = LinkedList()
    q.add(start)

    val visited: Array<BooleanArray> = Array(n) { BooleanArray (n) }
    visited[start.y][start.x] = true

    var goldCount = 0

    while (q.isNotEmpty()) {
        val current = q.poll()

        if (graph[current.y][current.x] == 1) goldCount ++

        if (current.cost == 0) continue

        for (i in 0 .. 3) {
            val nextY = dy[i] + current.y
            val nextX = dx[i] + current.x

            if (canMove(n, nextY, nextX, visited)) {
                q.add(Graph(nextX, nextY, current.cost - 1))
                visited[nextY][nextX] = true
            }
        }
    }

    return goldCount
}

fun canMove(
    n: Int,
    nextY: Int,
    nextX: Int,
    visited: Array<BooleanArray>,
): Boolean = (nextY in 0 .. n - 1) && (nextX in 0 .. n -1) && !visited[nextY][nextX]

data class Graph(
    val x: Int,
    val y: Int,
    val cost: Int
)