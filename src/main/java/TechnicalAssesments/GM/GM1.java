package TechnicalAssesments.GM;

public class GM1 {
    public int solution(int[] A) {
        /**
         * 
         * white a function that, given an array A, returns the minimum number of multiplications needed to create the described sequence,
         * or −1 if it is not possible.

            Examples:
                For A = [1, 0, 3, 4, 5, 0, 6], one of the optimal solutions is to multiply 3 by −2, 4 by 0 and 6 by −1.
                After these changes, A will transform to [1, 0, −6, 0, 5, 0, −6]. 
                The signs of the consecutive elements will be [+, 0, −, 0, +, 0, −], 
                as required in the task statement. The function should return 3.

                For A = [7, 4, −3, 0, −5, 1, 0], it is not possible to convert the last zero into a negative number. 
                The function should return −1.

                For A = [−5, 0, 3, 0], the function should return 2.

            Assume that:
                N is an integer within the range [1..100];
                each element of array A is an integer within the range [−20..20].
                In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.
         */

        int count = 0;
        for (int i = 0; i < A.length; i++) {
            boolean shouldbePositive = i % 3 == 0;
            boolean shouldBeZero = i % 2 == 1;

            if (shouldBeZero) {
                if (A[i] != 0) { // not zero
                    count++;
                }
            } else { // should not be zero
                if (A[i] == 0) { // is zero
                    return -1; // because it is not possible to convert the last zero into a negative number or possitive
                } else { // not zero
                    if (shouldbePositive) {
                        if (A[i] < 0) { // is negative
                            count++;
                        }
                    } else { // should be negative
                        if (A[i] > 0) { // is positive
                            count++;
                        }
                    }

                }
            }
        }

        return count;
        
    }
}
