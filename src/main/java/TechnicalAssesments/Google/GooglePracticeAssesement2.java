package TechnicalAssesments.Google;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

class GooglePracticeAssesement2 {

    static int solution(Integer[] loads) {
        int sum = 0;
        int n = loads.length;
        for (int i = 0; i < n; i++)
            sum += loads[i];

        int targetSum = sum / 2 + 1;
        boolean isPossible[] = new boolean[targetSum];
        boolean tempIsPossible[] = new boolean[targetSum];

        isPossible[0] = true;

        for (int i = 0; i < n; i++) {
            Arrays.fill(tempIsPossible, false);
            for (int j = 0; j + loads[i] < targetSum; j++) {
                if (isPossible[j])
                    tempIsPossible[j + loads[i]] = true;
            }
            for (int j = 0; j < targetSum; j++) {
                if (tempIsPossible[j])
                    isPossible[j] = true;
            }
        }

        for (int i = targetSum - 1; i >= 0; i--) {
            if (isPossible[i])
                return (sum - 2 * i);
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Integer[] loads = getIntegerArray(in.next());

        System.out.print(solution(loads));
    }

    private static Integer[] getIntegerArray(String str) {
        return Stream.of(str.split("\\,"))
                .map(Integer::valueOf)
                .toArray(Integer[]::new);
    }
}
