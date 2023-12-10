import kotlin.math.max

fun main() {
    val br = System.`in`.bufferedReader()

    var t = br.readLine().toInt()

    while(t --> 0) {
       val n = br.readLine().toInt()
       val arr = Array(2) { IntArray(n+1) }
       val dp = Array(2) { IntArray(n+1) }

       for(i in 0 .. 1) {
           val input = br.readLine().split(" ").map { it.toInt() }

           for(j in 1 ..  n) {
                arr[i][j] = input[j-1]
           }
       }

        dp[0][1] = arr[0][1]
        dp[1][1] = arr[1][1]

        for(i in 2 .. n) {
            dp[0][i] = max(dp[1][i-1], dp[1][i-2]) + arr[0][i]
            dp[1][i] = max(dp[0][i-1], dp[0][i-2]) + arr[1][i]
        }

        println(max(dp[0][n], dp[1][n]))
    }
}