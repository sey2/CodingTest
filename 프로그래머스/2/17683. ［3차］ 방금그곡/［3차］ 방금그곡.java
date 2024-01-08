import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;


class Solution {
    public String solution(String m, String[] musicinfos) {
        Music[] musics = new Music[musicinfos.length];

        for (int i = 0; i < musics.length; i++) {
            String in[] = musicinfos[i].split(",");
            String start[] = in[0].split(":");
            String end[] = in[1].split(":");

            int st = parseTime(Integer.parseInt(start[0]), Integer.parseInt(start[1]));
            int ed = parseTime(Integer.parseInt(end[0]), Integer.parseInt(end[1]));

            musics[i] = new Music(st, ed, in[2], in[3], i);
        }

        ArrayList<Music> ans = new ArrayList<>();
        for(int i=0; i<musics.length; i++) {
            String str = "";

            int index = -1;
            for(int j=0; j<musics[i].runningTime; j++) {
                index ++;
                Music cur = musics[i];
                str += cur.score.charAt(index % musics[i].score.length());

                if(index % cur.score.length() + 1 < cur.score.length() && cur.score.charAt(index % cur.score.length() + 1) == '#') {
                    str += "#";
                    index++;
                }
            }

            int idx = str.indexOf(m);

            if(idx == -1) continue;

            if(contains(str, m))
                ans.add(musics[i]);
        }

        Collections.sort(ans);


        return (ans.size() == 0) ? "(None)" : ans.get(0).name;
    }

    public int parseTime(int hour, int min) {
        return hour * 60 + min;
    }

    public static boolean contains(String str, String target) {
        if(target.charAt(target.length() - 1) == '#') return str.contains(target);

        while(true) {
            int index = str.indexOf(target);

            if(index == -1) return false;

            if(index + target.length() < str.length() && str.charAt(index + target.length()) == '#') {
                str = str.replace(target + "#" ,"");
            } else if(index + target.length()-1 < str.length() && str.charAt(index + target.length()-1) != '#') 
                return true;
        }
    }

}

class Music implements Comparable<Music>{
    int start;
    int end;
    int runningTime;
    String name;
    String score;

    int index = 0;

    public Music(int start, int end, String name, String score, int index) {
        this.start = start;
        this.end = end;
        this.name = name;
        this.score = score;
        runningTime = end- start;
        this.index = index;
    }

    @Override
    public int compareTo(Music o) {
        if(this.runningTime == o.runningTime)
            return this.index - o.index;

        return o.runningTime - this.runningTime;
    }
}