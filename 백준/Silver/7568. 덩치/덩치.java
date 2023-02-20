import java.io.*;
import java.util.*;

public class Main {

    static String compareStr;
    static boolean check = false;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Info arr[] = new Info[n];
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for(int i=0; i<n; i++){
            int rank = n;
            for(int j=0; j<n; j++){
                if(i == j ) continue;

                if(arr[i].a > arr[j].a && arr[i].b > arr[j].b)
                    rank --;
                else if(arr[i].a >= arr[j].a || arr[i].b >= arr[j].b)
                    rank --;

            }
            System.out.print(rank + " ");
        }


    }
}

class Info{
    int a, b;

    public Info(int a, int b){
        this.a = a;
        this.b = b;
    }
}

