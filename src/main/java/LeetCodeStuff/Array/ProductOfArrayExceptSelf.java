package LeetCodeStuff.Array;
import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    
    public int[] productExceptSelf(int[] nums) {
        int [] result = new int[nums.length];
        Arrays.fill(result, 1);

        // multiply each entry by the product before the entry
        int beforeProduct= 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] *= beforeProduct;

            // multiply running product afterwards so we don't include it
            beforeProduct *= nums[i];
        }

        // multiply each entry by the product before after the entry
        int afterProduct= 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= afterProduct;

            // multiply running product afterwards so we don't include it
            afterProduct *= nums[i];
        }
        
        return result;
    }
}
