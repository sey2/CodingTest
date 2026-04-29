private val result = mutableListOf<Int>()

fun main() {
    val input = readln().split(" ")
    val k = input[0].toInt()
    val n = input[1].toInt()

    comb(n, k, 0)
}

fun comb(n: Int, k: Int, depth: Int) {
    if (depth == n) {
        println(result.joinToString(" "))
        return
    }

    for (i in 1 .. k) {
        result.add(i)
        comb(n, k, depth + 1)
        result.removeLast()
    }
}