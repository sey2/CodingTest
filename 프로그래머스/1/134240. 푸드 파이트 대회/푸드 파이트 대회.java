class Solution {
    public String solution(int[] food) {
        StringBuilder answer = new StringBuilder();
        int arr[] = newArray(food);
        
        for(int i=1; i<arr.length; i++) {
            for(int j=0; j<arr[i]/2; j++) { 
                answer.append(i);
            }
        }
        
        answer.append(0);
        
        for(int i=arr.length-1; i>=0; i--) {
            for(int j=0; j<arr[i]/2; j++) {
                answer.append(i);
            }
        }
    
        
        return answer.toString();
    }
    
    public int[] newArray(int[] food) {
        int newArray[] = new int[food.length];
        
        for(int i=1; i<newArray.length; i++) {
            newArray[i] = (food[i] % 2 == 0) ? food[i] : food[i]-1;
        }
        
        return newArray;
    }
}