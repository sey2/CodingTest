class Solution {
    fun solution(myString: String): Array<String> 
        = myString.split("x").filterNot { it == "" }.sorted().toTypedArray()


}