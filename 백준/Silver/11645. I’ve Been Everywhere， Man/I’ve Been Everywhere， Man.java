import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

class Main{
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while(t --> 0){
            int n = Integer.parseInt(br.readLine());

            HashSet<String> set = new HashSet<>();
            for(int i=0; i<n; i++)
                set.add(br.readLine());

            System.out.println(set.size());
        }
    }
}