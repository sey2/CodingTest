class Solution {
    fun solution(num_list: IntArray): IntArray =
        let{
            var num1 = num_list.count{it%2==0}
            var num2 = num_list.count{it%2!=0}
            intArrayOf(num1,num2)
        }
        
}