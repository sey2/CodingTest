import java.io.BufferedReader
import java.util.PriorityQueue

lateinit var graph: ArrayList<ArrayList<Node>>
lateinit var dist: IntArray
lateinit var queue: PriorityQueue<Node>
lateinit var visited: BooleanArray
var total = 0
const val INF = 100_000_000

fun main() {
   var br = System.`in`.bufferedReader()
   var t = br.readLine().toInt()

    repeat(t){
        var (n, d, c) = br.readLine().split(" ").map{it -> it.toInt()}

        graph = ArrayList()
        for (i in 0 .. n) graph.add(ArrayList())

        dist = IntArray(n+1) {INF}
        queue = PriorityQueue()

        for(i in 0 until d){
            var (a, b, s) = br.readLine().split(" ").map{it -> it.toInt()}

            graph[b].add(Node(a, s))
            // graph[b].add(Node(a, s))
        }

        visited = BooleanArray(n+1)

        total = 0
        dijkstra(c)

        var time = 0
        dist.forEach{ cost ->
            if(cost != INF) {
                time = time.coerceAtLeast(cost)
                total++
            }
        }

        println("$total $time")

    } // repeat end
}

fun dijkstra(start: Int){
    dist[start] = 0

    queue.add(Node(start, 0))

    while(!queue.isEmpty()){
        val cur = queue.poll()

        if(dist[cur.index] < cur.cost) continue

        for(i in 0 until  graph[cur.index].size){
            val nextIdx = graph[cur.index][i].index
            val nextCost = graph[cur.index][i].cost + cur.cost

            if(dist[nextIdx] > nextCost){
                dist[nextIdx] = nextCost
                queue.add(Node(nextIdx, nextCost))
            }
        } // for loop end
    } // while loop end
}   // function end

data class Node(val index:Int , val cost: Int):
        Comparable<Node>{
            override fun compareTo(other: Node) = cost - other.cost
        }


