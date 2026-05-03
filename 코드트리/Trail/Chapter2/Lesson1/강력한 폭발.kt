var ans = 0
var n = 0

val bombTypes: List<List<Pair<Int, Int>>> = listOf(
    listOf(0 to 0, 1 to 0, 2 to 0, -1 to 0, -2 to 0),
    listOf(0 to 0, -1 to 0, 1 to 0, 0 to -1, 0 to 1),
    listOf(0 to 0, -1 to -1, -1 to 1, 1 to -1, 1 to 1)
)

fun main() {
    n = readln().toInt()

    val grid = Array(n) {
        readln().split(" ").map { it.toInt() }.toMutableList()
    }

    val bombLocations = mutableListOf<Pair<Int, Int>>()

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (grid[i][j] == 1) {
                bombLocations.add(i to j)
            }
        }
    }

    comb(grid, bombLocations, 0)

    println(ans)
}

fun comb(
    grid: Array<MutableList<Int>>,
    bombLocations: List<Pair<Int, Int>>,
    depth: Int
) {

    if (depth == bombLocations.size) {

        val count = grid.sumOf { row ->
            row.count { it == -1 }
        }

        ans = maxOf(ans, count)
        return
    }

    val currentPosition = bombLocations[depth]

    for (j in 0 until bombTypes.size) {

        val copiedGrid = Array(grid.size) { y ->
            grid[y].toMutableList()
        }

        val bombShape = bombTypes[j]

        for (position in bombShape) {

            val ny = currentPosition.first + position.first
            val nx = currentPosition.second + position.second

            if (ny in 0 until n && nx in 0 until n) {
                copiedGrid[ny][nx] = -1
            }
        }

        comb(copiedGrid, bombLocations, depth + 1)
    }
}