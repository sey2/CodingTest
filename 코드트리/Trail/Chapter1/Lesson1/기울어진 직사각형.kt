import kotlin.math.max

fun main() {
    val n = readln().trim().toInt()
    val grid = Array(n) {
        readln().trim().split(" ").map { it.toInt() }.toIntArray()
    }

    var ans = 0

    for (y in 0 until n) {
        for (x in 0 until n) {
            for (a in 1 until n) {
                for (b in 1 until n) {
                    val board = Board(grid, BoardPos(y, x))
                    val sum = board.getSum(a, b)

                    ans = max(ans, sum)
                }
            }
        }
    }

    println(ans)
}


class Board(
    private val grid: Array<IntArray>,
    private val pos: BoardPos,
) {
    fun getSum(aMoveCount: Int, bMoveCount: Int): Int {
        val dy = intArrayOf(-1, -1, 1, 1)
        val dx = intArrayOf(1, -1, -1, 1)

        var sum = 0

        val moveCounts = intArrayOf(aMoveCount, bMoveCount, aMoveCount, bMoveCount)

        for (dir in 0 until 4) {
            repeat(moveCounts[dir]) {
                pos.move(dy[dir], dx[dir])

                if (!inRange()) return 0

                sum += grid[pos.y][pos.x]
            }
        }

        return sum
    }

    private fun inRange(): Boolean = (pos.y in 0 until grid.size) && (pos.x in 0 until grid.size)
}

data class BoardPos(
    var y: Int,
    var x: Int,
) {
    fun move(y: Int, x: Int) {
        this.y += y
        this.x += x
    }
}