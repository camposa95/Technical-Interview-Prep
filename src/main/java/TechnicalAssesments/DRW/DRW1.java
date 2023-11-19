package TechnicalAssesments.DRW;

public class DRW1 {
    public int solution(int[] A) {
        // Get the bitwise AND of all elements in the array
        int result = A[0];
        for (int i = 1; i < A.length; i++) {
            result &= A[i];
        }

        // Count the number of trailing zeros in the bitwise AND result
        int count = 0;
        while (result % 2 == 0) {
            result >>= 1;
            count++;
        }

        // Return the size of the largest possible subset
        return (int) Math.pow(2, count);
    }
}
