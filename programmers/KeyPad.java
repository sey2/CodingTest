class Pos{
    int x;
    int y;
    
    public Pos(int y, int x){
        this.y = y;
        this.x = x;
    }
}

class Solution {
    public static String solution(int[] numbers, String hand) {
        String answer = "";
        Pos left = new Pos(3, 0);       // *에서 시작
        Pos right = new Pos(3, 2);      // #에서 시작
        Pos key[] = new Pos[10];

        int cnt = 1;
        key[0] = new Pos(3,1);  // 0 위치

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++)
                key[cnt++] = new Pos(i,j);
        }

            for(int i=0; i<numbers.length; i++){
            Pos next =  key[numbers[i]];

            if((next.y == 0 || next.y == 1 || next.y == 2) && next.x == 0) {  // 1, 4, 7 인 경우
                left = next;
                answer += "L";
            }
            else if((next.y == 0 || next.y == 1 || next.y == 2) && next.x == 2) { // 3, 6, 9인 경우
                right = next;
                answer += "R";
            }
            else{   // 2, 5, 8, 0 인 경우
                int leftDis = Math.abs(left.x - next.x) + Math.abs(left.y - next.y);
                int rightDis = Math.abs(right.x - next.x) + Math.abs(right.y - next.y);

                if(hand.equals("left")) {
                    if(leftDis<= rightDis){
                        answer+= "L";
                        left = next;
                    }else{
                        answer +="R";
                        right = next;
                    }

                }
                else if(hand.equals("right")) {
                    if(leftDis >= rightDis){
                        answer+= "R";
                        right=next;
                    }else{
                        answer += "L";
                        left = next;
                    }
                }
            }

        }

        return answer;
    }
}
