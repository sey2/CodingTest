import java.util.*

val dx = arrayOf(0, 0, -1, 1)
val dy = arrayOf(-1, 1, 0, 0)

fun main() {
    val br = System.`in`.bufferedReader()

    val board = Array(5) { Array(5) { 0 } }

    repeat(5) {
        val input = br.readLine().split(" ").map { it.toInt() }

        repeat(5) { inner ->
            board[it][inner] = input[inner]
        }
    }

    val start = br.readLine().split(" ").map { it.toInt() }

    println(bfs(Triple(start[0], start[1], 0), board))
}

fun bfs(start: Triple<Int, Int, Int>, board: Array<Array<Int>>): Int {
    val q: Queue<Triple<Int, Int, Int>> = LinkedList()
    q.add(start)

    val visited = Array(5) { Array(5) { false } }
    visited[start.first][start.second] = true

    while(!q.isEmpty()) {
        val cur = q.poll()

        if(board[cur.first][cur.second] == 1) return cur.third

        for(i in 0 .. 3) {
            val ny = cur.first + dy[i]
            val nx = cur.second + dx[i]

            if(check(nx, ny, board) && !visited[ny][nx]) {
                q.add(Triple(ny, nx, cur.third+1))
                visited[ny][nx] = true
            }

        }
    }

    return -1

}

fun check(nx: Int, ny: Int, board: Array<Array<Int>>): Boolean
    = (nx in 0..4) && (ny in 0 .. 4) && (board[ny][nx] == 0 || board[ny][nx] == 1)
