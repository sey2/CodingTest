class Solution {
    fun solution(array: IntArray, n: Int): Int {
        var answer: Int = 9999999
        
        var list = mutableListOf<Int>()
        
        for(i in 0 .. array.size-1){
             if (Math.abs(array[i] - n) < answer){ 
                 list.clear()
                 answer = Math.abs(array[i] - n)
                 list.add(array[i])
             }else if(Math.abs(array[i] - n) == answer)
                list.add(array[i])
            
        }
        
        list.sort()
        
        return list.get(0)
    }
}