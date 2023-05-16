import java.util.*;
class Solution {
    boolean visited[];
    HashMap<String, Integer> map = new HashMap<>();

    static int max = 0;

    public String[] solution(String[] orders, int[] course) {
        ArrayList<String> answer = new ArrayList<>();
        int maxArr[] = new int[11];

        for(int i=0; i<orders.length; i++){
            String order = orders[i];

            char arr[] = makeArr(order);
            Arrays.sort(arr);
            visited = new boolean[order.length()];

            for(int j=0; j<course.length; j++){
                max = 0;
                com(arr, 0, course[j]);
                maxArr[course[j]] = Math.max(maxArr[course[j]], max);
            }

        }

        for(String k : map.keySet()){
            if(map.get(k) == maxArr[k.length()] && map.get(k) >= 2)
                answer.add(k);
        }
        
       Collections.sort(answer);


        return answer.toArray(new String[0]);
    }

    public void com(char arr[], int start, int r){
        if(r == 0){
            StringBuilder sb = new StringBuilder("");

            for(int i=0; i<arr.length; i++){
                if(visited[i])
                    sb.append(arr[i]);
            }

            String key = sb.toString();

            map.put(key, map.getOrDefault(key, 0) + 1);

            max = Math.max(max, map.get(key));
            return;
        }

        for(int i=start; i<arr.length; i++){
            if(!visited[i]){
                visited[i] = true;
                com(arr, i + 1, r-1);
                visited[i] = false;
            }
        }
    }

    public static char[] makeArr(String order){
        char arr[] = new char[order.length()];

        for(int i=0; i<order.length(); i++)
            arr[i] = order.charAt(i);

        return arr;
    }
}
