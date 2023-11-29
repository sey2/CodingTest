class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int healCount = 0;
        int myHealth = health;
        int attackTimeIndex = 0;
        
        for(int i=1; i<=attacks[attacks.length-1][0]; i++) {
            if(attacks[attackTimeIndex][0] == i) {
                healCount = 0;
                myHealth -= attacks[attackTimeIndex][1];
                attackTimeIndex++;
                
                if(myHealth <= 0) return -1;
            } else {
                myHealth = heal(health, myHealth, bandage[1]);
                healCount ++; 
                if(healCount >= bandage[0]) {
                    healCount = 0;
                    myHealth = heal(health, myHealth, bandage[2]);
                }
            }
            
        }
        
        return myHealth;
    }
    
    public int heal(int limit, int myHealt, int healNum) {
        int h = myHealt + healNum;
        
        return (h >= limit) ? limit : h;
    }
}