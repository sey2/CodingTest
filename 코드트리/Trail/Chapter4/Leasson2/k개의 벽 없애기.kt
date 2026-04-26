import java.util.*

val dy = intArrayOf(-1, 1, 0, 0)
val dx = intArrayOf(0, 0, -1, 1)

data class Pos(
    val y: Int,
    val x: Int,
    val remain: Int,
    val move: Int
)

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }

    val grid = Array(n) {
        readln().split(" ").map { it.toInt() }.toIntArray()
    }

    val (r1, c1) = readln().split(" ").map { it.toInt() - 1 }
    val (r2, c2) = readln().split(" ").map { it.toInt() - 1 }

    println(bfs(n, k, grid, r1, c1, r2, c2))
}

fun bfs(
    n: Int,
    k: Int,
    grid: Array<IntArray>,
    sy: Int,
    sx: Int,
    ey: Int,
    ex: Int
): Int {

    val q: Queue<Pos> = LinkedList()

    val visited = Array(n) {
        IntArray(n) { -1 }
    }

    q.add(Pos(sy, sx, k, 0))
    visited[sy][sx] = k

    while (q.isNotEmpty()) {

        val cur = q.poll()

        if (cur.y == ey && cur.x == ex) {
            return cur.move
        }

        for (i in 0..3) {

            val ny = cur.y + dy[i]
            val nx = cur.x + dx[i]

            if (!inRange(ny, nx, n)) continue

            val nextRemain = cur.remain - grid[ny][nx]

            if (nextRemain < 0) continue

            if (visited[ny][nx] >= nextRemain) continue

            visited[ny][nx] = nextRemain

            q.add(Pos(ny, nx, nextRemain, cur.move + 1))
        }
    }

    return -1
}

fun inRange(y: Int, x: Int, n: Int): Boolean {
    return y in 0 until n && x in 0 until n
}