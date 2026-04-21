val dy = arrayOf(-1, 1, 0, 0)
val dx = arrayOf(0, 0, -1, 1)

fun main() {
    val (n, r, c) = readln().trim().split(" ").map { it.toInt() }
    val grid = List(n) { readln().trim().split(" ").map { it.toInt() } }

    var current = Pos(r-1, c-1)

    val ans = mutableListOf<Int>()

    while (true) {
        ans.add(grid[current.y][current.x])

        val next = grid.move(current, n) ?: break

        current = next
    }

    println(ans.joinToString(" "))
}

fun List<List<Int>>.move(
    current: Pos,
    n: Int,
): Pos? {
    for (i in 0 .. 3) {
        val ny = current.y + dy[i]
        val nx = current.x + dx[i]

        if(!inRange(ny, nx, n)) continue

        if(this[current.y][current.x] < this[ny][nx]) {
            return Pos(ny, nx)
        }
    }
    return null
}

fun inRange(
    ny: Int,
    nx: Int,
    n: Int
): Boolean = (ny in 0 until n) && (nx in 0 until n)

data class Pos(
    val y: Int,
    val x: Int,
)