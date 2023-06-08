package LeetCodeStuff;
import java.util.HashSet;

public class ContainsDuplicate {
    
    public boolean containsDuplicate(int[] nums) {

        HashSet<Integer> containedNums = new HashSet<>();
        for (int num: nums) {
            if (!containedNums.add(num)) {
                return true;
            }
        }

        return false;
    }
}
