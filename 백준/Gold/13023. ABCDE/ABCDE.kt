
class Main{
    lateinit var graph: Array<ArrayList<Int>>
    var result = false

    fun solution(): Int{
        val br = System.`in`.bufferedReader()

        val (n, m) = br.readLine().split(" ").map { it.toInt() }
        graph = Array(n) { ArrayList() }

        repeat(m){
            val (a, b) = br.readLine().split(" ").map{it.toInt()}

            graph[a].add(b)
            graph[b].add(a)
        }

        for(i in 0 until n){
            dfs(i, 0, BooleanArray(n){it == i} )

            if(result) return 1

        }

        return 0
    }

    fun dfs(cur: Int, depth: Int, visited: BooleanArray){
        if(depth == 4) {
            result = true
            return
        }

        for(next in graph.get(cur)){
            if(!visited[next]){
                visited[next] = true
                dfs(next, depth + 1, visited)
                visited[next] = false
            }
        }

    }
}

fun main(args: Array<String>){
    println(Main().solution())
}


