import java.util.*

val dy = arrayOf(1, -1, 0, 0)
val dx = arrayOf(0, 0, -1, 1)

fun main() {
    val n = readln().toInt()
    val grid = Array(n) { readln().trim().split(" ").map { it.toInt() }.toMutableList() }
    val (r, c) = readln().trim().split(" ").map { it.toInt() - 1 }
    // Please write your code here.

    grid.boom(r, c, n)
    grid.drop()

    grid.forEach {
        println(it.joinToString(" "))
    }
}

fun inRange(y: Int, x: Int, n: Int): Boolean = (y in 0 until n) && (x in 0 until n)

fun Array<MutableList<Int>>.boom(y: Int, x: Int, n: Int) {
    val boomRange = this[y][x]

    this[y][x] = 0

    if(boomRange == 1) return

    for (i in 0 .. 3) {
        for(j in 1 until  boomRange) {
            val ny = y + dy[i] * j
            val nx = x + dx[i] * j

            if(!inRange(ny, nx, n)) continue

            this[ny][nx] = 0
        }
    }
}

fun Array<MutableList<Int>>.drop() {
    for(i in 0 until this.size) {
        val queue: Queue<Int> = LinkedList()

        for (j in this.size-1 downTo 0) {
            if(this[j][i] > 0 ) queue.add(this[j][i])
        }

        for (k in this.size-1 downTo 0) {
            this[k][i] = if(queue.isNotEmpty()) queue.poll() else 0
        }
    }
}