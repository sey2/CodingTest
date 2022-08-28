import java.io.*;
import java.util.*;

class Solution {
    private HashMap<String, ArrayList<String>> in = new HashMap<>();
    private HashMap<String, ArrayList<String>> out = new HashMap<>();
    private HashMap<String, Integer> sumTime = new HashMap<>();
    private int basicMinute, basicCharge, perMinute, perCharge;

    public int[] solution(int[] fees, String[] records) {

        input(fees, records);
        Object[] inKeySet = keySort(in);        // 주차장에 들어온 차량 번호 리스트
        Object[] outKeySet = keySort(out);      // 주차장 나간 차량 번호 리스트

        cumulativeTime(inKeySet, outKeySet);    // 주차장 이용한 차량들 누적시간 계산

        return calculationCharge();
    }

    public int[] calculationCharge(){
        Object[] sumTimeKeySet = sumTime.keySet().toArray();
        Arrays.sort(sumTimeKeySet);

        ArrayList<Integer> answer = new ArrayList<>();
        for(var key : sumTimeKeySet){
            int cumTime = sumTime.get(key);

            if(cumTime <= basicMinute){
                answer.add(basicCharge);
                continue;
            }

            double time = (double)(cumTime - basicMinute) / perMinute;
            answer.add(basicCharge + ((int)Math.ceil(time) * perCharge));
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public void cumulativeTime(Object[] inKeySet, Object[] outKeySet){
        int idx = 0;
        for(int i=0; i< inKeySet.length; i++){
            ArrayList<String> inList = in.get(inKeySet[i]);     // 하나의 차량이 들어온 입차 기록
            ArrayList<String> outList = new ArrayList<>();

            if(outKeySet.length > 0 && idx < out.keySet().size() && outKeySet[idx].equals(inKeySet[i]))
                outList =  out.get(outKeySet[idx++]);  // 하나의 차량이 나간 출차 기록

            int sumMinute = 0;  // 누적 주차 시간
            for(int j=0; j<inList.size(); j++){
                String in_time[] = inList.get(j).split(":");
                int time[];     // time[0] = 시간, time[1] = 분

                // 출차 기록이 없다면 출차 기록 hour:23, min:59로 세팅해서 주차장 이용 시간 계산
                if(outList.isEmpty() || j>= outList.size()){
                    time = calTime(23,59, Integer.parseInt(in_time[0]), Integer.parseInt(in_time[1]));
                    sumMinute += (time[0] * 60) + time[1];
                    continue;
                }

                // 출차 기록이 있다면 이용 시간 계산
                String out_time[] = outList.get(j).split(":");
                time = calTime( Integer.parseInt(out_time[0]), Integer.parseInt(out_time[1]), Integer.parseInt(in_time[0]), Integer.parseInt(in_time[1]));
                sumMinute += (time[0] * 60) + time[1];
            }

            sumTime.put((String) inKeySet[i],sumMinute);
        }

    }

    public int[] calTime(int out_hour, int out_min, int in_hour, int in_min){
        int time[] = new int[2]; // time[0] = hour, time[1] = min

        time[0] = out_hour - in_hour;

        if(out_min - in_min < 0){
            time[0] -= 1;
            time[1] = (out_min + 60) - in_min;
        }else time[1] = out_min - in_min;

        return time;
    }

    public Object[] keySort(HashMap<String,ArrayList<String>> map){
        Object[] keySet = map.keySet().toArray();
        Arrays.sort(keySet);
        return keySet;
    }

    public void input(int[] fees, String[] records){

        for(int i=0; i<records.length; i++){
            String car[] = records[i].split(" ");

            if(in.containsKey(car[1]) && car[2].equals("IN")){
                in.get(car[1]).add(car[0]);
            }else if(!in.containsKey(car[1]) && car[2].equals("IN")){
                ArrayList<String> list = new ArrayList<>();
                list.add(car[0]);
                in.put(car[1], list);
            }else if(out.containsKey(car[1]) && car[2].equals("OUT")) {
                out.get(car[1]).add(car[0]);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(car[0]);
                out.put(car[1],list);
            }
        } // end

        basicMinute = fees[0]; basicCharge = fees[1];
        perMinute = fees[2];   perCharge = fees[3];

    }
}


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

         int fees[] = {180, 5000, 10, 600};
         String records[] = {"05:34 5961 IN", "06:34 5961 OUT", "07:34 5961 IN", "08:34 5961 OUT", "09:34 5961 IN", "10:34 5961 OUT", "11:34 5961 IN", "12:34 5961 OUT",
                 "20:58 1111 IN","20:58 1112 IN"};
       // int fees[] = {1, 461, 1, 10};
      //  String records[] = {"00:00 1234 IN"};
       // int fees[] = {120, 0, 60, 591};
       // String records[] = {"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"};
       // int fees[] ={180, 5000, 10, 600};
       // String records[] = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

        int arr[] = new Solution().solution(fees,records);

        for(int num : arr){
            System.out.println(num);
        }
    }



