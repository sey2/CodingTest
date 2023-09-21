import java.util.*;
import java.util.stream.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        List<String> playerList = new ArrayList<>(Arrays.asList(players));
        Map<String, Integer> playerIndexMap = IntStream.range(0, players.length)
                .boxed()
                .collect(Collectors.toMap(i -> players[i], i -> i));

        Arrays.stream(callings)
              .forEach(calling -> {
                  int index = playerIndexMap.get(calling);
                  if (index > 0) {
                      Collections.swap(playerList, index, index - 1);
                      playerIndexMap.put(calling, index - 1);
                      playerIndexMap.put(playerList.get(index), index);
                  }
              });

        return playerList.toArray(new String[0]);
    }
}
