import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main
{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();

        int n = Integer.parseInt(br.readLine());

        String [] word = new String[n];
        for(int i=0; i<n; i++) word[i] = br.readLine();

        for(int i=0; i<26; i++){

            for(int j=0; j<input.length; j++)
                input[j] = (char) ('a' + (input[j] - 'a' +1) % 26);

            String s = String.valueOf(input);

            for(String w : word){
                if(s.contains(w)){
                    System.out.println(s);
                    return;
                }
            }

        }



    }

}