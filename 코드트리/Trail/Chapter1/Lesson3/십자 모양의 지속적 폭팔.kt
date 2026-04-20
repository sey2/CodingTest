val dy = arrayOf(1, -1, 0, 0)
val dx = arrayOf(0, 0, -1, 1)

fun main() {
    val (n, m) = readln().trim().split(" ").map { it.toInt() }
    val grid = Array(n) { readln().trim().split(" ").map { it.toInt() }.toMutableList() }
    val bombCols = List(m) { readln().toInt()-1 }


    bombCols.forEach { bombCol ->
        val findPos = grid.findPos(bombCol)

        findPos?.let {
            grid.bomb(findPos, n)
            grid.drop()
        }
    }

    grid.forEach {
        println(it.joinToString(" "))
    }
}

fun Array<MutableList<Int>>.findPos(
    col: Int
): Pos? {
    for (i in 0 until  this.size) {
        if(this[i][col] != 0) {
            return Pos(i, col)
        }
    }

    return null
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