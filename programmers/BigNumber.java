
import java.util.Arrays;
class Solution {
    public String solution(int[] numbers) {
        String str[] = new String[numbers.length];

        for(int i=0; i< numbers.length; i++)
            str[i] = String.valueOf(numbers[i]);

        Arrays.sort(str, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        StringBuilder sb = new StringBuilder("");

        for(var st : str) sb.append(st);
        
        return (str[0].equals("0")) ? "0" : sb.toString();
    }
}