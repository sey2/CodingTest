import java.util.*
import kotlin.collections.ArrayList

class Solution {
    private val list: ArrayList<ArrayList<Node>> = arrayListOf()
    private lateinit var cost: IntArray

    fun solution(n: Int, road: Array<IntArray>, k: Int): Int {
        var answer = 0
        cost  = IntArray(n+1) {Integer.MAX_VALUE}

        for(i in 0 .. n)
            list.add(arrayListOf())

        for(i in 1 .. road.size) {
            list[road[i-1][0]].add(Node(road[i-1][1], road[i-1][2]))
            list[road[i-1][1]].add(Node(road[i-1][0], road[i-1][2]))
        }

        dijkstra();

        for(c in cost){
            if(c <= k) answer ++;
        }

        return answer
    }

    private fun dijkstra() {
        val pq: PriorityQueue<Node> = PriorityQueue()
        pq.add(Node(1, 0))
        cost[1] = 0

        while(!pq.isEmpty()){
            val cur = pq.poll();

            if(cost[cur.v] < cur.cost) continue

            for(i in 0 until list[cur.v].size){
                val v2 = list[cur.v][i].v;
                val cost2 = list[cur.v][i].cost + cur.cost;

                if(cost[v2] > cost2){
                    cost[v2] = cost2;
                    pq.add(Node(v2, cost2));
                }
            }
        }
    }
}

class Node(var v: Int, var cost: Int): Comparable<Node> {
    override fun compareTo(other: Node): Int {
        return this.cost - other.cost
    }
}
