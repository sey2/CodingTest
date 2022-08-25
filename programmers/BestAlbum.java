import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class Music implements Comparable{
    int num;
    int play;

    public Music(int num, int play){this.num = num; this.play = play;}

    public int compareTo(Object obj){
        Music o1 = (Music) obj;

        if(o1.play == this.play){
            return (o1.num < this.num) ? 1 : -1;
        }

        return o1.play - this.play;
    }

}


class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String,ArrayList<Music>> hash = new HashMap<>();
        HashMap<String, Integer> hashSum = new HashMap<>();

        for(int i=0; i< genres.length; i++){
            if(hash.containsKey(genres[i])){
                ArrayList<Music> list = hash.get(genres[i]);
                list.add(new Music(i, plays[i]));
                hash.put(genres[i],list);
                hashSum.put(genres[i], hashSum.get(genres[i]) + plays[i]);
            }else{
                ArrayList<Music> list = new ArrayList<>();
                list.add(new Music(i,plays[i]));
                hash.put(genres[i], list);
                hashSum.put(genres[i], plays[i]);
            }
        }

        List<String> listKeySet = new ArrayList<>(hashSum.keySet());
        Collections.sort(listKeySet, (value1, value2) -> (hashSum.get(value2).compareTo(hashSum.get(value1))));

        ArrayList<Integer>answer = new ArrayList<>();

        for(var key : listKeySet){
            var list = hash.get(key);
            Collections.sort(list);

            for(int i=0; i<list.size() && i<2; i++)
                answer.add(list.get(i).num);

        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
