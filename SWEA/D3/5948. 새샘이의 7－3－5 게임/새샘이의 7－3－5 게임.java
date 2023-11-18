import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Solution {
    static HashSet<Integer> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int cnt = 1;
        while(T-->0) {
            int arr [] = new int[7];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<7; i++)
                arr[i] = Integer.parseInt(st.nextToken());

            set = new HashSet<>();

            com(arr, new boolean[7], 0, 3);

            List<Integer> list = set.stream().collect(Collectors.toList());

            Collections.sort(list, Collections.reverseOrder());

            System.out.println("#" + cnt++ + " " + list.get(4));

        }
    }

    public static void com(int arr[], boolean visited[], int start, int r) {
        if(r == 0) {
            int sum = 0;
            for(int i=0; i<arr.length; i++) {
                if(visited[i]) {
                    sum += arr[i];
                }
            }
            set.add(sum);
            return;
        }

        for(int i=start; i<arr.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                com(arr, visited, i + 1, r-1);
                visited[i] = false;
            }
        }
    }


}
