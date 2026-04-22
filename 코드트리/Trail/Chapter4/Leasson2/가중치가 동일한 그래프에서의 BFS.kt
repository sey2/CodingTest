import java.util.*

val dy = arrayOf(1, -1, 0, 0)
val dx = arrayOf(0, 0, -1, 1)


fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val grid = Array(n) { readln().split(" ").map { it.toInt() } }

    println(bfs(grid,n, m))
}

fun bfs (grid: Array<List<Int>>, n: Int, m: Int): Int {
    val q: Queue<Pos> = LinkedList()
    q.add(Pos(0,0, 0))

    val visited = Array(n) { BooleanArray(m) { false } }
    visited[0][0] = true


    while(q.isNotEmpty()) {
        val current = q.poll()

        if (current.y == n-1 && current.x == m-1) {
            return current.count
        }

        for (i in 0.. 3) {
            val ny = current.y + dy[i]
            val nx = current.x + dx[i]

            if(inRange(ny, nx, n, m) && !visited[ny][nx] && grid[ny][nx] == 1) {
                q.add(Pos(ny, nx, current.count +1))
                visited[ny][nx] = true
            }
        }
    }

    return -1
}

fun inRange(ny: Int, nx: Int, n: Int, m: Int) = (ny in 0 until n) && (nx in 0 until m)

data class Pos(val y: Int, val x: Int, val count: Int)