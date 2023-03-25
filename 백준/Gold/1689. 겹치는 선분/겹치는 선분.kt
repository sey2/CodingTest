import java.util.PriorityQueue

fun main(args: Array<String>){
    var br = System.`in`.bufferedReader()

    val n = br.readLine().toInt()

    var arr = Array<Pos>(n) {Pos(0,0)}

    repeat(n){i ->
        val input = br.readLine().split(" ").map{it.toInt()}
        arr[i] = Pos(input[0].toInt(), input[1].toInt())
    }

    arr.sortBy{ it.st }
    var pq = PriorityQueue<Int>()
    pq.add(arr[0].ed)

    var max = 1
    for(i in 1 until arr.size){
        var start = arr[i].st
        var end = arr[i].ed

        while(!pq.isEmpty() && pq.peek() <= start)
            pq.poll()

        pq.add(end)
        max = Math.max(pq.size, max)

    }

    println(max)

}

class Pos(var st: Int, var ed: Int)


