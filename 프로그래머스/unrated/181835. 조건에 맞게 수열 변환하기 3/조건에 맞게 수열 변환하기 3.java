import java.util.Arrays;

class Solution {
    public Object[] solution(int[] arr, int k) {
        return (k % 2 == 0) ?
                Arrays.stream(arr)
                        .mapToObj(it -> it + k)
                        .toArray():
                Arrays.stream(arr)
                        .mapToObj(it -> it * k)
                        .toArray();
    }
}