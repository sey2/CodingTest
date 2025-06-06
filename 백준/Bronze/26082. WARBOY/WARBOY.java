import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int competitorPrice = Integer.parseInt(st.nextToken());
        int competitorsPerformance = Integer.parseInt(st.nextToken());
        int warboyPrice = Integer.parseInt(st.nextToken());
        int priceRatioOfPerformance = competitorsPerformance / competitorPrice  * 3;
        
        System.out.println(priceRatioOfPerformance * warboyPrice);
    }
}