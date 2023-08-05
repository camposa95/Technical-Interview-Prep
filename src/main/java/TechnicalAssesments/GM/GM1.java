package TechnicalAssesments.GM;

public class GM1 {
    public int solution(int[] A) {
        int n = A.length;
        int count = 0;

        for (int i = 0; i < n; i += 2) {
            if (A[i] <= 0) {
                if (i + 1 < n && A[i + 1] == 0) {
                    return -1; // If there's a 0 after a non-positive number, it's not possible
                }
                if (i + 1 < n && A[i + 1] > 0) {
                    int factor = -A[i] + 1;
                    A[i] *= factor;
                    A[i + 1] /= factor;
                    count++;
                }
            } else {
                if (i + 1 < n && A[i + 1] == 0) {
                    int factor = A[i] + 1;
                    A[i] *= factor;
                    A[i + 1] /= factor;
                    count++;
                }
            }
        }

        return count;
    }
}
