import java.util.*
import kotlin.collections.ArrayList

var n = 0
var m = 0
lateinit var arr: Array<Array<Int>>
var chicken = ArrayList<Pos>()
var house = ArrayList<Pos>()
var ans = Integer.MAX_VALUE

fun main(args: Array<String>){
    var br = System.`in`.bufferedReader()

    var input = br.readLine().split(" ").map{it.toInt()};

    n = input[0]
    m = input[1]

    arr = Array(n){Array(n){0}}

    repeat(n){i ->
        input = br.readLine().split(" ").map{it.toInt()}

        repeat(n){j ->
            arr[i][j] = input[j]

            if(arr[i][j] == 2)
                chicken.add(Pos(i, j))
            else if(arr[i][j] == 1)
                house.add(Pos(i,j))
        }
    }

    combination(0, m, Array(chicken.size){false})

    println(ans)

}

fun combination(start: Int, r: Int,visited: Array<Boolean>){
    if(r == 0){
        var cost = 0

        for(i in 0 until house.size) {
            var min = Integer.MAX_VALUE
            var curHouse = house[i]

            // 현재 집에서 가장 가까운 치킨 집 거리 구하기
            for (j in 0 until chicken.size) {
                if (visited[j]) {
                    var curCost = Math.abs(curHouse.x - chicken[j].x) + Math.abs(curHouse.y - chicken[j].y)
                    min = Math.min(curCost, min)
                }
            }
            cost += min
        }

        ans = Math.min(cost, ans)

        return
    }

    for(i in start until chicken.size){
        if(!visited[i]){
            visited[i] = true
            combination(i+1, r-1, visited)
            visited[i] = false
        }
    }
}



data class Pos(val y:Int, val x:Int)




