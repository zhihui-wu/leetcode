package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description: 36. 有效的数独
 * @Author: 吴智慧
 * @Date: 2020/12/2 12:19
 * https://leetcode-cn.com/problems/valid-sudoku/
 */
public class ValidSudoku {

    public static void main(String[] args) {

        ValidSudoku validSudoku = new ValidSudoku();

//        char[][] board = new char[][]{
//                {'5','3','.','.','7','.','.','.','.'},
//                {'6','.','.','1','9','5','.','.','.'},
//                {'.','9','8','.','.','.','.','6','.'},
//                {'8','.','.','.','6','.','.','.','3'},
//                {'4','.','.','8','.','3','.','.','1'},
//                {'7','.','.','.','2','.','.','.','6'},
//                {'.','6','.','.','.','.','2','8','.'},
//                {'.','.','.','4','1','9','.','.','5'},
//                {'.','.','.','.','8','.','.','7','9'}};

        char[][] board = new char[][]{
                {'.','.','.','.','5','.','.','1','.'},
                {'.','4','.','3','.','.','.','.','.'},
                {'.','.','.','.','.','3','.','.','1'},
                {'8','.','.','.','.','.','.','2','.'},
                {'.','.','2','.','7','.','.','.','.'},
                {'.','1','5','.','.','.','.','.','.'},
                {'.','.','.','.','.','2','.','.','.'},
                {'.','2','.','9','.','.','.','.','.'},
                {'.','.','4','.','.','.','.','.','.'}};

//        boolean result = validSudoku.isValidSudoku(board);

        /**
         * 尝试优化：一次迭代完成
         */
        boolean result = validSudoku.isValidSudoku1(board);

        System.out.println(result);

    }

    /**
     * 时间复杂度：O（ 9 * 9 * 3 ）
     * 空间复杂度：O（ 10 + 9 ）
     */
    public boolean isValidSudoku(char[][] board) {
        int length = 9;
        int smallLegth = 3;

        Set<Character> setData = new HashSet<>(Arrays.asList(new Character[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '.'}));

        Set<Character> set = new HashSet<>();

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (!setData.contains(board[i][j])) {
                    return false;
                }
                if (board[i][j] != '.' && set.contains(board[i][j])) {
                    return false;
                }
                set.add(board[i][j]);
            }
            set.clear();
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (!setData.contains(board[j][i])) {
                    return false;
                }
                if (board[j][i] != '.' && set.contains(board[j][i])) {
                    return false;
                }
                set.add(board[j][i]);
            }
            set.clear();
        }

        for (int i = 0; i < length; i=i+3) {
            for (int j = 0; j < length; j=j+3) {
                for (int x = i; x < i+smallLegth; x++) {
                    for (int y = j; y < j+smallLegth; y++) {
                        if (!setData.contains(board[x][y])) {
                            return false;
                        }
                        if (board[x][y] != '.' && set.contains(board[x][y])) {
                            return false;
                        }
                        set.add(board[x][y]);
                    }
                }
                set.clear();
            }
        }

        return true;
    }


    public boolean isValidSudoku1(char[][] board) {
        return true;
    }

}
