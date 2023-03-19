import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;


public class Main
{
    static HashMap<String, ArrayList<String>> map;
    static HashMap<String, Boolean> visited = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        map = new HashMap<>();

        while(n --> 1){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name1 = st.nextToken();
            String name2 = st.nextToken();

            if(!map.containsKey(name1))
                map.put(name1, new ArrayList<>());

            map.get(name1).add(name2);

        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        String name1 = st.nextToken();
        String name2 = st.nextToken();
        dfs(name1, name2);
        dfs(name2, name1);
        System.out.println("0");

    }

    public static void dfs(String cur, String end){
        if(cur.equals(end)){
            System.out.println("1");
            System.exit(0);
        }

        if(map.get(cur) == null){
            return;
        }else {
            for(String name : map.get(cur)){
                dfs(name, end);
            }
        }
    }

}




