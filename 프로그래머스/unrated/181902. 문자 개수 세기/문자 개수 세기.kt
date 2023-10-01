class Solution {
   fun solution(myString: String) = ('A'..'Z').plus('a'..'z').map { char ->
         myString.count { it == char }
    }.toIntArray()

}