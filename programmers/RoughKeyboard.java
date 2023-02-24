import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        int [] key = new int[26];
        
        Arrays.fill(key, 9999);
        
        for(int i=0; i<keymap.length; i++){
            String str = keymap[i];
            
            for(int j=0; j<keymap[i].length(); j++){
                key[str.charAt(j) - 'A'] = Math.min(key[str.charAt(j) - 'A'], j+1);
            }
        }
                
        
        loop:
        for(int i=0; i<targets.length; i++){               
            int sum = 0;
            
            for(int j=0; j<targets[i].length(); j++){
                char c = targets[i].charAt(j);
                if(key[c - 'A'] == 9999){
                    answer[i] = -1;
                    continue loop;
                }else{
                    sum+= key[c - 'A'] ;
                }
            }
            
            answer[i] = sum;
        }
        return answer;
    }
}
