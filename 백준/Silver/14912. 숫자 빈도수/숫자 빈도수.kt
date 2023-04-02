
fun main(args: Array<String>) {
    var br = System.`in`.bufferedReader()
    val input = br.readLine().split(" ").map{it.toInt()}

    var arr = Array(input[0]){it+1}
    var cnt = 0

    for(i in 0 until arr.size){
        val cur = arr[i].toString().toCharArray()
        for(j in 0 until cur.size){
            if(cur[j] - '0' == input[1])
                cnt ++
        }
    }

    println(cnt)
    
}
