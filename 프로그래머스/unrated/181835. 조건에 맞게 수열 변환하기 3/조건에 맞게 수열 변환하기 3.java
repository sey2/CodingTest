import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int k) {
        return (k % 2 == 0) ?
                Arrays.stream(arr)
                        .map(it -> it + k)
                        .toArray():
                Arrays.stream(arr)
                        .map(it -> it * k)
                        .toArray();
    }
}