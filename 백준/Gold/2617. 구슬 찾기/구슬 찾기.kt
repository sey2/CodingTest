import java.util.PriorityQueue

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map{ it.toInt() }

    val arr = Array(n+1) { IntArray(n+1) }

    for(i in 0 .. n) {
        for(j in 0 .. n) {
            arr[i][j] = if(i == j) 0 else Int.MAX_VALUE
        }
    }

    repeat(m) {
        val input = br.readLine().split(" ").map {it.toInt()}
        arr[input[1]][input[0]] = 1
    }

    for(k in 1 .. n) {
        for(i in 1 .. n) {
            for(j in 1 .. n) {
                if(arr[i][k] == 1 && arr[k][j] == 1) {
                    arr[i][j] = 1
                }
            }
        }
    }

    var ans = 0
    for(i in 1 .. n) {
        var havy = 0
        var light = 0

        for(j in 1 .. n) {
            havy += if(arr[i][j] == 1) 1 else 0
            light += if(arr[j][i] == 1) 1 else 0
        }
        ans += if(havy > n/2 || light > n/2) 1 else 0
    }

    println(ans)

}



