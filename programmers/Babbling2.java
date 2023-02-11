class Solution {

    String check [] = {"aya", "ye", "woo", "ma"};
    String replace[] = {"\\@", "\\#", "\\$", "\\!"};

    public int solution(String[] babbling) {
        int answer = 0;

       // 발음할 수 있는 단어를 특수 문자로 변경 
        for(int i=0; i<babbling.length; i++){
            for(int j=0; j<4; j++){
                babbling[i] = babbling[i].replaceAll(check[j], replace[j]);
            }
        }

        // 연속된 단어 검사
        loop: 
        for(int i=0; i<babbling.length; i++){
            String str = babbling[i];

            for(int j=0; j<str.length()-1; j++){
                char c = str.charAt(j);
                char next = str.charAt(j+1);
              
                // 발음 할 수 없는 단어 이면 건너 뜀
                if(c >= 'a' && c <= 'z') continue loop;
                // 다음 문자가 연속된 발음이거나 발음할 수 없는 문자이면 건너 뜀
                if(c == str.charAt(j+1) || (next >= 'a' &&  next <='z')) continue  loop;
            }
        
            // 만약 길이가 1이고 발음할 수 없는 단어이면 건너 뜀 
            if(str.length() == 1 && str.charAt(0) >= 'a' && str.charAt(0) <= 'z') continue loop;
          
            // 이 루프까지 오면 발음 할 수 있는 단어들이므로 answer + 1
            answer ++;
        }

        return answer;
    }
}
