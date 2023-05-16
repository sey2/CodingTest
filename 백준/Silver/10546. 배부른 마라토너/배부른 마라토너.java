import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        HashMap<String, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++) {
            String key = br.readLine();
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        while(n --> 1){
            String key = br.readLine();
            map.put(key, map.get(key) - 1);

            if(map.get(key) == 0) map.remove(key);
        }

        System.out.println(map.keySet().toArray()[0]);

    }

}

