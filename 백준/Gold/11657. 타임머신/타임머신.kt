import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

data class Edge(val from: Int, val to: Int, val time: Long)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringTokenizer(br.readLine(), " ")

    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()

    val times = LongArray(N + 1) { Long.MAX_VALUE }
    times[1] = 0

    val isCycle = bellmanFord(times, N, M, br)

    val bw = System.out.bufferedWriter()
    if (isCycle) {
        bw.write("-1\n")
    } else {
        for (i in 2 until times.size) {
            if (times[i] == Long.MAX_VALUE) {
                bw.write("-1\n")
            } else {
                bw.write("${times[i]}\n")
            }
        }
    }

    bw.flush()
    bw.close()
    br.close()
}

fun bellmanFord(times: LongArray, N: Int, M: Int, br: BufferedReader): Boolean {
    var isMinusCycle = false

    val eg = Array<Edge>(M) {
        val st = StringTokenizer(br.readLine(), " ")
        val from = st.nextToken().toInt()
        val to = st.nextToken().toInt()
        val time = st.nextToken().toLong()
        Edge(from, to, time)
    }

    for (i in 0 until N + 1) {
        for (j in 0 until M) {
            val cur = eg[j]

            if (times[cur.from] == Long.MAX_VALUE) {
                continue
            }

            if (times[cur.to] > times[cur.from] + cur.time) {
                times[cur.to] = times[cur.from] + cur.time

                if (i == N) {
                    isMinusCycle = true
                    break
                }
            }
        }
    }

    return isMinusCycle
}
