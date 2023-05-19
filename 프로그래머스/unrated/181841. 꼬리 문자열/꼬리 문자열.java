class Solution {
    public String solution(String[] str_list, String ex) {
        StringBuilder answer = new StringBuilder("");
        
        for(String cur : str_list){
            if(cur.contains(ex)) continue;
            
            answer.append(cur);
        }
        return answer.toString();
    }
}