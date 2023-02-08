class Solution {

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for(String str : skill_trees){
            String sk = str;

            for(int i=0; i<str.length(); i++){
                String removeSkill = str.substring(i, i+1);
                if(!skill.contains(removeSkill)){
                    sk = sk.replace(removeSkill, "");
                }
            }

            if(skill.indexOf(sk) == 0) answer++;
        }
        return answer;
    }
}
