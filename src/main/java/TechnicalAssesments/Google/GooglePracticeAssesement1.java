package TechnicalAssesments.Google;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.stream.Stream;

class GooglePracticeAssesement1 {

    static int solution(Integer[] A) {

        HashMap<HashSet<Integer>, Integer> rowToMinHeight = new HashMap<>();
        int numRows = 0;

        // iterate through the array
        for (Integer height : A) {
            HashSet<Integer> rowWhereAllTaller = null;

            // iterate through the rows
            for (HashSet<Integer> row : rowToMinHeight.keySet()) {
                if (rowToMinHeight.get(row) > height) {
                    rowWhereAllTaller = row;
                }
            }

            if (rowWhereAllTaller == null) { // there exists no row where everyone is taller than this student
                HashSet<Integer> newRow = new HashSet<>();
                newRow.add(height);
                rowToMinHeight.put(newRow, height);
                numRows++;
            } else { // there exists a row where everyone is taller than this student
                rowWhereAllTaller.add(height);

                Integer newMinHeight = Math.min(rowToMinHeight.get(rowWhereAllTaller), height);

                rowToMinHeight.put(rowWhereAllTaller, newMinHeight);
            }
        }

        return numRows;
    }

    public static void main(String[] args) {
        // Read from stdin, solve the problem, write answer to stdout.
        Scanner in = new Scanner(System.in);
        Integer[] A = getIntegerArray(in.next());

        System.out.print(solution(A));
    }

    private static Integer[] getIntegerArray(String str) {
        return Stream.of(str.split("\\,"))
                .map(Integer::valueOf)
                .toArray(Integer[]::new);
    }
}
