import java.util.Arrays;

public class MiniSpreadsheets {

    Cell[][] cells;

    public MiniSpreadsheets(int rows, int cols) {
        cells = new Cell[rows][cols];
        for (int i = 0; i < cells.length; i++) {
            Arrays.fill(cells[i], null);
        }
    }

    // ----------------------------------------------------
    //
    // Input Utility Classes
    //
    // ----------------------------------------------------

    class Coordinates {
        int row;
        int col;
        
        Coordinates(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    class Range {
        Coordinates start;
        Coordinates end;
        
        Range(Coordinates start, Coordinates end) {
            this.start = start;
            this.end = end;
        }
    }

    // ----------------------------------------------------
    //
    // Cell Utility Classes
    //
    // ----------------------------------------------------

    interface Cell {
        public Object getValue();
    }

    class Value implements Cell {

        Integer value;

        Value(Integer value) {
            this.value = value;
        }
        
        public Integer getValue() {
            return this.value;
        }

    }

    abstract class Operation implements Cell {
        Coordinates location; // location of the cell with the result
        Range range; // range of cells to sum
        
        Operation(Coordinates location, Range range) {
            this.location = location;
            this.range = range;
        }
    }

    class Sum extends Operation {

        Sum(MiniSpreadsheets.Coordinates location, MiniSpreadsheets.Range range) {
            super(location, range);
        }

        public Object getValue() {
            Integer sum = 0;

            for (int i = range.start.row; i < range.end.row; i++) {
                for (int j = range.start.col; j < range.end.col; j++) {
                    Object currentValue = cells[i][j].getValue();
                    if (currentValue == null || ((String) currentValue).equals("Error")) {
                        return "Error";
                    } else {
                        sum += (Integer) currentValue;
                    }
                }
            }

            return sum;
        }
    }

    class Product extends Operation {
        
        Product(MiniSpreadsheets.Coordinates location, MiniSpreadsheets.Range range) {
            super(location, range);
        }

        public Object getValue() {
            Integer product = 1;

            for (int i = range.start.row; i < range.end.row; i++) {
                for (int j = range.start.col; j < range.end.col; j++) {
                    Object currentValue = cells[i][j].getValue();
                    if (currentValue == null || ((String) currentValue).equals("Error")) {
                        return "Error";
                    } else {
                        product *= (Integer) currentValue;
                    }
                }
            }

            return product;
        }
    }

    class Max extends Operation {

        Max(MiniSpreadsheets.Coordinates location, MiniSpreadsheets.Range range) {
            super(location, range);
        }

        public Object getValue() {
            Integer max = Integer.MIN_VALUE;

            for (int i = range.start.row; i < range.end.row; i++) {
                for (int j = range.start.col; j < range.end.col; j++) {
                    Object currentValue = cells[i][j].getValue();
                    if (currentValue == null || ((String) currentValue).equals("Error")) {
                        return "Error";
                    } else {
                        max = Math.max(max, (Integer) currentValue);
                    }
                }
            }

            return max;
        }
    }
    

    // ----------------------------------------------------
    //
    // Public Methods
    //
    // ----------------------------------------------------

    public void setCell(Coordinates location, int value) {
        growIfNeeded(location);
        cells[location.row][location.col] = new Value(value);
    }

    public void clearCell(Coordinates location) {
        cells[location.row][location.col] = null;
    }

    public void setCellSum(Coordinates location, Range range) {
        growIfNeeded(location);
        cells[location.row][location.col] = new Sum(location, range);
    }

    public void setCellProduct(Coordinates location, Range range) {
        growIfNeeded(location);
        cells[location.row][location.col] = new Product(location, range);
    }

    public void setCellMax(Coordinates location, Range range) {
        growIfNeeded(location);
        cells[location.row][location.col] = new Max(location, range);
    }

    public Object[][] output() {
        Object[][] output = new Object[cells.length][cells[0].length];
        for (int i = 0; i < output.length; i++) {
            Arrays.fill(output[i], null);
        }


        for (int i = 1; i < cells.length; i++) {
            for (int j = 1; j < cells[1].length; j++) {
                
                if (cells[i][j] != null) {
                    output[i][j] = cells[i][j].getValue();
                }
            }
        }
        
        return output;
    }

    public void printSheet() {
        Object[][] result = output();
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j]);
                System.out.print(" ");
            }
            
            System.out.println();
        }
    }

    // ----------------------------------------------------
    //
    // Helpers
    //
    // ----------------------------------------------------

    private void growIfNeeded(Coordinates location) {

        int currentRows = cells.length;
        int currentCols = cells[0].length;

        if (location.row >= currentRows || location.col >= currentCols) {
            // Calculate the new dimensions for the resized array
            int newRows = Math.max(location.row + 1, currentRows);
            int newCols = Math.max(location.col + 1, currentCols);

            // Create a new resized array with the specified value
            Cell[][] newArr = new Cell[newRows][newCols];

            // Copy the existing values to the new array
            for (int i = 0; i < currentRows; i++) {
                System.arraycopy(cells[i], 0, newArr[i], 0, currentCols);
            }

            // Update the original array with the resized one
            cells = newArr;
        }
    }
}
