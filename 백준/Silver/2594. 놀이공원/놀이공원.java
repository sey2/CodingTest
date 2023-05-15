    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.Arrays;
    import java.util.StringTokenizer;

    public class Main{

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int n = Integer.parseInt(br.readLine());

            Time arr[] = new Time[n+1];
            for(int i=0; i<n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                arr[i] = new Time(parseTime(st.nextToken()) - 10, parseTime(st.nextToken()) + 10);
            }

            arr[n] = new Time(1320, Integer.MAX_VALUE);
            Arrays.sort(arr, (o1,o2) -> o1.start - o2.start);

            int ans = 0;
            int last = 600;

            for(int i=0; i<arr.length; i++){
                ans = Math.max(ans, arr[i].start - last);
                last = Math.max(last, arr[i].end);
            }


            System.out.println(ans);
        }

        public static int parseTime(String s){
            return (Integer.parseInt(s.substring(0, 2)) * 60 + Integer.parseInt(s.substring(2, s.length())));
        }

    }

    class Time{
        int start, end;

        Time(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
