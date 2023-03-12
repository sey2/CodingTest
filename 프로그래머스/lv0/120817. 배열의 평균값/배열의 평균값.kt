class Solution {
    fun solution(numbers: IntArray): Double {        
        var sum : Double = 0.0
        
        for(i in 0..numbers.size-1)
            sum += numbers[i];
        
        print(sum)
        
        return (sum / numbers.size).toDouble()
    }
}