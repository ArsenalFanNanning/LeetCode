package com.leetcode.one.hundred;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Arsenal
 * @Date: 2022-12-25 19:04
 * @Description: 解数独 -困难
 * 编写一个程序，通过填充空格来解决数独问题。
 * 数独的解法需 遵循如下规则：
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 * 示例 1：
 * 输入：board =
 * [["5","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]]
 * 输出：
 * [["5","3","4","6","7","8","9","1","2"],
 * ["6","7","2","1","9","5","3","4","8"],
 * ["1","9","8","3","4","2","5","6","7"],
 * ["8","5","9","7","6","1","4","2","3"],
 * ["4","2","6","8","5","3","7","9","1"],
 * ["7","1","3","9","2","4","8","5","6"],
 * ["9","6","1","5","3","7","2","8","4"],
 * ["2","8","7","4","1","9","6","3","5"],
 * ["3","4","5","2","8","6","1","7","9"]]
 * 解释：输入的数独如上图所示，唯一有效的解决方案如下所示：
 * 提示：
 * board.length == 9
 * board[i].length == 9
 * board[i][j] 是一位数字或者 '.'
 * 题目数据 保证 输入数独仅有一个解
 * 37. Sudoku Solver
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * A sudoku solution must satisfy all of the following rules:
 * Each of the digits 1-9 must occur exactly once in each row.
 * Each of the digits 1-9 must occur exactly once in each column.
 * Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
 * The '.' character indicates empty cells.
 * Example 1:
 * Input: board =
 * [["5","3",".",".","7",".",".",".","."],
 * ["6",".",".","1","9","5",".",".","."],
 * [".","9","8",".",".",".",".","6","."],
 * ["8",".",".",".","6",".",".",".","3"],
 * ["4",".",".","8",".","3",".",".","1"],
 * ["7",".",".",".","2",".",".",".","6"],
 * [".","6",".",".",".",".","2","8","."],
 * [".",".",".","4","1","9",".",".","5"],
 * [".",".",".",".","8",".",".","7","9"]]
 * Output:
 * [["5","3","4","6","7","8","9","1","2"],
 * ["6","7","2","1","9","5","3","4","8"],
 * ["1","9","8","3","4","2","5","6","7"],
 * ["8","5","9","7","6","1","4","2","3"],
 * ["4","2","6","8","5","3","7","9","1"],
 * ["7","1","3","9","2","4","8","5","6"],
 * ["9","6","1","5","3","7","2","8","4"],
 * ["2","8","7","4","1","9","6","3","5"],
 * ["3","4","5","2","8","6","1","7","9"]]
 * Explanation: The input board is shown above and the only valid solution is shown below:
 * Constraints:
 * board.length == 9
 * board[i].length == 9
 * board[i][j] is a digit or '.'.
 * It is guaranteed that the input board has only one solution.
 */
public class S037 {
    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        solveSudoku(board);

        for (char[] chars : board) {
            System.out.println(Arrays.toString(chars));
        }
    }

    private static boolean[][] line = new boolean[9][9];
    private static boolean[][] column = new boolean[9][9];
    private static boolean[][][] block = new boolean[3][3][9];
    private static boolean valid = false;
    private static List<int[]> spaces = new ArrayList<int[]>();

    public static void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.') {
                    spaces.add(new int[]{i, j});
                } else {
                    int digit = board[i][j] - '0' - 1;
                    line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = true;
                }
            }
        }

        dfs(board, 0);
    }

    public static void dfs(char[][] board, int pos) {
        if (pos == spaces.size()) {
            valid = true;
            return;
        }

        int[] space = spaces.get(pos);
        int i = space[0], j = space[1];
        for (int digit = 0; digit < 9 && !valid; ++digit) {
            if (!line[i][digit] && !column[j][digit] && !block[i / 3][j / 3][digit]) {
                line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = true;
                board[i][j] = (char) (digit + '0' + 1);
                dfs(board, pos + 1);
                line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = false;
            }
        }
    }

    private static int[] lineOpt = new int[9];
    private static int[] columnOpt = new int[9];
    private static int[][] blockOpt = new int[3][3];
    private static boolean validOpt = false;
    private static List<int[]> spacesOpt = new ArrayList<int[]>();

    public static void solveSudokuOpt(char[][] board) {
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.') {
                    spacesOpt.add(new int[]{i, j});
                } else {
                    int digit = board[i][j] - '0' - 1;
                    flipOpt(i, j, digit);
                }
            }
        }

        dfsOpt(board, 0);
    }

    public static void dfsOpt(char[][] board, int pos) {
        if (pos == spacesOpt.size()) {
            valid = true;
            return;
        }

        int[] space = spacesOpt.get(pos);
        int i = space[0], j = space[1];
        int mask = ~(lineOpt[i] | columnOpt[j] | blockOpt[i / 3][j / 3]) & 0x1ff;
        for (; mask != 0 && !validOpt; mask &= (mask - 1)) {
            int digitMask = mask & (-mask);
            int digit = Integer.bitCount(digitMask - 1);
            flipOpt(i, j, digit);
            board[i][j] = (char) (digit + '0' + 1);
            dfs(board, pos + 1);
            flipOpt(i, j, digit);
        }
    }

    public static void flipOpt(int i, int j, int digit) {
        lineOpt[i] ^= (1 << digit);
        columnOpt[j] ^= (1 << digit);
        blockOpt[i / 3][j / 3] ^= (1 << digit);
    }

}
