package LeetCodeStuff.Array;
import java.util.HashMap;

public class TwoSum {
    
    public int[] twoSum(int[] nums, int target) {

        int[] solution = new int[2];

        HashMap<Integer, Integer> numToIndex = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int currentNum = nums[i];
            int complement = target - currentNum;

            if (numToIndex.containsKey(complement)) {
                solution[0] = i;
                solution[1] = numToIndex.get(complement);
                break;
            }

            numToIndex.put(currentNum, i);
        }


        return solution;
    }
}
