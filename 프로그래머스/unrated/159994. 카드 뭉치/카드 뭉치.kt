class Solution {
    fun solution(cards1: Array<String>, cards2: Array<String>, goal: Array<String>): String {
        var idx1: Int = 0;
        var idx2: Int = 0;
        
        for(i in 0 .. goal.size-1){
            if(idx1 < cards1.size && cards1[idx1] == goal[i]) idx1 ++;
            else if(idx2 < cards2.size && cards2[idx2] == goal[i]) idx2 ++;
            else return "No";
        }
        
        
        return "Yes";
    }
}