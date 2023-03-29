var n = 0
var ans = Integer.MAX_VALUE

lateinit var arr: Array<Array<Int>>
lateinit var visited: Array<Boolean>


fun main(args: Array<String>) {
    var br = System.`in`.bufferedReader()

    n = br.readLine().toInt()
    arr = Array(n){Array(n){0}}

    repeat(n){i ->
        val input = br.readLine().split(" ").map{it.toInt()}
        repeat(n){j->
            arr[i][j] = input[j]
        }
    }

    repeat(n){i ->
        visited = Array(n){false}
        visited[i] = true
        dfs( i,i, 0)
    }

    println(ans)
}

fun dfs(start: Int, cur: Int, cost: Int){
    if(visited.all { it } && arr[cur][start]!=0){
        ans = Math.min(ans, cost + arr[cur][start])
        return
    }


    repeat(n){i ->
        if(!visited[i]&& arr[cur][i] != 0){
            visited[i] = true
            dfs( start, i,cost + arr[cur][i])
            visited[i] = false
        }

    }
}