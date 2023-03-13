class Solution {
    fun solution(price: Int): Int = let{
        var ans: Int = price
        if(price >= 500000)
            ans = (price * 0.80).toInt()
        else if(price >= 300000)
            ans = (price * 0.90).toInt()
        else if(price >= 100000)
            ans = (price * 0.95).toInt()
        ans
    }
}