import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Solution {

   static HashMap<String, String> nickmap = new HashMap<>();
   static ArrayList<String> chatLog = new ArrayList<>();

    public static String[] solution(String[] record) {

        for(int i=0; i<record.length; i++){
            StringTokenizer st = new StringTokenizer(record[i], " ");
            String command = st.nextToken();
            String userID  = st.nextToken();
            String name = "";

            if(!command.equals("Leave"))
                 name = st.nextToken();

            commandString(command,userID,name);

        }

        int cnt  = 0;
        String[] answer = new String[chatLog.size()];

        for(String message: chatLog){
            String uid = message.substring(0, message.indexOf("님"));

            answer[cnt++] = message.replace(uid, nickmap.get(uid));
        }


        return answer;
    }

    public static void commandString (String command, String userID, String name) {
        switch (command) {
            case "Enter":
                nickmap.put(userID, name);
                chatLog.add(userID + "님이 들어왔습니다.");
                break;
            case "Leave":
                chatLog.add(userID + "님이 나갔습니다.");
                break;
            case "Change":
                nickmap.put(userID, name);
                break;
        }
    }
}
