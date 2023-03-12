class Solution {
    fun solution(n: Int): Int {
        var answer: Int = 0
        
        var count: Int = 1
        var i = 0

        while(i < n){
            if(count % 3 == 0)
                count++
            
            var str: String = count.toString()
            
            if(str.contains("3")){
                count++
                continue
            }
            
            if(count >= 24){
                while(check(count))
                    count++
            }
            
            count++
            i++
        }
        
        
        return count-1
    }
    
    fun check(n: Int): Boolean = if (n%3 == 0) true else false
}