import java.util.*;

class Solution {
    int arr[];
    boolean visited[];

    HashSet<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {        
        arr = new int[numbers.length()];
        visited = new boolean[arr.length];
        
        for(int i=0; i<numbers.length(); i++)
            arr[i] = numbers.charAt(i) - '0';
        
        for(int i=1; i<=arr.length; i++)
            permutation(new int[i], 0, i);
        
        
        return set.size();
    }
    
    public void permutation(int out[], int depth, int r){
        if(depth == r){
            StringBuilder sb = new StringBuilder("");
            
            for(int i=0; i<out.length; i++)
                sb.append(out[i]);
            
            int number = Integer.parseInt(sb.toString());
            
            if(isPrime(number))
                set.add(number);
            
            return;
        }
        
        for(int i=0; i<arr.length; i++){
            if(!visited[i]){
                visited[i] = true;
                out[depth] = arr[i];
                permutation(out, depth + 1, r);
                visited[i] = false;
            }
        }
    }
    
    public boolean isPrime(int number) {        
        for (int i = 2; i <= number; i++) {
            if (i != number && number % i == 0)
                return false;
        }
        
        if (number <= 1) return false;
        return true;
    }
}
