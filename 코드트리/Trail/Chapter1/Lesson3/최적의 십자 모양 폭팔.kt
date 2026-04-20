import kotlin.math.max
import kotlin.math.min

val dy = arrayOf(1, -1, 0, 0)
val dx = arrayOf(0, 0, -1, 1)

fun main() {
    val n = readln().toInt()
    val grid = Array(n) { readln().trim().split(" ").map { it.toInt() }.toMutableList() }
    var ans = 0

    for (i in 0 until  n) {
        for (j in 0 until  n) {
            val copied = Array(n) { i -> grid[i].toMutableList()}


            copied.bomb(Pos(i, j), n)
            copied.drop()

            ans = max(ans, copied.countPair())
        }
    }

    println(ans)
}

fun Array<MutableList<Int>>.countPair(): Int {
    var count = 0

    val ddy = arrayOf(1, 0)
    val ddx = arrayOf(0, 1)

    for (i in 0 until this.size) {
        for (j in 0 until this[i].size) {
            for (k in 0 .. 1) {
                if (this[i][j] == 0) continue

                val ny = i + ddy[k]
                val nx = j + ddx[k]

                if(!inRange(ny, nx, this.size)) continue

                if(this[i][j] == this[ny][nx]) {
                    count ++
                }
            }
        }
    }

    return count
}


fun Array<MutableList<Int>>.bomb(
    pos: Pos,
    n: Int,
) {
    val bombCont = this[pos.y][pos.x]-1

    for (i in 0 .. 3) {
        for (j in 1 .. bombCont) {
            val ny = (dy[i] * j) + pos.y
            val nx = (dx[i] * j) + pos.x

            if (!inRange(ny, nx, n)) continue

            this[ny][nx] = 0
        }
    }

    this[pos.y][pos.x] = 0
}

fun Array<MutableList<Int>>.drop() {
    for (j in 0 until  this.size) {
        val queue = ArrayDeque<Int>()

        for (i in 0 until  this[j].size) {
            if (this[i][j] > 0) queue.add(this[i][j])
        }

        while(queue.size < this.size) queue.addFirst(0)

        for (i in 0 until  this[j].size) {
            this[i][j] = queue.removeFirst()
        }
    }
}

fun inRange(
    ny: Int,
    nx: Int,
    n: Int,
): Boolean = (ny in 0 until n) && (nx in 0 until n)

data class Pos(
    val y: Int,
    val x : Int
)