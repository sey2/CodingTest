import java.io.*;
import java.math.BigInteger;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        HashMap<String, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++){
            String key = br.readLine();
            map.put(key, map.getOrDefault(key,0) + 1);
        }

        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());

        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(o1.getValue() == o2.getValue())
                    return o2.getKey().compareTo(o1.getKey());
                return o1.getValue() - o2.getValue();
            }
        });

        var a = entryList.get(entryList.size()-1);

        bw.write(a.getKey() + "");

        bw.flush();

    }
}
