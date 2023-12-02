import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int arr[] = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        int start = 0;
        int count = 0;
        for(start=0; start<arr.length; start++) {
           map.put(arr[start], map.getOrDefault(arr[start], 0) + 1);

            while(map.size() > 2) {
                map.put(arr[count], map.getOrDefault(arr[count], 0) - 1);
                if(map.get(arr[count]) <= 0) map.remove(arr[count]);
                count ++;
            }

            ans = Math.max(ans, start - count + 1);
        }
        System.out.println(ans);

    }

}
