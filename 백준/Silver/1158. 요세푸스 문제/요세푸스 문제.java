import java.util.*;
import java.io.*;


public class Main
{
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Integer> q = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for(int i=1; i<=n; i++) q.add(i);

        int idx = 0;

        for(int i=0; i<n; i++){
            idx = (idx + k - 1) % q.size();
            ans.add(q.remove(idx));
        }

        bw.write("<");
        for(int i=0; i<ans.size(); i++) {
            if(i == ans.size() - 1)
                bw.write(ans.get(i) + ">");
            else
                bw.write(ans.get(i) + ", ");
        }

        bw.close();

    }


}