package TechnicalAssesments.GM;

public class GM1 {
    public int solution(int[] A) {
        int n = A.length;
        int count = 0;
        boolean positive = true;

        for (int i = 0; i < n; i++) {
            if (positive) {
                if (A[i] <= 0) {
                    int factor = 1 - A[i];
                    A[i] *= factor;
                    count++;
                }
                positive = false;
            } else {
                if (A[i] >= 0) {
                    int factor = A[i] + 1;
                    A[i] *= factor;
                    count++;
                }
                positive = true;
            }
        }

        return count;
    }
}
