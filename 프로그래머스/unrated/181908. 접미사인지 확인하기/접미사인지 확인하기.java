import java.util.stream.IntStream;
import java.util.stream.Collectors;

class Solution {
    public int solution(String my_string, String is_suffix) {
        return  (IntStream.range(0, my_string.length()).
                mapToObj(i -> my_string.substring(i, my_string.length()))
                .collect(Collectors.toSet())
                .contains(is_suffix) == true) ? 1 : 0;
    }
}