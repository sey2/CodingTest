class Solution {
    companion object {
        const val EXIST = 1
        const val NO_EXIST = 0
    }
    
    fun solution(myString: String, pat: String): Int 
         = if(myString.toLowerCase().indexOf(pat.toLowerCase()) >=0) 
                EXIST else NO_EXIST
}