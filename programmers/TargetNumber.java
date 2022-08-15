
class Solution {
    int count;
    public int solution(int[] numbers, int target) {

     dfs(0,target, 0, numbers);

        return this.count;
    }

    public void dfs(int idx,int target, int sum, int[] numbers){
        if(idx == numbers.length){
            if(sum == target) this.count++;
            return;
        }
        dfs(idx + 1, target, sum + numbers[idx],numbers);
        dfs(idx + 1, target, sum - numbers[idx],numbers);
    }
}
