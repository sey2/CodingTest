import java.util.stream.Collectors;

class Solution {
    public String solution(String my_string, String alp) {
        return my_string
                .chars()
                .mapToObj(ch -> ch == alp.charAt(0) ? Character.toUpperCase((char)ch) : (char)ch)
                .map(Object::toString)
                .collect(Collectors.joining());
    }
}