import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int[][] lectures = new int[N][3];

        for (int i = 0; i < N; i++) {
            lectures[i][0] = scanner.nextInt(); // 통신기술 역량
            lectures[i][1] = scanner.nextInt(); // 알고리즘 역량
            lectures[i][2] = scanner.nextInt(); // 기계구조학 역량
        }

        System.out.println(maxSumOfTwoSkills(N, K, lectures));
    }

    public static int maxSumOfTwoSkills(int N, int K, int[][] lectures) {
        List<Integer> sum12 = new ArrayList<>();
        List<Integer> sum13 = new ArrayList<>();
        List<Integer> sum23 = new ArrayList<>();

        for (int[] lecture : lectures) {
            sum12.add(lecture[0] + lecture[1]);
            sum13.add(lecture[0] + lecture[2]);
            sum23.add(lecture[1] + lecture[2]);
        }

        Collections.sort(sum12, Collections.reverseOrder());
        Collections.sort(sum13, Collections.reverseOrder());
        Collections.sort(sum23, Collections.reverseOrder());

        int maxSum12 = sumTopK(sum12, K);
        int maxSum13 = sumTopK(sum13, K);
        int maxSum23 = sumTopK(sum23, K);

        return Math.max(Math.max(maxSum12, maxSum13), maxSum23);
    }

    private static int sumTopK(List<Integer> list, int K) {
        int sum = 0;
        for (int i = 0; i < K; i++) {
            sum += list.get(i);
        }
        return sum;
    }
}
