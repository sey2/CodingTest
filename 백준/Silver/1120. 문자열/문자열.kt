import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val input = br.readLine()!!.split(" ")
    val a = input[0]
    val b = input[1]
    var result = a.length

    for(i in 0 .. b.length - a.length){
        var tmp = 0

        for(j in 0 until a.length){
            if(a[j] != b[j+i])
                tmp ++
        }

        result = Math.min(result, tmp)
    }
    bw.write("$result \n")
    bw.close()

}
