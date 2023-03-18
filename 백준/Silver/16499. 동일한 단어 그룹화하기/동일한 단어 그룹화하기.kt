import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    var set = mutableSetOf<String>()

    for(i in 0 until n)
        set.add(br.readLine()!!.toCharArray().sorted().toString())

    println(set.size)
}
