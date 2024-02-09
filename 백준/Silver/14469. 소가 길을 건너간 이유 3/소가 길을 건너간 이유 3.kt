fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val list = mutableListOf<Pair<Int, Int>>()

    repeat(n) {
        val (arrive, time) = readLine().split(" ").map { it.toInt() }
        list.add(Pair(arrive, time))
    }

    val sorted = list.sortedBy { it.first }

    var cur = 0
    for(i in 0 until sorted.size) {
        if(cur < sorted[i].first)
            cur = sorted[i].first + sorted[i].second
        else
            cur += sorted[i].second
    }
    println(cur)
}
