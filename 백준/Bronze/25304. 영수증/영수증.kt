fun main(){
    var br = System.`in`.bufferedReader()

    val totalPrice = br.readLine().toInt()
    val n = br.readLine().toInt()
    var purchasePrice = 0

    repeat(n) {
        val input = br.readLine().split(" ").map{ it.toInt() }

        purchasePrice += input[0] * input[1]
    }

    println(if(purchasePrice == totalPrice) "Yes" else "No")
}