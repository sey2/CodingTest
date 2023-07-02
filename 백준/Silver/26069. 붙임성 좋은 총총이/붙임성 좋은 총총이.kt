import java.io.BufferedReader


fun main() {
   var br = System.`in`.bufferedReader()
   var n = br.readLine().toInt()
   var set = HashSet<String>()

   set.add("ChongChong")
   repeat(n){
       val input = br.readLine()!!.split(" ")

       if(set.contains(input[0]) || set.contains(input[1])){
           set.add(input[0])
           set.add(input[1])
       }
   }

    println(set.size)

}


