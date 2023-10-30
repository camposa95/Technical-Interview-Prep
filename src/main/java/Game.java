import java.util.Random;

public class Game {

    public static int[][] startGame() {
        int[][] mat = new int[4][4];

        System.out.println("Commands are as follows : ");
        System.out.println("'W' or 'w' : Move Up");
        System.out.println("'S' or 's' : Move Down");
        System.out.println("'A' or 'a' : Move Left");
        System.out.println("'D' or 'd' : Move Right");

        addNew2(mat);
        return mat;
    }

    public static void addNew2(int[][] mat) {
        Random random = new Random();
        int row;
        int col;
    
        while (true) {
            row = random.nextInt(4);
            col = random.nextInt(4);
    
            if (mat[row][col] == 0) {
                mat[row][col] = 2;
                break; // Exit the loop once a valid position is found
            }
        }
    }

    public static String getCurrentState(int[][] mat) {
        // have 2048 we win
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (mat[i][j] == 2048) {
                    return "WON";
                }
            }
        }

        // have empty we can still go
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (mat[i][j] == 0) {
                    return "GAME NOT OVER";
                }
            }
        }

        // If we can make a move and combine then we are still good
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int currentCellValue = mat[i][j];
                
                // Check right (horizontal)
                if (j < 3 && currentCellValue == mat[i][j + 1]) {
                    return "GAME NOT OVER";
                }
                
                // Check down (vertical)
                if (i < 3 && currentCellValue == mat[i + 1][j]) {
                    return "GAME NOT OVER";
                }
            }
        }


        return "LOST"; // no other options we lose
    }

    public static int[][] compress(int[][] mat) {
        boolean changed = false;
        int[][] newMat = new int[4][4];

        for (int i = 0; i < 4; i++) {
            int pos = 0;
            for (int j = 0; j < 4; j++) {
                if (mat[i][j] != 0) {
                    newMat[i][pos] = mat[i][j];
                    if (j != pos) {
                        changed = true;
                    }
                    pos++;
                }
            }
        }

        return newMat;
    }

    public static int[][] merge(int[][] mat) {
        boolean changed = false;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (mat[i][j] == mat[i][j + 1] && mat[i][j] != 0) {
                    mat[i][j] = mat[i][j] * 2;
                    mat[i][j + 1] = 0;
                    changed = true;
                }
            }
        }

        return mat;
    }

    public static int[][] reverse(int[][] mat) {
        int[][] newMat = new int[4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                newMat[i][j] = mat[i][3 - j];
            }
        }

        return newMat;
    }

    public static int[][] transpose(int[][] mat) {
        int[][] newMat = new int[4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                newMat[i][j] = mat[j][i];
            }
        }

        return newMat;
    }

    public static int[][] moveLeft(int[][] grid) {
        int[][] newGrid;
        boolean changed1, changed2;

        newGrid = compress(grid);
        changed1 = !compareGrids(newGrid, grid);

        newGrid = merge(newGrid);
        changed2 = !compareGrids(newGrid, grid);

        boolean changed = changed1 || changed2;

        newGrid = compress(newGrid);

        return newGrid;
    }

    public static int[][] moveRight(int[][] grid) {
        int[][] newGrid;

        newGrid = reverse(grid);

        newGrid = moveLeft(newGrid);

        newGrid = reverse(newGrid);

        return newGrid;
    }

    public static int[][] moveUp(int[][] grid) {
        int[][] newGrid;

        newGrid = transpose(grid);

        newGrid = moveLeft(newGrid);

        newGrid = transpose(newGrid);

        return newGrid;
    }

    public static int[][] moveDown(int[][] grid) {
        int[][] newGrid;

        newGrid = transpose(grid);

        newGrid = moveRight(newGrid);

        newGrid = transpose(newGrid);

        return newGrid;
    }

    public static boolean compareGrids(int[][] grid1, int[][] grid2) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (grid1[i][j] != grid2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
