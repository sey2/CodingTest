import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()

    var arr = br.readLine().split(" ").map { it.toInt() }
    var maxDP = arr
    var minDP = arr

    for (i in 1 until N) {
        arr = br.readLine().split(" ").map { it.toInt() }
        maxDP = listOf(
            arr[0] + maxOf(maxDP[0], maxDP[1]),
            arr[1] + maxOf(maxDP[0], maxDP[1], maxDP[2]),
            arr[2] + maxOf(maxDP[1], maxDP[2])
        )
        minDP = listOf(
            arr[0] + minOf(minDP[0], minDP[1]),
            arr[1] + minOf(minDP[0], minDP[1], minDP[2]),
            arr[2] + minOf(minDP[1], minDP[2])
        )
    }

    println("${maxDP.maxOrNull()} ${minDP.minOrNull()}")
}
