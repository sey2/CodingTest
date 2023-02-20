import java.io.*;
import java.util.*;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> list = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());

        for(int i=n; i>=1; i--) list.add(i);


        while(list.size() > 1){
            System.out.print(list.remove(list.size() - 1) + " ");
            list.add(0, list.remove(list.size() -1));
        }

        System.out.print(list.get(0));



    }
}


