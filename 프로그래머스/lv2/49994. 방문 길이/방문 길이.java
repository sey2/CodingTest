import java.util.*;

class Solution {
    Cor cur;

    public int solution(String dirs) {
        cur = new Cor(0,0, 0, 0);

        HashSet<Cor> set = new HashSet<>();

        for(int i=0; i<dirs.length(); i++){
            char command = dirs.charAt(i);

            move(command);

            set.add(new Cor(cur.curY, cur.curX, cur.prevY, cur.prevX));
        }


        return set.size();
    }

    public void move(char c){
        switch(c){
            case 'U':
                if(check(cur.curY+1, cur.curX))
                    cur.setY(cur.curY+1);
                break;
            case 'D':
                if(check(cur.curY-1, cur.curX))
                    cur.setY(cur.curY-1);
                break;
            case 'R':
                if(check(cur.curY, cur.curX+1))
                    cur.setX(cur.curX+1);
                break;
            case 'L':
                if(check(cur.curY, cur.curX-1))
                    cur.setX(cur.curX-1);
                break;
        }
    }

    public boolean check(int y, int x){
        return (x >= -5 && x <= 5 &&
                y >= -5 && y <= 5);
    }
}

class Cor{
    int prevY, prevX;
    int curY, curX;
    Cor(int curY, int curX, int prevY, int prevX){
        this.curY = curY;
        this.curX = curX;
        this.prevY = prevY;
        this.prevX = prevX;
    }

    void prevSet(){
        this.prevX = curX;
        this.prevY = curY;
    }

    void setY(int y){
        prevSet();
        this.curY = y;
    }
    void setX(int x){
        prevSet();
        this.curX = x;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Cor)
            return (curY == ((Cor)obj).curY && curX == ((Cor)obj).curX &&
                    prevY == ((Cor)obj).prevY && prevX == ((Cor)obj).prevX) ||
                    (prevY == ((Cor)obj).curY && prevX == ((Cor)obj).curX &&
                    curY == ((Cor)obj).prevY && curX == ((Cor)obj).prevX);
        return false;
    }

    @Override
    public int hashCode(){
        return Objects.hash(prevX, prevY, curX, curY) + Objects.hash(curX, curY, prevX, prevY);
    }

}