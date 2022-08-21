import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
 
class Solution
{
    public static boolean ans = false;
    public static ArrayList<Integer> list = new ArrayList<>();
 
    
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
 
        for(int i=1; i<=t; i++){
            String str = br.readLine();
 
            boolean visited[] = new boolean[str.length()];
            int arr[] = new int[str.length()];
            int output[] = new int [str.length()];
            int input = Integer.parseInt(str);
 
            list = new ArrayList<>();
            for(int j=2; j<=10; j++) list.add(input * j);
 
            for(int j=0; j<str.length(); j++) arr[j] = str.charAt(j) - 48;
 
            ans = false;
            permutation(arr, output, visited, 0, str.length(), str.length());
 
            if(ans) System.out.println("#" + i + " possible");
            else System.out.println("#" + i + " impossible");
        }
    }
       // 순서를 지키면서 n 개중에서 r 개를 뽑는 경우
    static void permutation(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
        if(depth == r) {
            //print(output, r); //순열 출력을 위한 print 함수
            check(output, r);
            return;
        }
 
        for(int i = 0; i < n; i++) {
        if(visited[i] != true) {
            visited[i] = true;
            output[depth] = arr[i];
            permutation(arr, output, visited, depth + 1, n, r);
            visited[i] = false;
        }
    }
}
 
      static void check(int [] arr, int r){
        String str = "";
 
        for(int i = 0; i < r; i++) str += arr[i];
 
        long tmp = Integer.parseInt(str);
        for(int num : list){
            if(tmp == num) ans = true;
        }
    }
}
