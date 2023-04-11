fun main(args: Array<String>){
    var br = System.`in`.bufferedReader()

    var n = br.readLine().toInt()

    if(n < 100){
        println(n);
        return
    }else{
        var ans = 99

        for(i in 100 .. n ){
            var a = i / 100
            var b = (i/10) % 10
            var c = i % 10

            if((a - b) == (b - c))
                ans ++
        }

        println(ans)
    }

}


