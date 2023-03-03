    import java.io.*;
    import java.util.*;

    public class Main {

        static int arr[] = new int[]{1,5, 10,50};
        static HashSet<Integer> set = new HashSet<>();

        public static void main(String args[]) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int r = Integer.parseInt(br.readLine());

            int out[] = new int[r];

            combination(out, 0, 0, r);
            System.out.println(set.size());

        }

        public static void combination(int out[], int start, int depth, int r){
            if(depth == r){
                int sum = 0;

                for(int i=0; i<out.length; i++) sum += out[i];

                set.add(sum);

                return;
            }

            for(int i=start; i<4; i++){
                out[depth] = arr[i];
                combination(out, i, depth + 1, r);
            }
        }

    }




