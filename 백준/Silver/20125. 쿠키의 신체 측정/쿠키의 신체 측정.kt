fun main() {
    val br = System.`in`.bufferedReader()
    var n = br.readLine().toInt()

    val arr = Array(n) { CharArray(n) }

    var head = Pair(0,0)
    var first = true
    for(i in 0 until n) {
        val input = br.readLine()

        for(j in 0 until n) {
            arr[i][j] = input[j]

            if(arr[i][j] == '*' && first){
                head = Pair(i+1, j)
                first = false
            }
        }
    }

    println("${head.first+1} ${head.second+1}")

    var waist = 0
    var lastWaist = 0
    for(i in head.first+1 until n)
        if(arr[i][head.second] == '*') {
            waist++
            lastWaist = i
        }

    var leftArm = 0
    for(i in 0 until head.second)
        if(arr[head.first][i] == '*') leftArm++

    var rightArm = 0
    for(i in head.second+1 until n)
        if(arr[head.first][i] == '*') rightArm++

    var leftLeg = 0
    for(i in lastWaist+1 until n)
        if(arr[i][head.second-1] == '*') leftLeg++

    var rightLeg = 0
    for(i in lastWaist+1 until n)
        if(arr[i][head.second+1] == '*') rightLeg++

    print("$leftArm $rightArm $waist $leftLeg $rightLeg")

}