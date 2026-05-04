fun main() {
    val n = readLine()!!.toInt()

    val segments = List(n) {
        val (l, r) = readln().split(" ").map { it.toInt() }
        Pair(l, r)
    }

    val sorted = segments.sortedWith(
        compareBy<Pair<Int, Int>> { it.second }
            .thenByDescending { it.first }
    )

    var ans = 1
    var lastEnd = sorted[0].second

    for (i in 1 until sorted.size) {
        if (lastEnd < sorted[i].first) {
            ans++
            lastEnd = sorted[i].second
        }
    }

    println(ans)
}