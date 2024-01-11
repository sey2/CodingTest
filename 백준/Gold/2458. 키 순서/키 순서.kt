import kotlin.math.max

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val dist = Array(n + 1) { IntArray(n + 1) }

    for (i in 1..n)
        for (j in 1..n)
            dist[i][j] = if (i == j) 0 else Int.MAX_VALUE


    repeat(m) {
        val input = br.readLine().split(" ").map { it.toInt() }
        val a = input[0]
        val b = input[1]
        dist[a][b] = 1
    }

    for(k in 1 .. n) {
        for(i in 1 .. n) {
            for(j in 1 .. n) {
                if(dist[i][k] == 1 && dist[k][j] == 1) {
                    dist[i][j] = 1
                }
            }
        }
    }

    var ans = 0
    for(i in 1 .. n) {
        var cnt = 0
        for(j in 1 .. n) {
            cnt += if(dist[i][j] == 1 || dist[j][i] == 1) 1 else 0
        }
        ans += if(cnt == n-1) 1 else 0
    }

    println(ans)

}