fun main() {
    // (n,m): 행렬 사이즈, q: 총 불어온 바람의 횟수
    val (n, m, q) = readln().trim().split(" ").map { it.toInt() }
    var building = List(n) { readln().trim().split(" ").map { it.toInt() }.toMutableList() }.toMutableList()

    // r: 바람에 영향 받는 행 번호, d: 불어오는 방향 (L, R)
    val winds = List(q) {
        val (r, d) = readln().split(" ")
        r.toInt() to d[0]
    }

    winds.forEach { wind ->
        val r = wind.first - 1
        val d = wind.second

        building[r] = building[r].toMove(d)

        building.spread(r .. n - 1, 1, n, d)
        building.spread(r downTo 0 , -1, n, d)
    }

    building.forEach {
        println(it.joinToString ( " " ))
    }
}

fun MutableList<MutableList<Int>>.spread(
    range: IntProgression,
    nextRow: Int,
    n: Int,
    d: Char,
) {
    var reverseDirection = d
    for (i in range) {
        if (checkRange(i+nextRow, n)) break
        if (!this[i].compareSameValue(this[i+nextRow])) break
        reverseDirection = reverseDirection.reverse()
        this[i+nextRow] = this[i+nextRow].toMove(reverseDirection)
    }
}


fun Char.reverse() = when (this) {
    'L' -> 'R'
    else -> 'L'
}

fun checkRange(nextRow: Int, n: Int) = nextRow !in 0 .. n - 1

fun MutableList<Int>.compareSameValue(nextRows: MutableList<Int>): Boolean {
    for (i in 0 .. this.size - 1) {
        if(this[i] == nextRows[i]) return true
    }

    return false
}

fun MutableList<Int>.toMove(
    command: Char,
): MutableList<Int> {
    if (command == 'L') {
        this.add(0, this.removeLast())
    } else {
        val first = this.removeFirst()
        this.add(first)
    }
    return this
}