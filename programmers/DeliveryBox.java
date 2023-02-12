import java.util.Stack;


class Solution {
    public int solution(int[] order) {
        int answer = 0;

        int orderNum = 1;
        Stack<Integer> subContainer = new Stack<>();

        subContainer.push(orderNum++);
        int i = 0;

        while(answer < order.length){
            int cur = order[i];

            if(subContainer.isEmpty()) subContainer.add(orderNum++);

            if(subContainer.peek() == cur){
                subContainer.pop();
                answer ++;
            }else{
                while(orderNum <= order.length){
                    subContainer.push(orderNum++);

                    if(subContainer.peek() == cur){
                        answer ++;
                        subContainer.pop();
                        break;
                    }
                    else if(orderNum == order.length+1 && subContainer.peek() != cur)
                        return answer;

                }

            }
            i+= 1;
        }

        return answer;
    }
}
