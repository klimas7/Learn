package pl.klimas7.learn.sudoku;

public class Solver {
    public static final int GRID_SIZE = 9;

    private static int[][] grid = {
            {0, 0, 0, 0, 0, 1, 0, 0, 6},
            {6, 0, 0, 0, 8, 7, 4, 1, 0},
            {0, 4, 8, 6, 0, 0, 0, 0, 2},
            {7, 1, 0, 4, 5, 2, 0, 0, 8},
            {3, 0, 9, 0, 0, 6, 2, 4, 5},
            {2, 0, 4, 0, 0, 3, 0, 0, 1},
            {0, 6, 0, 0, 1, 0, 9, 2, 7},
            {0, 3, 2, 0, 6, 0, 1, 5, 0},
            {0, 7, 0, 9, 2, 5, 0, 0, 0}
    };

    private static int recursive_level = 0;

    public static void main(String[] args) {
        print(grid);
        System.out.println("[" + recursive_level +"] " + "======");
        if (solve(grid)) {
            System.out.println("[" + recursive_level +"] " + "Success");
            print(grid);
        } else {
            System.out.println("Something wrong");
        }
    }

    private static boolean solve(int[][] grid) {
        recursive_level++;
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int column = 0; column < GRID_SIZE; column++) {
                if (grid[row][column] == 0) {
                    for (int x = 1; x <= GRID_SIZE; x++) {
                        if (isValid(grid, row, column, x)) {
                            System.out.println("[" + recursive_level +"] " + row + " " + column + " -> " + x);
                            grid[row][column] = x;
                            if (solve(grid)) {
                                recursive_level--;
                                System.out.println("[" + recursive_level +"]");
                                return true;
                            } else {
                                System.out.println("[" + recursive_level +"] " + row + " " + column + " -> " + 0);
                                grid[row][column] = 0;
                            }
                        }
                    }
                    recursive_level--;
                    System.out.println("[" + recursive_level +"]");
                    return false;
                }
            }
        }
        recursive_level--;
        System.out.println("[" + recursive_level +"]");
        return true;
    }

    private static boolean isValid(int[][] grid, final int row, final int column, final int number) {
        return !isNumberInRow(grid, row, number)
                && !isNumberInColumn(grid, column, number)
                && !isNumberInBox(grid, row, column, number);
    }

    private static boolean isNumberInRow(final int[][] grid, final int row, final int number) {
        for (int column = 0; column < GRID_SIZE; column++ ){
            if (grid[row][column] == number) {
                return true;
            }
        }
        return false;
    }

    private static boolean isNumberInColumn(final int[][] grid, final int column, final int number) {
        for (int row = 0; row < GRID_SIZE; row++ ){
            if (grid[row][column] == number) {
                return true;
            }
        }
        return false;
    }

    private static boolean isNumberInBox(final int[][] grid, final int row, final int column, final int number) {
        int startRow = (row / 3) * 3;
        int startColumn = (column / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startColumn; j < startColumn + 3; j++) {
                if (grid[i][j] == number) {
                    return true;
                }
            }
        }
        return false;
    }


    private static void print(final int[][] box) {
        for (int row = 0; row < GRID_SIZE; row++) {
            if (row == 3 || row == 6) {
                System.out.println("------------");
            }
            for (int column = 0; column < GRID_SIZE; column++) {
                if (column == 3 || column == 6) {
                    System.out.print("|");
                }
                System.out.print(box[row][column]);
            }
            System.out.println();
        }
    }
}
