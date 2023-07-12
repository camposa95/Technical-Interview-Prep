package TechnicalAssesments.JPMorgan;

public class JpMorgan2 {
    public static int deleteProducts(List<Integer> ids, int m) {
        Map<Integer, Integer> idCountMap = new HashMap<>();

        // Count the occurrences of each ID
        for (int id : ids) {
            idCountMap.put(id, idCountMap.getOrDefault(id, 0) + 1);
        }

        // Sort the ID counts in ascending order
        List<Integer> counts = new ArrayList<>(idCountMap.values());
        Collections.sort(counts);

        int distinctIDs = idCountMap.size();
        int deletions = 0;

        // Iterate through the counts and remove items until the maximum number of deletions is reached
        for (int count : counts) {
            if (deletions + count <= m) {
                distinctIDs--;
                deletions += count;
            } else {
                break;
            }
        }

        return distinctIDs;
    }
}
