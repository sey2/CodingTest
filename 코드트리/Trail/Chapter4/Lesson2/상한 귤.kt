import java.util.*

val dy = arrayOf(-1, 1, 0, 0)
val dx = arrayOf(0, 0, -1, 1)

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val grid = Array(n) { readln().split(" ").map { it.toInt() } }
    val ans = Array(n) { IntArray(n) { Integer.MAX_VALUE } }
    val startList = mutableListOf<Pos>()

    grid.mapIndexed { i, row ->
        row.mapIndexed { j, value ->
            if(value == 2) startList.add(Pos(i, j, 0))
        }
    }

    startList.forEach { start ->
        bfs(n, start, grid, ans)
    }

    grid.mapIndexed { i, row ->
        row.mapIndexed { j, value ->
            if(value == 1 && ans[i][j] == Integer.MAX_VALUE) ans[i][j] = -2
        }
    }

    ans.map {
        println(it.joinToString(" ") { value ->
            if(value == Integer.MAX_VALUE) "-1" else value.toString()
        })
    }
}

fun bfs(n: Int, start: Pos, grid: Array<List<Int>>, ans: Array<IntArray>) {
    val q: Queue<Pos> = LinkedList()
    q.add(start)

    val visited = Array(n) { BooleanArray(n) }
    visited[start.y][start.x] = true

    while (q.isNotEmpty()) {
        val current = q.poll()

        ans[current.y][current.x] = minOf(current.count, ans[current.y][current.x])

        for (i in 0 .. 3) {
            val ny = dy[i] + current.y
            val nx = dx[i] + current.x

            if (inRange(ny, nx, n) && grid[ny][nx] == 1 && !visited[ny][nx]) {
                q.add(Pos(ny, nx, current.count + 1))
                visited[ny][nx] = true
            }
        }
    }
}

fun inRange(ny: Int, nx: Int, n: Int) = (ny in 0 until n) && (nx in 0 until n)

data class Pos(val y: Int, val x: Int, val count: Int)
