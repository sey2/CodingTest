class Solution {
    public int[] solution(int[] arr) {
        int ans[] = new int[arr.length];

        for(int i=0; i<arr.length; i++){
            if(arr[i] >= 50 && arr[i] % 2 == 0) ans[i] = arr[i] / 2;
            else if(arr[i] < 50 && arr[i] % 2 != 0) ans[i] = arr[i] * 2;
            else ans[i] = arr[i];
        }
        
        return ans;
    }
}