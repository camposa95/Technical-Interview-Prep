package TechnicalAssesments.Citadel;

public class Citadel1 {

    /*
     * Complete the 'findNumberOfWays' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters
     * 1. INTEGER n_intervals
     * 2. INTEGER n_processes
	 */

	class Result {

    /*
     * Complete the 'bestSumDownwardTreePath' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY parent
     *  2. INTEGER_ARRAY values
     */
     
     static int bestPath = Integer.MIN_VALUE;

    public static int bestSumDownwardTreePath(List<Integer> parent, List<Integer> values) {
        
        if(parent.size() == 1) return values.get(0);
        
        
        Map<Integer, List<Integer>> tree = new HashMap<>();
        for(int i = 1; i < parent.size(); i++) {
            List<Integer> temp = tree.getOrDefault(parent.get(i), null);
            if(temp == null) {
                temp = new ArrayList<>();
                temp.add(i);
                tree.put(parent.get(i), temp);
            }
            
            else {
                temp.add(i);
            }
        }
        
        findBestSum(parent, values, tree, 0, 0);
        
        return bestPath;

    }
    
    public static void findBestSum(List<Integer> parent, List<Integer> values, 
                            Map<Integer, List<Integer>> tree, int root, int sum) {
                                
        
        
        sum = sum + values.get(root);
        bestPath = Math.max(bestPath, sum);
        sum = Math.max(0, sum);
        
        if(tree.get(root) == null) return;
        
        for(Integer child: tree.get(root)) {
            findBestSum(parent, values, tree, child, sum);
        }
        
    }

}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int parentCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> parent = IntStream.range(0, parentCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int valuesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> values = IntStream.range(0, valuesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.bestSumDownwardTreePath(parent, values);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
}
