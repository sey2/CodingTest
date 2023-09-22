import java.util.PriorityQueue

fun main() {
    var br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val pq = PriorityQueue<Pos>()

    repeat(n) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        pq.add(Pos(a, b))
    }

    while(!pq.isEmpty()) {
        val cur = pq.poll()
        println("${cur.x} ${cur.y}")
    }
}

data class Pos(val x: Int, val y: Int): Comparable<Pos> {
    override fun compareTo(other: Pos): Int {
        if(this.x == other.x) return this.y - other.y
        else return this.x - other.x
    }

}