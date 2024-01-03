import java.util.regex.Pattern

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    var target = br.readLine()

    val regex = Pattern.compile(target.replace("*", ".*")) 

    repeat(n) {
        val filename = br.readLine()
        if (regex.matcher(filename).matches()) {
            println("DA")  
        } else {
            println("NE")  
        }
    }
}