import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main
{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        int findNum = Integer.parseInt(st.nextToken());

        Country[] arr = new Country[size];

        for(int i=0; i<size; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            arr[i] = new Country(num,gold,silver,bronze);
        }

        Arrays.sort(arr);
        arr[0].setRank(1);

        for(int i=1; i<size; i++){

            if(compare(arr[i], arr[i-1])){
                arr[i].setRank(arr[i-1].rank);
                continue;
            }
            arr[i].setRank(i+1);

        }

        System.out.println(findCountry(findNum, arr));

    }

    public static int findCountry(int num, Country[] arr){
        for(int i=0; i<arr.length; i++){
            if(num == arr[i].num) return arr[i].rank;
        }
        return -1;
    }

    public static boolean compare(Country o1, Country o2){
        return (o1.gold == o2.gold && o1.silver == o2.silver && o1.bronze == o2.bronze)
                ? true : false;
    }
}

class Country implements Comparable<Country>{
    int gold, silver, bronze, rank, num;

    public Country(int num, int gold, int silver, int bronze){
        this.num = num;
        this.gold = gold;
        this.silver = silver;
        this.bronze = bronze;
    }

    public void setRank(int rank){this.rank = rank;}

    @Override
    public int compareTo(Country o) {

        if(this.gold == o.gold){

            if(this.silver == o.silver)
                return o.bronze - this.bronze;

            return o.silver - this.silver;
        }

        return o.gold - this.gold;
    }
}






