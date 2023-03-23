fun main(args: Array<String>){
    var br = System.`in`.bufferedReader()

    val n = br.readLine().toInt()

    var dp = Array(n+1){IntArray(101)}

    val w = IntArray(n+1)
    val v = IntArray(n+1)

    var input = br.readLine().split(" ").map{it.toInt()}
    repeat(n){ i ->  w[i+1] = input[i] }

    input = br.readLine().split(" ").map{it.toInt()}
    repeat(n){ i -> v[i+1] = input[i] }

    // KnapSack Algorithm
    for(i in 1 .. n){
        for(j in 1 .. 100){
            if(w[i] <= j)
                dp[i][j] = Math.max(dp[i-1][j-w[i]] + v[i], dp[i-1][j])
            else
                dp[i][j] = dp[i-1][j];
        }
    }

    println("${dp[n][99]}")

}


