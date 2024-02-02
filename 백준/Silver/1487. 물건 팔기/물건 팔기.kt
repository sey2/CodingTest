import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val p = Array(n) { IntArray(2) }

    for (i in 0 until n) {
        val input = br.readLine().split(" ").map { it.toInt() }
        p[i][0] = input[0]
        p[i][1] = input[1]
    }

    var max = 0
    var v = 0

    for (i in 0 until n) {
        val standard = p[i][0]
        var gain = 0
        for (j in 0 until n) {
            if (p[j][0] >= standard && standard - p[j][1] >= 0)
                gain += (standard - p[j][1])
        }

        if (max < gain || (max == gain && v > standard)) {
            max = gain
            v = standard
        }
    }

    println(v)
}
