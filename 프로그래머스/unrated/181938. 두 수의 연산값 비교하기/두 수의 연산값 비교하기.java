class Solution {
    public int solution(int a, int b) {
        int str = Integer.parseInt(a + "" + b);
        int mul = 2 * a * b;
        return Math.max(str, mul);
    }
}