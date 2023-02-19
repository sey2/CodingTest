import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;


public class Main
{
    public static char [] plainArr;
    public static int colLen = 0;
    public static String cypher;
    public static String key;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        key = br.readLine();
        cypher = br.readLine();

        ArrayList<ArrayList<Character>> list = new ArrayList<>();

        char [] compare = key.toCharArray();
        Arrays.sort(compare);

        for(int i=0; i<compare.length; i++) {
            list.add(new ArrayList<>());
            list.get(i).add(compare[i]);
        }

        colLen = cypher.length() / key.length();

        for(int i=0; i<key.length(); i++){
            for(int j=0; j<colLen; j++){
                list.get(i).add(cypher.charAt(i * cypher.length() / key.length() + j));
            }
        }

        plainArr = new char[cypher.length()];


        for(int i=0; i<key.length(); i++){
            char c = key.charAt(i);

            for(int j=0; j<list.size(); j++){
                if(c == list.get(j).get(0)){
                    print(list.get(j), i+1);
                    list.remove(j);
                    break;
                }
            }
        }

        for(char c : plainArr) System.out.print(c);

        System.out.println();
    }

    public static void print(ArrayList<Character> tmp, int col){
        tmp.remove(0);

        for(int i=0; i<tmp.size(); i++) {
            plainArr[col + (i*key.length())-1] = tmp.get(i);
        }
    }

}






