class Solution {
    public long solution(int price, long money, int count) {
        long howMuch = 0;
        
        for(int i=1; i<=count; i++) howMuch += (price * i);
        
        return (howMuch - money >=0) ? howMuch-money : 0;
    }
}
