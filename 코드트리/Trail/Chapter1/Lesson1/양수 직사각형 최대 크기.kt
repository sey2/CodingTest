import kotlin.math.max

fun main() {
    val (n, m) = readln().trim().split(" ").map { it.toInt() }
    val grid = List(n) { readln().trim().split(" ").map { it.toInt() } }
    // Please write your code here.

    var ans = -1
    for (i in 0 .. n - 1) {
        for (j in 0 .. m - 1) {

            for (height in 0 .. n - 1) {
                for (width in 0 .. m - 1) {
                    val endY = height + i
                    val endX = width + j

                    if(!checkRectangle(grid, i, endY, j, endX, n, m)) continue

                    ans = max(ans, (width+1) * (height+1))
                }
            }
        }
    }

    println(ans)
}

fun checkRectangle(
    grid: List<List<Int>>,
    startY: Int,
    endY: Int,
    startX: Int,
    endX: Int,
    n: Int,
    m: Int,
): Boolean {
    for (y in startY ..  endY) {
        for(x in startX ..  endX) {
            if (!inRange(y, x , n, m) || grid[y][x] <= 0 ) { return false }
        }
    }

    return true
}

fun inRange(y: Int, x: Int, n: Int, m: Int): Boolean = (y in 0 .. n - 1) && (x in 0 .. m - 1)