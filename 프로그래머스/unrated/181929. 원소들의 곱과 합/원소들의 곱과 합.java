import java.util.*;

class Solution {
    public int solution(int[] num_list) {
        int sum = Arrays.stream(num_list).sum();
        int a = Arrays.stream(num_list).reduce(1, (num1, num2) -> num1 * num2);

        return (sum * sum) > a ? 1 : 0;
    }
}