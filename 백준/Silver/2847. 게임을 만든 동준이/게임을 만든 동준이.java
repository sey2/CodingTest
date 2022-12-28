import java.io.*;


public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int score[] = new int[n];

        for(int i=0; i<n; i++) score[i] = Integer.parseInt(br.readLine());

        int memory = score[n-1] - 1;
        int answer = 0;

        for(int i=n-2; i>=0; i--){
            if(score[i] <= memory) {
                memory = score[i] - 1;
                continue;
            }

            answer += score[i] - memory;
            memory --;
        }

        bw.write(answer + "");
        bw.close();

    }
}
