val dx = arrayOf(0, 0, -1, 1)
val dy = arrayOf(1, -1, 0, 0)

fun main() {
    val (n, m, q) = readln().trim().split(" ").map { it.toInt() }
    var building = List(n) { readln().trim().split(" ").map { it.toInt() }.toMutableList() }.toMutableList()

    val winds = List(q) {
        val wind = readln().trim().split(" ").map { it.toInt() - 1 }
        val start: Pos = Pos(wind[0], wind[1])
        val end: Pos = Pos(wind[2], wind[3])

        building.rotate(start, end)
        val newBuilding = building.map { it.toMutableList() }.toMutableList()

        for (i in start.y .. end.y) {
            for (j in start.x .. end.x) {
                var count = 1
                var sum = building[i][j]

                for(k in 0 .. 3) {
                    val nextY = dy[k] + i
                    val nextX = dx[k] + j

                    if(nextY in 0 .. n-1 && nextX in 0 .. m-1) {
                        count++
                        sum += building[nextY][nextX]
                    }
                }
                newBuilding[i][j] = sum / count
            }
        }
        building = newBuilding
    }

    building.forEach {
        println(it.joinToString(" "))
    }
}

fun MutableList<MutableList<Int>>.rotate(
    start: Pos,
    end: Pos,
) {
    val border = mutableListOf<Pos>()

    for (x in start.x until end.x) border.add(Pos(start.y, x))
    for (y in start.y until end.y) border.add(Pos(y, end.x))
    for (x in end.x downTo start.x + 1) border.add(Pos(end.y, x))
    for (y in end.y downTo start.y + 1) border.add(Pos(y, start.x))

    val values = border.map { this[it.y][it.x] }.toMutableList()
    values.add(0, values.removeLast())

    for (i in border.indices) {
        val (y, x) = border[i]
        this[y][x] = values[i]
    }
}

data class Pos(
    val y: Int,
    val x: Int
)