
class Solution {

    static HashMap<String, ArrayList<Integer>> map = new HashMap<>();

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        // HashMap에 지원한 사람이 query에 통과할 수 있는 모든 경우의 수를 담아준다 ("-" 조건 때문에)
        makeMap(info);

        for(String key : map.keySet()) Collections.sort(map.get(key));

        for(int i=0; i< query.length; i++){
            String[] tmp = query[i].replace(" and ", "").split(" ");
            int score = Integer.parseInt(tmp[1]);
            answer[i] = binarySearch(tmp[0], score);
        }

        return answer;
    }

    private int binarySearch(String key, int score){
        if(map.containsKey(key)){
            ArrayList<Integer> list = map.get(key);
            int left = 0;
            int right = list.size()-1;

            if(list.get(right) < score) return 0;

            while(left < right){
                int mid = (left  + right) / 2;

                if(list.get(mid) < score) left = mid +1;
                else right = mid;
            }
            return list.size() - left;
        }
        return 0;
    }

    private void makeMap(String[] info){
        for(int i=0; i<info.length; i++){
            dfs("" , info[i].split(" "), 0);
        }
    }

    private void dfs(String str, String [] info, int depth){
        if(depth == 4) {
            if (!map.containsKey(str)) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(Integer.parseInt(info[4]));
                map.put(str, list);
            } else
                map.get(str).add(Integer.parseInt(info[4]));
            return;
        }

        dfs(str+"-",info, depth+1);
        dfs(str+info[depth],info, depth+1);
    }

}
