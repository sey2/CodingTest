import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.HashSet
import java.util.StringTokenizer

class Main{
    lateinit var visited: BooleanArray
    var set = HashSet<Int>()
    var n: Int = 0
    var list = mutableListOf<Int>()

    fun solution(): Int{
        val br = BufferedReader(InputStreamReader(System.`in`))
        n = br.readLine().toInt()

        val st = StringTokenizer(br.readLine())

        list.add(0)
        for(i in 0 .. n-1)
            list.add(st.nextToken().toInt())

        val start = br.readLine().toInt()

        visited = BooleanArray(n+1)

        dfs(start)
        return set.size
    }

    fun dfs(cur: Int){
        if(cur < 1 || cur > n)
            return

        set.add(cur)

        dfs(cur + list.get(cur))
        dfs(cur - list.get(cur))

    }
}

fun main(args: Array<String>){
    println(Main().solution())
}


