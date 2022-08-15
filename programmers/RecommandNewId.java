import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    public String solution(String new_id) {
        new_id = new_id.toLowerCase();
        StringBuilder sbNew_id = new StringBuilder(new_id);

        for(int i=0; i<sbNew_id.length(); i++){
            char curChar = sbNew_id.charAt(i);

            //  new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
            if( !(curChar >= 'a' && curChar <='z') && curChar !='-' && curChar != '_' && curChar != '.' && !(curChar >= '0' && curChar <='9')){
                sbNew_id.deleteCharAt(i); i --;
            }
        }

        //  new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        for(int i=0; i<sbNew_id.length()-1; i++){
            if(sbNew_id.charAt(i) == '.' && sbNew_id.charAt(i+1) == '.'){
                sbNew_id.deleteCharAt(i); i--;
            }
        }

        // new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        if(sbNew_id.charAt(0) == '.')
            sbNew_id.deleteCharAt(0);
        else if(sbNew_id.charAt(sbNew_id.length()-1) == '.')
            sbNew_id.deleteCharAt(sbNew_id.length()-1);

        //  new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        if(sbNew_id.length() == 0)
            sbNew_id.append("a");

        // new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
        // 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다
        if(sbNew_id.length() >= 16)
            sbNew_id = sbNew_id.delete(15,sbNew_id.length()+1);

        if(sbNew_id.charAt(sbNew_id.length()-1) == '.' )  sbNew_id.deleteCharAt(sbNew_id.length()-1);

       //new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.

        if(sbNew_id.length() <= 2){
            char last = sbNew_id.charAt(sbNew_id.length()-1);
            for(int i=sbNew_id.length(); i<3; i++){
                sbNew_id.append(last);
            }
        }

        String answer = sbNew_id.toString();
        return answer;
    }
}
