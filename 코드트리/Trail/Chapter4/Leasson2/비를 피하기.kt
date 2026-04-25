import java.util.*

val dy = arrayOf(-1, 1, 0, 0)
val dx = arrayOf(0, 0, -1, 1)

fun main() {
    val (n, h, m) = readln().split(" ").map { it.toInt() }
    val grid = Array(n) { readln().split(" ").map { it.toInt() } }
    val ans = Array(n) { IntArray(n) { 0 } }

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (grid[i][j] == 2) {
                ans[i][j] = bfs(Pos(i, j, 0), n, grid)
            }
        }
    }

    ans.map {
        println(it.joinToString(" "))
    }
}

fun bfs(start: Pos, n: Int, grid: Array<List<Int>>): Int {
    val q: Queue<Pos> = LinkedList()
    q.add(start)

    val visited = Array(n) { BooleanArray(n) { false } }

    while(q.isNotEmpty()) {
        val current = q.poll()

        if (grid[current.y][current.x] == 3) {
            return current.count
        }

        for (i in 0 .. 3) {
            val ny = current.y + dy[i]
            val nx = current.x + dx[i]

            if (inRange(ny, nx, n) && grid[ny][nx] != 1 && !visited[ny][nx]) {
                q.add(Pos(ny, nx, current.count + 1))
                visited[ny][nx] = true
            }
        }
    }

    return -1
}

fun inRange(ny: Int, nx: Int, n: Int) = (ny in 0 until n) && (nx in 0 until n)


data class Pos(val y: Int, val x: Int, val count: Int)