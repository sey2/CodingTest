fun main() {
    val br = System.`in`.bufferedReader()
    var (n, m, k) = br.readLine().split(" ").map{ it.toInt() }

    val cinema = Array(n) { IntArray(m) }

    for(i in 0 until n) {
        val input = br.readLine()
        for(j in 0 until m) {
            cinema[i][j] = input[j].digitToInt()
        }
    }

    var ans = 0
    for(i in 0 until n) {
        var count = 0
        for(j in 0 until m) {
            if(cinema[i][j] == 0) count ++
            else count = 0
            if(count >= k) ans ++
        }
    }
    println(ans)

}