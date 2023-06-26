import java.util.stream.IntStream;

class Solution {
    public int solution(int n, String control) {
        return IntStream.range(0, control.length())
                .reduce(n, (num, i) -> {
                    char ch = control.charAt(i);
                    if (ch == 'w') return num + 1;
                    if (ch == 's') return num - 1;
                    if (ch == 'd') return num + 10;
                    if (ch == 'a') return num - 10;
                    return num;
                });
    }
}