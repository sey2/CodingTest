class Solution {
    static String str = "";
    static int answer = Integer.MAX_VALUE;
    public int solution(int storey) {
        str = String.valueOf(storey);
        dfs(str.length() - 1, 0, 0);
        return answer;
    }

    public void dfs(int depth, int cnt, int reversed){
        if(depth == -1){
            cnt += reversed;
            answer = Math.min(answer, cnt);
            return;
        }

        int num = str.charAt(depth) - '0' + reversed;

        dfs(depth - 1, cnt + num, 0);
        dfs(depth - 1, cnt + 10 - num, 1);
    }
}