import java.io.*;
import java.util.*;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<String> word = new ArrayList<>();
        for(int i=0; i<n; i++) word.add(br.readLine());

        for(int i=0; i<word.size()-1; i++){
            String compare1 = word.get(i);

            for(int j=i+1; j<word.size(); j++){
                if(compare1.length() != word.get(j).length()) continue;
                String compare2 = word.get(j) + word.get(j);

                if(compare2.contains(compare1)){
                    word.remove(j);
                    j--;
                }
            }
        }

        System.out.println(word.size());
    }



}


