import java.util.*
import kotlin.collections.ArrayList

var studentList = ArrayList<Pos>()
lateinit var arr: Array<Array<String>>
var n: Int = 0

val dx = intArrayOf(0, 0, -1, 1)
val dy = intArrayOf(-1, 1, 0, 0)

fun main(args: Array<String>){
    var br = System.`in`.bufferedReader()

    n = br.readLine().toInt()

    arr = Array<Array<String>>(n){Array<String>(n){i -> "."} }

    repeat(n){i ->
        val input = br.readLine().split(" ")
        repeat(n) {j ->
            arr[i][j] = input[j]

            if(arr[i][j] == "S")
                studentList.add(Pos(i,j))
        }
    }

    dfs(0)

    println("NO")
}

fun dfs(wall: Int){
    if(wall == 3){
        bfs()
        return
    }

    repeat(n){i ->
        repeat(n){j ->
            if(arr[i][j] == "X"){
                arr[i][j] = "O"
                dfs(wall + 1)
                arr[i][j] = "X"
            }
        }
    }
}

fun bfs() {
    var q: Queue<Pos> = LinkedList<Pos>()
    var copyArr = arr.copyOf()
    var check = Array(n) { Array(n) { false } }

    repeat(n){i ->
        repeat(n){j ->
            if(copyArr[i][j] == "T"){
                q.add(Pos(i,j))
                check[i][j] = true
            }
        }
    }

    while(!q.isEmpty()){
        val cur = q.poll()

        repeat(4){i->
            var nx = cur.x + dx[i]
            var ny = cur.y + dy[i]

            while(check(ny,nx)){
                if(copyArr[ny][nx] != "O"){
                    check[ny][nx] = true
                    nx += dx[i]
                    ny += dy[i]
                }else
                    break
            }
        }
    }

    if(findStudent(check)){
        println("YES")
        System.exit(0)
    }

}

fun check(ny: Int, nx: Int) = (nx in 0 until n ) && (ny in 0 until n)

fun findStudent(check: Array<Array<Boolean>>):Boolean{
    for(node in studentList){
        if(check[node.y][node.x]){
            return false
        }
    }

    return true
}


class Pos(var y: Int, var x: Int)


