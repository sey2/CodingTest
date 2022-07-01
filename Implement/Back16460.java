import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class User{
    String name;
    String gender;
    int distance;

    public User(String name, String gender, int distance){
        this.name = name;
        this.gender = gender;
        this.distance = distance;
    }
}

public class Back16460 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        User premiumUser = new User(st.nextToken(),st.nextToken(), Integer.parseInt(st.nextToken()));
        int peopleNum = Integer.parseInt(br.readLine());
        User userArr[] = new User[peopleNum];

        for(int i=0; i<peopleNum; i++){
            st = new StringTokenizer(br.readLine());
            userArr[i] = new User(st.nextToken(), st.nextToken(), Integer.parseInt(st.nextToken()));
        }

        ArrayList<String> ans = new ArrayList<>();
        for(var target : userArr){
            if(checkGender(premiumUser.gender, target.gender) && premiumUser.distance >= target.distance) 
                ans.add(target.name);
        }

        Collections.sort(ans);

        if(ans.size() == 0) System.out.println("No one yet");
        else for(var name : ans) System.out.println(name);

    }

    public static boolean checkGender(String premiumUserGender, String targetGender){
        if(premiumUserGender.equals("FM") || premiumUserGender.equals("MF")) return true;
        else if(premiumUserGender.equals(targetGender)) return true;
        else return false;
    }




}