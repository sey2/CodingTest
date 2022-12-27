import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;


public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder s = new StringBuilder(br.readLine());
        StringBuilder t = new StringBuilder(br.readLine());
        StringBuilder S = new StringBuilder("");
        StringBuilder T = new StringBuilder("");

        int idx = 0;

        for(int i=0; i<t.length(); i++) S.append(s);
        for(int j=0; j<s.length(); j++) T.append(t);

        if(S.toString().equals(T.toString()))
            bw.write("1");
        else
            bw.write("0");
        bw.close();
    }
}
