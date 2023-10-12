import java.util.*

lateinit var graph: Array<CharArray>
var start = Triple(0, 0, 0)
val currentWater: Queue<Pair<Int, Int>> = LinkedList()
var n = 0
var m = 0


fun main() {
    var br = System.`in`.bufferedReader()
    val input = br.readLine().split(" ").map { it.toInt() }
    n = input[0]
    m = input[1]

    graph = Array(n) { CharArray(m) }

    for (i in 0 until n) {
        val input = br.readLine()
        for (j in 0 until m) {
            graph[i][j] = input[j]
            if(graph[i][j] == 'S') start = Triple(i, j, 0)
            else if (graph[i][j] == '*')  currentWater.add(Pair(i,j))
        }
    }

    bfs()
}

val dx = arrayListOf(0, 0, -1, 1)
val dy = arrayListOf(-1, 1, 0, 0)

fun bfs() {
    val q: Queue<Triple<Int, Int, Int>> = LinkedList()
    q.add(start)

    while (!q.isEmpty()) {
        fillWater()

        val len = q.size
        for (i in 0 until len) {
            val cur = q.poll()

            for (j in 0 until 4) {
                val nx = cur.first + dx[j]
                val ny = cur.second + dy[j]

                if (check(nx, ny)) {
                    if (graph[nx][ny] == 'D') {
                        println(cur.third + 1)
                        return
                    } else if (graph[nx][ny] == '.') {
                        q.add(Triple(nx, ny, cur.third + 1))
                        graph[nx][ny] = 'S'
                    }
                }
            }
        }
    }
    println("KAKTUS")
}

fun fillWater() {
    for(i in 0 until currentWater.size) {
        val cur = currentWater.poll()
        for (i in 0 .. 3) {
            val nx = cur.first + dx[i]
            val ny = cur.second + dy[i]

            if(check(nx, ny) && graph[nx][ny] == '.') {
                graph[nx][ny] = '*'
                currentWater.add(Pair (nx, ny))
            }
        }
    }
}

fun check(x: Int, y: Int) = (x in 0 until n && y >= 0 && y < m)