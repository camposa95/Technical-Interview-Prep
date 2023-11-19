package TechnicalAssesments.Google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class GoogleAssesement1 {
    
    public static int solution(String S) {
        
        List<String> reserveredSeats =  new ArrayList<>();
        for (int i = 0; i < S.length(); i += 2) {
            String seat = S.substring(i, i + 2);
            reserveredSeats.add(seat);
        }

        // Map the row letter to and array of booleans where the index is the seat number, and the value is true if the seat is reserved
        HashMap<Character, Boolean[]> rows = new HashMap<>();
        // make the 0th index already reserved so that we can use 1-9 as the index to mate domain logic easier
        for (char c = 'A'; c <= 'E'; c++) {
            rows.put(c, new Boolean[10]);
            rows.get(c)[0] = true;
        }


        // now go though the list of reserved seats and mark them as reserved in the map
        for (String seat : reserveredSeats) {
            char row = seat.charAt(0);
            int seatNumber = Integer.parseInt(seat.substring(1));
            rows.get(row)[seatNumber] = true;
        }

        // now go through the map and find the largest number of consecutive free seats that are located in a row
        int max = 0;
        for (char row = 'A'; row <= 'E'; row++) {
            Boolean[] seats = rows.get(row);
            int count = 0;
            for (int i = 1; i < seats.length; i++) {
                if (seats[i] == null) {
                    count++;
                } else {
                    count = 0;
                }
                max = Math.max(max, count);
            }
        }

        return max;
      }
}
