import java.util.LinkedList
import java.util.Queue

val dy = intArrayOf(1, -1, 0, 0)
val dx = intArrayOf(0, 0, 1, -1)

fun main() {
    val (n, m) = readln().trim().split(Regex("\\s+")).map { it.toInt() }
    val grid = Array(n) {
        readln().trim().split(Regex("\\s+")).map { it.toInt() }.toIntArray()
    }
    var time = 0
    var lastCount = 0

    while (true) {
        val meltList = findMeltIce(grid, n, m)

        if (meltList.isEmpty()) break

        lastCount = meltList.size
        time++

        for ((y, x) in meltList) {
            grid[y][x] = 0
        }
    }

    println("$time $lastCount")
}

fun findMeltIce(grid: Array<IntArray>, n: Int, m: Int): MutableList<Pair<Int, Int>> {
    val visited = Array(n) { BooleanArray(m) }
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    val meltList = mutableListOf<Pair<Int, Int>>()

    queue.offer(0 to 0)
    visited[0][0] = true

    while (queue.isNotEmpty()) {
        val (y, x) = queue.poll()

        for (dir in 0 until 4) {
            val ny = y + dy[dir]
            val nx = x + dx[dir]

            if (ny !in 0 until n || nx !in 0 until m || visited[ny][nx]) continue

            visited[ny][nx] = true

            if (grid[ny][nx] == 0) {
                queue.offer(ny to nx)
            } else {
                meltList.add(ny to nx)
            }
        }
    }

    return meltList
}