import java.util.ArrayList;

class Solution {
    public String[] solution(String[] picture, int k) {
        ArrayList<String> answer = new ArrayList<>();

        if(k == 1) return picture;

        int idx = 0;

        for(int i=0; i<picture.length * k; i++){
             answer.add(makeString(picture[idx], k));

            if(i > 0 && (i+1) % k == 0) idx++;
        }


        return answer.toArray(String[]::new);
    }

    public String makeString(String str, int k){
        String s = "";

        for(int i=0; i<str.length(); i++){
            for(int j=0; j<k; j++){
                s += str.charAt(i);
            }
        }

        return s;
    }
}