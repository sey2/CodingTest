import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;


public class Main
{

    static int dx[] = {0, 0, -1 , 1};
    static int dy[] = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String start = "";

        for(int i=0; i<3; i++){
            String input[] = br.readLine().split(" ");
            for(int j=0; j<3; j++){
                start += input[j];
            }
        }

        Queue<String> q = new LinkedList<>();
        HashMap<String, Integer> map = new HashMap<>();
        map.put(start, 0);
        q.add(start);

        while(!q.isEmpty()){
            String cur = q.poll();
            int zeroIdx = cur.indexOf("0");
            int zeroY = zeroIdx / 3;
            int zeroX = zeroIdx % 3;

            for(int i=0; i<4; i++){
                int ny = zeroY + dy[i];
                int nx = zeroX + dx[i];

                if(ny >= 0 && ny < 3 && nx >= 0 && nx < 3){
                    char target = cur.charAt(ny * 3 + nx);
                    StringBuilder sb = new StringBuilder(cur);
                    sb.setCharAt(zeroIdx, target);
                    sb.setCharAt(ny * 3 + nx, '0');
                    String next = sb.toString();

                    if(!map.containsKey(next)){
                        q.add(next);
                        map.put(next, map.get(cur) + 1);
                    }
                }
            }
        }

        if(map.containsKey("123456780"))
            System.out.println(map.get("123456780"));
        else
            System.out.println("-1");


    }

}






