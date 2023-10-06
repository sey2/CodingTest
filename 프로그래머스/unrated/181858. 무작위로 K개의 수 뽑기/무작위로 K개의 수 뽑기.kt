class Solution {
    fun solution(arr: IntArray, k: Int): IntArray
        = run {
            val list = IntArray(k) { -1 }
            var index = 0

            arr.forEach {
                if(index >= k) return@forEach
                if(!list.contains(it)) list[index++] = it
            }

            list
        }
}
