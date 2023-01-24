

class Solution {
    public int solution(String[] babbling) {
        String [] arr = {"aya", "ye", "woo", "ma"};

        int answer = 0;
        for(int i=0; i<babbling.length; i++){
            String str = babbling[i];

            for(int j=0; j<4; j++)
                str = str.replaceAll(arr[j], "@");

            if(str.replaceAll("@", "").equals("")) answer ++;

        }
        return answer;
    }
}
