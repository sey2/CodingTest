fun main() {
    // m: 블록의 크기 1 x m
    // k: 블록을 놓을 시작 위치
    val (n, m, k) = readln().split(" ").map { it.toInt() }
    val grid = MutableList(n) { readln().split(" ").map { it.toInt() }.toMutableList() }
    var dropPosition = 0

    loop@
    for (i in 1 until grid.size) {
        val checkList = grid[i]

        for (j in k-1 until m+k-1) {
            if (checkList[j] != 0) {
                dropPosition = i - 1
                break@loop
            }
        }
        dropPosition = i
    }

    for (i in k-1 until k-1+m) {
        grid[dropPosition][i] = 1
    }

    grid.forEach {
        println(it.joinToString(" "))
    }
}