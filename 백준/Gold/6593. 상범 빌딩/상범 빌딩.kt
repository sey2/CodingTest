import java.util.*
import kotlin.collections.ArrayList

val dx = arrayListOf(-1, 1, 0, 0, 0, 0)
val dy = arrayListOf(0, 0, -1, 1, 0, 0)
val dz = arrayListOf(0, 0, 0, 0, 1, -1)

fun main() {
    val br = System.`in`.bufferedReader()

    while (true) {
        val (l, r, c) = br.readLine().split(" ").map { it.toInt() }

        if(l == 0 && r == 0 && c == 0) break

        var start = Node(0, 0, 0, 0)

        val building = ArrayList<Array<CharArray>>().apply {
            for (i in 0 until l) {
                val arr = Array(r) { CharArray(c) }

                repeat(r) { row ->
                    val inputs = br.readLine()

                    repeat(c) { col ->
                        arr[row][col] = inputs[col]

                        if (arr[row][col] == 'S')
                            start = Node(i, row, col, 0)
                    }

                }
                add(arr)
                br.readLine()
            }
        }

        val ans = bfs(building, l, r, c, start)

        if(ans != -1)
            println("Escaped in $ans minute(s).")
        else
            println("Trapped!")
    }
}

fun bfs(
    building: ArrayList<Array<CharArray>>,
    l: Int,
    r: Int,
    c: Int,
    start: Node
): Int {
    val q: Queue<Node> = LinkedList()
    q.add(start)

    val visited = Array(l) { Array(r) { BooleanArray(c) } }
    visited[start.l][start.r][start.c] = true

    while (q.isNotEmpty()) {
        val cur = q.poll()

        if(building[cur.l][cur.r][cur.c] == 'E') return cur.cost

        for (i in 0..5) {
            val nz = dz[i] + cur.l
            val ny = dy[i] + cur.r
            val nx = dx[i] + cur.c

            if (checkRange(l, r, c, nz, ny, nx) && !visited[nz][ny][nx] && building[nz][ny][nx] != '#') {
                q.add(Node(nz, ny, nx, cur.cost + 1))
                visited[nz][ny][nx] = true
            }

        }
    }
    return -1
}

fun checkRange(l: Int, r: Int, c: Int, nz: Int, ny: Int, nx: Int): Boolean =
    (nz in 0 until l) && (ny in 0 until r) && (nx in 0 until c)

data class Node(val l: Int, val r: Int, val c: Int, val cost: Int)
