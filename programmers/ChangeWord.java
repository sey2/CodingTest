import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean visited[] = new boolean[words.length];
        Queue<Word> q = new LinkedList<>();
        q.add(new Word(begin, 0));
        
        while(!q.isEmpty()){
            Word cur = q.poll();

            if(target.equals(cur.str)) return cur.depth;
            
            for(int i=0; i<words.length; i++){
                if(!visited[i] && convertible(cur.str, words[i])){
                    q.add(new Word(words[i], cur.depth + 1));
                    visited[i] = true;
                }
                
            }
            
        }
        
        return 0;
    }
    
    public boolean convertible(String str1, String str2){
        int diff = 0;
        for(int i=0; i<str1.length(); i++){
            if(str1.charAt(i) != str2.charAt(i)) diff ++;
        }
        
        if(diff == 1) return true;
        else return false;
    }
}

class Word{
    String str;
    int depth;
    
    public Word(String str, int depth){
        this.str = str;
        this.depth = depth;
    }
}
