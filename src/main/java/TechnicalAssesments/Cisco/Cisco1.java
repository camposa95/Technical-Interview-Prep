package TechnicalAssesments.Cisco;

import java.util.HashSet;

public class Cisco1 {
    public static void  funcPuzzle(char[][] grid, String[] word) {
		
		// create a set of all words possible from the given grid
        HashSet<String> possibleWords = new HashSet<>();
 

        // create horizontal words
        for (int i = 0; i < grid.length; i++) {
            String newWord = "";
            for (int j = 0; j < grid[i].length; j++) {
                newWord += grid[i][j];
            }

            // add the word to the set in regular spelling and reverse spelling
            possibleWords.add(newWord);
            possibleWords.add(new StringBuilder(newWord).reverse().toString());
        }

        // create vertical words
        for (int i = 0; i < grid[0].length; i++) {
            String newWord = "";
            for (int j = 0; j < grid.length; j++) {
                newWord += grid[j][i];
            }
            // add the word to the set in regular spelling and reverse spelling
            possibleWords.add(newWord);
            possibleWords.add(new StringBuilder(newWord).reverse().toString());
        }

        // create a new set of all possible substrings that can be made from possible words
        HashSet<String> possibleSubstrings = new HashSet<>();
        for (String s : possibleWords) {
            for (int i = 0; i < s.length(); i++) {
                for (int j = i + 1; j <= s.length(); j++) {
                    possibleSubstrings.add(s.substring(i, j));
                }
            }
        }

        // for each given word, check it it is equal to any of the possible substrings, if so
        // print yes, else no, these must be printed on same line
        for (String s : word) {
            if (possibleSubstrings.contains(s)) {
                System.out.print("Yes ");
            } else {
                System.out.print("No ");
            }
        }

    }
		
}

