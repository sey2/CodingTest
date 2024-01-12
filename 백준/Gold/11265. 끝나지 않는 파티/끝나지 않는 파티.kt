import kotlin.math.min

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map{ it.toInt() }
    val arr = Array(n+1) { IntArray(n+1) }

    for(i in 0 until n) {
        val input = br.readLine().split(" ").map{ it.toInt() }
        for(j in 0 until n) {
            arr[i+1][j+1] = input[j]
        }
    }
    
    for(k in 1 .. n) {
        for(i in 1 .. n) {
            for(j in 1 .. n) {
                arr[i][j] = min(arr[i][k] + arr[k][j], arr[i][j])
            }
        }
    }

    repeat(m) {
        val input = br.readLine().split(" ").map{ it.toInt() }
        println(
            if(arr[input[0]][input[1]] <= input[2]) "Enjoy other party" else "Stay here"
        )
    }
}
