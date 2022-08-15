import java.util.HashSet;
class Solution {
    public boolean solution(String[] phone_book) {
        HashSet<String> phone = new HashSet<>();

        for(int i=0; i<phone_book.length; i++) phone.add(phone_book[i]);

        for(int i=0; i<phone_book.length; i++){
            for(int j=0; j< phone_book[i].length(); j++){
                if(phone.contains(phone_book[i].substring(0,j))) 
                    return false;
            }
        }
        
        return true;
    }
}
