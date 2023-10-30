package TechnicalAssesments.WolverineTrading;

import java.util.Arrays;
import java.util.List;

public class WT1 {
    /*
     * Complete the 'countOperations' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY p as parameter.
     */

    public static int countOperations(List<Integer> p) {
        int[] p1 = p.stream().mapToInt(Integer::intValue).toArray();
        int[] arr = Arrays.copyOf(p1, p1.length);
        
        arr = permutate(arr, p1);
        int count = 1;
        while (!Arrays.equals(arr, p1)) {
            arr = permutate(arr, p1);
            count++;
        }

        return count;
    }
    
    public static int[] permutate(int[] input, int[] p) {
        int[] temp = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            temp[i] = input[p[i] - 1];
        }
        
        return temp;
    }
}
