package TechnicalAssesments.Cisco;

import java.util.Scanner;

public class Cisco3 {
    public static void  funcCount(int inputNum1, int inputNum2) {
		
        int count = 0;
		for (int i = 0; i <= inputNum1; i++) {
			String currentNumber = Integer.toString(i);

			int digitsSum = Character.getNumericValue(currentNumber.charAt(0));
			if (currentNumber.length() > 1) {
				for (int j = 1; j < currentNumber.length(); j++) {
                    digitsSum += Character.getNumericValue(currentNumber.charAt(j));
				}
			}

            if (digitsSum == inputNum2) {
                count++;
            }

        }

        System.out.print(count);
	}

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		// input for inputNum1
		int inputNum1 = in.nextInt();
		
		// input for inputNum2
		int inputNum2 = in.nextInt();
		
		
		
		funcCount(inputNum1, inputNum2);
	}
}
