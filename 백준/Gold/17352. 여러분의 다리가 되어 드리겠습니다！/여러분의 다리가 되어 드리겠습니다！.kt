var n = 0
lateinit var parent: IntArray

fun main() {
    var br = System.`in`.bufferedReader()
    val bw = System.`out`.bufferedWriter()

    n = br.readLine().toInt()
    parent = IntArray(n+1) { it }

    repeat(n - 2) {
        val input = br.readLine().split(" ").map {it.toInt()}
        union(input[0],input[1])
    }

    val answer = arrayListOf<Int>()

    for(i in 1 .. n) {
        if(parent[i] == i) answer.add(i)
    }

    bw.write("${answer[0]} ${answer[1]}")
    bw.close()
}

fun find(a: Int): Int {
    if (parent[a] == a)
        return a
    parent[a] = find(parent[a])
    return parent[a]
}

fun union(a: Int, b: Int) {
    val x = find(a)
    val y = find(b)

    parent[y] = x
}