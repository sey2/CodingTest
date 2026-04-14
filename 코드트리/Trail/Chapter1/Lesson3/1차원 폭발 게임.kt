fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    var bombs = List(n) { readln().toInt() }

    while (true) {
        val next = explodeOnce(bombs, m)
        if (next == bombs) break
        bombs = next
    }

    println(bombs.size)
    bombs.forEach { println(it) }
}

fun explodeOnce(bombs: List<Int>, m: Int): List<Int> {
    if (bombs.isEmpty()) return emptyList()

    val result = mutableListOf<Int>()
    var start = 0

    while (start < bombs.size) {
        var end = start

        // 같은 숫자가 어디까지 연속되는지 찾기
        while (end < bombs.size && bombs[end] == bombs[start]) {
            end++
        }

        val count = end - start

        // m개 미만이면 남기고, m개 이상이면 터뜨림
        if (count < m) {
            repeat(count) {
                result.add(bombs[start])
            }
        }

        start = end
    }

    return result
}