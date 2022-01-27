package pl.klimas7.learn.sudoku;

public class Solver {
    public static final int GRID_SIZE = 9;

    private static int[][] grid = {
            {0, 0, 7, 0, 6, 1, 0, 2, 0},
            {0, 4, 0, 0, 5, 0, 0, 0, 0},
            {6, 0, 1, 0, 0, 2, 5, 4, 7},
            {4, 1, 0, 8, 2, 5, 0, 0, 9},
            {0, 0, 0, 3, 4, 7, 0, 6, 0},
            {2, 7, 3, 1, 9, 0, 0, 0, 0},
            {3, 8, 9, 0, 7, 0, 0, 5, 0},
            {0, 6, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0}
    };


    public static void main(String[] args) {
        print(grid);
        System.out.println("======");
        if (solve(grid)) {
            System.out.println("Success");
            print(grid);
        } else {
            System.out.println("Something wrong");
        }
    }

    private static boolean solve(int[][] grid) {
        for (int row = 0; row < GRID_SIZE; row++) {
            for (int column = 0; column < GRID_SIZE; column++) {
                if (grid[row][column] == 0) {
                    for (int x = 1; x <= GRID_SIZE; x++) {
                        if (isValid(grid, row, column, x)) {
                            grid[row][column] = x;
                            if (solve(grid)) {
                                return true;
                            } else {
                                grid[row][column] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
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
