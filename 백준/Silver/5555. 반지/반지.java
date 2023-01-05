import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main
{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String find = br.readLine();
        int n = Integer.parseInt(br.readLine());

        int answer = 0;
        for(int i=0; i<n; i++){
            String in = br.readLine();
            in += in;

            if(in.indexOf(find) >=0 ) answer++;
        }


        System.out.println(answer);


    }

}






