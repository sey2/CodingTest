import java.util.stream.IntStream;

class Solution {
    public String[] solution(String[] strArr) {;
        return IntStream.range(0, strArr.length)
                .mapToObj((index) -> index % 2 == 0 ? strArr[index].toLowerCase() : strArr[index].toUpperCase())
                .toArray(String[] :: new);
    }
}