class Solution {
    fun solution(spell: Array<String>, dic: Array<String>): Int {
        var ans: Int = 2

        var regx = spell.joinToString().replace(",| ".toRegex(), "").toCharArray()
                    .apply{sort()}.joinToString("")
        
        for(i in dic.indices){
            var str = dic[i].toCharArray().apply{sort()}.joinToString("")

            if(str.contains(regx))
                return 1
        }
        
        return ans

    }
}