import java.util.LinkedList
import java.util.Queue

lateinit var parent: IntArray
lateinit var arr: ArrayList<Pair<Int, Boolean>>
lateinit var graph: ArrayList<Triple<Int, Int, Int>>

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    parent = IntArray(n+1) { it }
    graph = arrayListOf()

    arr = arrayListOf()
    val input = br.readLine().split(" ")

    arr.apply {
        add(Pair(0, false))
        repeat(n) {index ->
            arr.add(Pair(index + 1, input[index] == "M"))
        }
    }

    repeat(m) {
        val (a, b, c) = br.readLine().split(" ").map{ it.toInt() }
        graph.add(Triple(a, b, c))
    }

    graph.sortBy { it.third }

    kruskal(n)
}

fun kruskal(n: Int) {
    var cost = 0
    var cnt = 0

    for(i in 0 until graph.size) {
        val rootA = find(graph[i].first)
        val rootB = find(graph[i].second)

        if(rootA != rootB && arr[graph[i].first].second != arr[graph[i].second].second) {
            cnt ++
            cost += graph[i].third
            union(graph[i].first, graph[i].second)
        }
    }

    if(cnt < n-1) print("-1") else print(cost)
}

fun union(a: Int, b: Int) {
    val x = find(a)
    val y = find(b)

    if(x < y) parent[y] = x
    else parent[x] = y
}

fun find(x: Int): Int {
    return if(parent[x] == x) x
    else find(parent[x])
}
