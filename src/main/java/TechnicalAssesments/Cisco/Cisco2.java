package TechnicalAssesments.Cisco;

import java.util.*;

public class Cisco2 {

	public static void  maxSum(int[] inputArr)
	{
		int n = inputArr.length;
		int[] dp = new int[n];
        dp[0] = inputArr[0];
        dp[1] = Math.max(inputArr[0], inputArr[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + inputArr[i]);
        }

        System.out.println(dp[n - 1]);
		
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		//input for inputArr
		int inputArr_size = in.nextInt();
		int inputArr[] = new int[inputArr_size];
		for(int idx = 0; idx < inputArr_size; idx++)
		{
			inputArr[idx] = in.nextInt();
		}
		
		
		maxSum(inputArr);
	}
}