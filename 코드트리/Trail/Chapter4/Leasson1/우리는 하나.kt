import java.util.*
import kotlin.collections.HashMap
import kotlin.math.abs

val dx = arrayOf(0, 0, -1, 1)
val dy = arrayOf(1, -1, 0, 0)

typealias Pos = Pair<Int, Int>

fun main() {
    // n: 격자 크기, k: 선택할 도시의 수, U: 이상이여야 이동 가능, d: 이하여야 이동 가능
    val (n, k, u, d) = readln().trim().split(" ").map { it.toInt() }
    val grid = Array(n) { readln().trim().split(" ").map { it.toInt() } }
    val visited: Array<BooleanArray> = Array(n) { BooleanArray(n) {false} }

    // 방문한 도시의 수를 담는 큐
    val pq: PriorityQueue<Int> = PriorityQueue(compareBy { -it })

    for (i in 0 .. n - 1) {
        for (j in 0 .. n -1) {
            if(visited[i][j]) continue

            val current = Pos(i, j)
            val count = bfs(grid, visited, current, n, u, d)
            pq.add(count)
        }
    }

    var kCount = k
    var ans = 0

    while(kCount-- > 0 && pq.isNotEmpty()) {
        ans += pq.poll()
    }

    print(ans)
}

fun bfs(
    grid: Array<List<Int>>,
    visited: Array<BooleanArray>,
    start: Pos,
    n: Int,
    u: Int,
    d: Int,
): Int {
    val q: Queue<Pos> = LinkedList()
    var count = 0
    
    q.add(start)

    visited[start.first][start.second] = true
    count++

    while(q.isNotEmpty()) {
        val current = q.poll()

        for (i in 0 .. 3) {
            val nextY = dy[i] + current.first
            val nextX = dx[i] + current.second

            if(canMove(current, nextY, nextX, visited, grid, n, u, d)) {
                val nextPos = Pos(nextY, nextX)

                q.add(nextPos)
                visited[nextY][nextX] = true
                count++
            }

        }
    }

    return count
}

fun canMove(
    currentPos: Pos,
    nextY: Int,
    nextX: Int,
    visited: Array<BooleanArray>,
    grid: Array<List<Int>>,
    n: Int,
    u: Int,
    d: Int
): Boolean {
    if (nextY < 0 || nextY >= n || nextX < 0 || nextX >= n || visited[nextY][nextX]) {
        return false
    }

    val subtract = abs(grid[nextY][nextX]- grid[currentPos.first][currentPos.second])

    return subtract >= u && subtract <= d;
}