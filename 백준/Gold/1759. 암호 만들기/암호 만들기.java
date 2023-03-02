import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;


public class Main
{

    static char arr[];
    static boolean visited[];
    static HashSet<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
    static HashSet<String> set = new HashSet<>();
    static int rr, n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input [] = br.readLine().split(" ");
        rr = Integer.parseInt(input[0]);
        n = Integer.parseInt(input[1]);

        arr = br.readLine().replaceAll(" ", "").toCharArray();
        visited = new boolean[n];

        combination(0, rr);

        PriorityQueue<String> pq = new PriorityQueue<>();
        for(String ans : set)
            pq.add(ans);

        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }

    }

    public static void combination(int start, int r){
        if(r == 0){
            PriorityQueue<Character> pq = new PriorityQueue<>();

            int vNum = 0;  // 모음 개수
            int cNum = 0;  // 자음 개수
            for(int i=0; i<arr.length; i++){
                if(visited[i]){
                    pq.add(arr[i]);

                    if(vowels.contains(arr[i])) vNum ++;
                    else cNum ++;

                }
            }

            if(vNum >= 1 && cNum >= 2){
                StringBuilder sb = new StringBuilder("");
                while(!pq.isEmpty()) sb.append(pq.poll());
                set.add(sb.toString());
            }


            return;
        }

        for(int i=start; i<arr.length; i++){
            if(!visited[i]){
                visited[i] = true;
                combination(i + 1, r - 1);
                visited[i] = false;
            }
        }
    }
}



