import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main
{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();

        System.out.println(dfs(a,b));
    }

    public static int dfs(String a, String b){
        if(a.length() == b.length()){
            if(a.equals(b))
                return 1;
            return 0;
        }

        int ret = 0;
        if(b.charAt(b.length() - 1) == 'A')
            ret += dfs(a, b.substring(0, b.length() - 1));

        if(b.charAt(0) == 'B')
            ret += dfs(a, new StringBuilder(b.substring(1)).reverse().toString());

        return ret > 0 ? 1 : 0;

    }

}
