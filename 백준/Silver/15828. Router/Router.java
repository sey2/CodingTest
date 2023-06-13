import java.util.*;
import java.io.*;


public class Main
{
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // StringTokenizer st = new StringTokenizer(br.readLine());

        Queue<String> q = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());
        String in = "";

        while(!(in = br.readLine()).equals("-1")){
            if(!q.isEmpty() && in.equals("0")) {
                q.poll();
                continue;
            }

            if(q.size() < n)
                q.add(in);

        }

        if(q.isEmpty()) System.out.println("empty");

        for(String out : q) bw.write(out + " ");

        bw.close();

    }


}