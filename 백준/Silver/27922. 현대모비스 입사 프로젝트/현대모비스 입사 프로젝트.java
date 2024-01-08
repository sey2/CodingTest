import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String in[] = br.readLine().split(" ");
        int n = Integer.parseInt(in[0]);
        int k = Integer.parseInt(in[1]);
        Subject arr[] = new Subject[n];

        for(int i=0; i<n; i++) {
            in = br.readLine().split(" ");
            int a = Integer.parseInt(in[0]);
            int b = Integer.parseInt(in[1]);
            int c = Integer.parseInt(in[2]);
            arr[i] = new Subject(a,b,c);
        }

        int ans = 0;
        Arrays.sort(arr, ((o1, o2) -> o2.arr[0] - o1.arr[0]));
        ans = Math.max(findMax(k, arr, 0), ans);

        Arrays.sort(arr, ((o1, o2) -> o2.arr[1] - o1.arr[1]));
        ans = Math.max(findMax(k, arr, 1), ans);

        Arrays.sort(arr, ((o1, o2) -> o2.arr[2] - o1.arr[2]));
        ans = Math.max(findMax(k, arr, 2), ans);
        System.out.println(ans);
    }

    public static int findMax(int k, Subject subjects[], int j) {
        int sum = 0;
        for(int i=0; i<k; i++) {
            sum += subjects[i].arr[j];
        }

        return sum;
    }
}

class Subject {
    int arr[] = new int[3];
    public Subject(int a, int b, int c) {
        arr[0] = a + b;
        arr[1] = b + c;
        arr[2] = a + c;
    }
}
