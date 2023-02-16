import java.util.HashSet;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {};

        int people[] = new int[n+1];

        HashSet<String> set = new HashSet<>();

        char prev = words[0].charAt(0);

        int turnNum = 1;
        for(int i=0; i<words.length; i++){

            if(set.contains(words[i]) || prev != words[i].charAt(0))
                return new int[]{turnNum, people[turnNum]+1};
            else{
                set.add(words[i]);
                prev = words[i].charAt(words[i].length()-1);
                people[turnNum]++;
                turnNum = (turnNum+1 > n ) ? 1 : turnNum+1;
            }

        }

        return new int[]{0,0};
    }
}

