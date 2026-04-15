const val gridSize = 4

fun main() {
    val grid = Array(gridSize) { readln().trim().split(" ").map { it.toInt() }.toMutableList() }
    val dir = readln()[0]

    when (dir) {
        'R' -> grid.moveRight()
        'L' -> grid.moveLeft()
        'U' -> grid.moveUp()
        'D' -> grid.moveDown()
    }

    grid.forEach {
        println(it.joinToString(" "))
    }
}

fun MutableList<Int>.combine(): MutableList<Int> {
    val filterList = this.filter { it != 0 }
    val combineList = mutableListOf<Int>()

    var index = 0

    while (index < filterList.size) {
        if (index < filterList.size - 1 && filterList[index] == filterList[index + 1]) {
            combineList.add(filterList[index] * 2)
            index += 2
            continue
        }

        combineList.add(filterList[index])
        index++
    }

    while (combineList.size < gridSize) {
        combineList.add(0)
    }

    return combineList
}

fun Array<MutableList<Int>>.moveLeft() {
    for (i in 0 until gridSize) {
        val combineList = this[i].combine()
        this[i] = combineList
    }
}
fun Array<MutableList<Int>>.moveRight() {
    for (i in 0 until gridSize) {
        val combineList = this[i].reversed().toMutableList().combine().reversed().toMutableList()
        this[i] = combineList
    }
}

fun Array<MutableList<Int>>.moveUp() {
    for (j in 0 until gridSize) {
        val col = mutableListOf<Int>()

        for(i in 0 until 4) {
            col.add(this[i][j])
        }
        val combineList = col.combine()

        for(i in 0 until 4) {
            this[i][j] = combineList[i]
        }
    }
}

fun Array<MutableList<Int>>.moveDown() {
    for (j in 0 until gridSize) {
        val col = mutableListOf<Int>()

        for(i in 0 until 4) {
            col.add(this[i][j])
        }
        val combineList = col.reversed().toMutableList().combine().reversed()

        for(i in 0 until 4) {
            this[i][j] = combineList[i]
        }
    }
}
