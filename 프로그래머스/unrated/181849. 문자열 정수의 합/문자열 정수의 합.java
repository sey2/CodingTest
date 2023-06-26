import java.util.stream.IntStream;

class Solution {
    public int solution(String num_str) {
        return IntStream.range(0, num_str.length())
                .mapToObj(i -> num_str.charAt(i) - '0')
                .reduce(0, (a,b) -> a+b);
    }
}