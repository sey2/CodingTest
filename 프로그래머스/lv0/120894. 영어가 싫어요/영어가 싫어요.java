class Solution {
    String number [] = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    public long solution(String numbers) {
        for(int i=0; i<=9; i++)
            numbers = numbers.replaceAll(number[i], i + "");
        
        return Long.parseLong(numbers);
    }
}