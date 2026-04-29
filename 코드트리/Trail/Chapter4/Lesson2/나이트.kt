import java.util.*

val dy = arrayOf(-2, -2, -1, -1, 1, 1, 2, 2)
val dx = arrayOf(-1, 1, -2, 2, -2, 2, -1, 1)

fun main() {
    val n = readln().toInt()
    val (r1, c1, r2, c2) = readln().split(" ").map { it.toInt() }
    val startRow = r1 - 1
    val startCol = c1 - 1
    val endRow = r2 - 1
    val endCol = c2 - 1

    println(bfs(start = Pos(startRow, startCol,0), end = Pos(endRow, endCol, -1), n))
}

fun bfs(start: Pos, end: Pos, n: Int): Int {
    val q: Queue<Pos> = LinkedList()
    q.add(start)

    val visited = Array(n) { BooleanArray (n) { false } }
    visited[start.y][start.x] = true

    while(q.isNotEmpty()) {
        val current = q.poll()

        if (current.y == end.y && current.x == end.x) {
            return current.count
        }

        for (i in 0 .. 7) {
            val ny = current.y + dy[i]
            val nx = current.x + dx[i]

            if (inRange(ny, nx, n) && !visited[ny][nx]) {
                q.add(Pos(ny, nx, current.count + 1))
                visited[ny][nx] = true
            }
        }
    }

    return end.count
}

fun inRange(ny: Int, nx: Int, n: Int) = (ny in 0 until n) && (nx in 0 until  n)


data class Pos(val y: Int, val x: Int, val count: Int)