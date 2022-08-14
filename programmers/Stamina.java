package programmers;

class Solution {
    static int tmp[][];
    static int max = Integer.MIN_VALUE;

    public static int solution(int k, int[][] dungeons) {

        Solution.permutation(dungeons,0, dungeons.length,dungeons.length,k);

        return max;
    }


    static void permutation(int[][] arr, int depth, int n, int r, int k) {
        if (depth == r) {
            check(arr, r, k);
            return;
        }

        for (int i=depth; i<n; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, r,k);
            swap(arr, depth, i);
        }
    }

    static void swap(int[][] arr, int depth, int i) {
        int minumunSta = arr[depth][0];
        arr[depth][0] = arr[i][0];
        arr[i][0] = minumunSta;

        int need = arr[depth][1];
        arr[depth][1] = arr[i][1];
        arr[i][1] = need;

    }
    static void check(int[][] arr, int r, int userStamina) {

        int ableDungeons = 0;
        for (int i = 0; i < r; i++) {
            // System.out.print("["+arr[i][0] + "," + arr[i][1] + "] " );
            if(userStamina >= arr[i][0]){
                userStamina -= arr[i][1];
                ableDungeons++;
            }
        }//System.out.println();

        if(ableDungeons > max) max = ableDungeons;
    }

}
