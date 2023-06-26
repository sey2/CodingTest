import java.util.stream.IntStream;

class Solution {
    public int[] solution(int start, int end) {
        return IntStream.rangeClosed(end, start)
                .map(i -> start + (end - i)).toArray();
    }
}