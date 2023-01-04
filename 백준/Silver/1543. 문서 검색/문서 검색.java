import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    public static String a,b;


    public static void main(String args[]) throws IOException {

        int answer = 0;
        int idx = 0;

        initInput();

        while(idx + b.length() <= a.length()){
            String tmp = a.substring(idx, idx + b.length());

            if(tmp.equals(b)) {
                answer ++;
                idx += b.length();
            }else idx ++;

        }

        System.out.println(answer);



    }

    public static void initInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        a = br.readLine();
        b = br.readLine();

    }


}
