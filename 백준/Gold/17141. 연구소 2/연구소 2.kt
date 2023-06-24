import java.util.*
import kotlin.collections.ArrayList

var n = 0;
var m = 0;
lateinit var virus: ArrayList<Pos>
lateinit var arr: Array<Array<String>>
lateinit var visited: Array<Boolean>

val dy = intArrayOf(-1, 1, 0, 0)
val dx = intArrayOf(0, 0, -1, 1)

var max = Integer.MAX_VALUE
var ans = Integer.MAX_VALUE

fun main(args: Array<String>){
    var br = System.`in`.bufferedReader()

    var input = br.readLine().split(" ").map{it.toInt()}

    n = input[0];
    m = input[1];

    arr = Array(n){Array(n){"."}}
    virus = ArrayList<Pos>()

    repeat(n){i ->
        var inArr = br.readLine().split(" ")
        repeat(n) {j ->
            arr[i][j] = inArr[j]

            if(arr[i][j] == "2") {
                virus.add(Pos(i, j))
                arr[i][j] = "0"
            }

        }
    }

    visited = Array(virus.size){false}

    dfs(0, m)

    if(ans == Integer.MAX_VALUE){
        println("-1")
    }else{
        println(ans-1)
    }
}

fun dfs(start: Int, depth: Int){
    if(depth == 0){
        bfs()
        ans = max.coerceAtMost(ans)
        return;
    }

    for(i in start until virus.size){
        if(!visited[i]){
            visited[i] = true
            dfs(i+1, depth-1)
            visited[i] = false
        }
    }
}

fun bfs(){
    var q: Queue<Pos> = LinkedList<Pos>()

    var copy = arr.copyOf()
    var time = Array(n){Array(n){0}}

    for((i, v) in visited.withIndex()){
        if(v){
            val y = virus[i].y
            val x = virus[i].x

            arr[y][x] = "0"
            time[y][x] = 1
            q.add(virus[i])
        }
    }

    max = 0

    while(!q.isEmpty()){
        val cur = q.poll();

        max = max.coerceAtLeast(time[cur.y][cur.x])

        repeat(4){i ->
            var ny = cur.y + dy[i]
            var nx = cur.x + dx[i]

            if(check(ny, nx, copy, time)){
                time[ny][nx] += time[cur.y][cur.x] + 1
                q.add(Pos(ny,nx))
            }

        }
    }

    repeat(n){i->
        repeat(n){j ->
            if(copy[i][j] == "0" && time[i][j] == 0){
                max = Integer.MAX_VALUE
                return
            }
        }
    }

}

fun check(ny: Int, nx: Int, copy: Array<Array<String>>, time: Array<Array<Int>>)
        = (ny in 0 until n) && (nx in 0 until n) && copy[ny][nx] == "0" && time[ny][nx] == 0


data class Pos(val y: Int, val x: Int)

