import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        final HashSet<Integer> hashSet = new HashSet<>();

        for(final int num : nums) {
            hashSet.add(num);
        }

        return Math.min(hashSet.size(), nums.length / 2);
    }
}