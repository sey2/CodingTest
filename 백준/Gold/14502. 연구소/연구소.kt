import java.util.*
import kotlin.collections.ArrayList

var n = 0
var m = 0

var list = ArrayList<Pos>()     // 바이러스 위치
val dy = intArrayOf(-1, 1, 0, 0)
val dx = intArrayOf(0, 0, -1, 1)

var ans = Integer.MIN_VALUE
lateinit var arr: Array<Array<Int>>

fun main(args: Array<String>){
    var br = System.`in`.bufferedReader()

    var input = br.readLine().split(" ").map{it.toInt()}

    n = input[0]
    m = input[1]

    arr = Array(n){Array(m){0}}

    repeat(n){i -> n
        input = br.readLine().split(" ").map{it.toInt()}

        repeat(m){j ->
            arr[i][j] = input[j]

            if(arr[i][j] == 2)
                list.add(Pos(i,j))
        }
    }

    backtracking(3)

    println(ans)
}

fun backtracking(r: Int){
    if(r == 0){
        bfs()

        return
    }

    for(i in 0 until n){
        for(j in 0 until m) {
            if (arr[i][j] == 0) {
                arr[i][j] = 1
                backtracking( r - 1)
                arr[i][j] = 0
            }
        }
    }
}

fun bfs(){
    var q: Queue<Pos> = LinkedList<Pos>()

    repeat(list.size){ q.add(list[it]) }

    var clone = arr.map{it.clone()}.toTypedArray()

    while(!q.isEmpty()){
        val cur = q.poll()

        repeat(4){ i->
            val ny = dy[i] + cur.y
            val nx = dx[i] + cur.x

            if(checkRange(ny,nx, clone)){
                q.add(Pos(ny,nx))
                clone[ny][nx] = 1
            }
        }
    }
    checkSafeZone(clone)
}

fun checkSafeZone(clone: Array<Array<Int>>){
    var cnt = 0
    repeat(n){i ->
        repeat(m){ j->
            if(clone[i][j] == 0)
               cnt ++
        }
    }
    ans = Math.max(cnt, ans)
}

fun checkRange(ny: Int, nx: Int, clone: Array<Array<Int>>)
    = (ny in 0 until n) && (nx in 0 until m) && clone[ny][nx] == 0

data class Pos(val y: Int, val x: Int)

