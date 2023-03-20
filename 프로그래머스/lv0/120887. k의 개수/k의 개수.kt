class Solution {
    fun solution(i: Int, j: Int, k: Int) = (i .. j).toList()
                                            .map{it -> it.toString().toCharArray()}.
                                            let{
                                                var cnt = 0
                                                val cmp = k.toString()
                                                for(i in it){
                                                    for(j in i)
                                                        cnt += if(j.toString() == cmp) 1 else 0
                                                }
                                                cnt
                                            }
}
