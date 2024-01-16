import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, c) = br.readLine().split(" ").map { it.toInt() }
    val map: LinkedHashMap<Int, Int> = linkedMapOf()

    val input = br.readLine().split(" ").map { it.toInt() }
    repeat(n) {
        map[input[it]] = map.getOrDefault(input[it], 0) + 1
    }

    val value = map.toList().sortedByDescending { it.second }.toMap()

    for (key in value.keys) {
        for(j in 0 until map[key]!!) {
            print("$key ")
        }
    }
}