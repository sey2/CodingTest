import java.util.*

fun main() {
    val n = readln().toInt()
    println(bfs(Pos(n, 0)))
}

fun bfs(start: Pos): Int {
    val q: Queue<Pos> = LinkedList()
    q.add(start)

    val visited = BooleanArray(2000001)
    visited[start.value] = true

    while (q.isNotEmpty()) {
        val current = q.poll()

        if (current.value == 1) {
            return current.count
        }

        if (current.value > 1000001) continue

        if (!visited[current.value+1]) {
            q.add(Pos(current.value+1, current.count + 1))
            visited[current.value+1] = true
        }

        if (!visited[current.value-1]) {
            q.add(Pos(current.value-1, current.count + 1))
            visited[current.value-1] = true
        }

        if (current.value % 2 == 0 && !visited[current.value / 2]) {
            q.add(Pos(current.value/2, current.count + 1))
            visited[current.value/2] = true
        }

        if (current.value % 3 == 0 && !visited[current.value / 3]) {
            q.add(Pos(current.value / 3, current.count + 1))
            visited[current.value/3] = true
        }
    }

    return start.count
}

data class Pos(val value: Int, val count: Int)