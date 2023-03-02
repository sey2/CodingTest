import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main
{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Loc arr[] = new Loc[n];

        for(int i=0; i<n; i++){
            String in[] = br.readLine().split(" ");

            arr[i] = new Loc(Integer.parseInt(in[0]), Integer.parseInt(in[1]));
        }

        Arrays.sort(arr);

        int start = arr[0].x;
        int end = arr[0].y;
        int ans = 0;

        for(int i=1; i<n; i++){
            if(arr[i].x > end){
                ans += (end - start);
                start = arr[i].x;
            }if(arr[i].y > end)
                end = arr[i].y;
        }

        System.out.println(ans + (end - start));


    }
}

class Loc implements Comparable<Loc>{
    int x, y;

    public Loc(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Loc o1){
        return this.x - o1.x;
    }
}



