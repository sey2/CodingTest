import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> input = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        input.add(0);       // dummy
        while(st.hasMoreTokens()){
            input.add(Integer.parseInt(st.nextToken()));
        }

        for(int i=size; i>=1; i--)
            list.add(input.get(i), i);


        for(var num : list) System.out.print(num + " ");
    }

}
