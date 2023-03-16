class Solution {
   fun solution(cipher: String, code: Int) = cipher.toList().
                                            filterIndexed{index, i -> (index + 1) % code == 0}.
                                            joinToString("")
}