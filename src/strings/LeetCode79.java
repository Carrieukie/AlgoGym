package strings;

public class LeetCode79 {
//    public static void main(String[] args) {
//        char[][] array = {
//                {'A', 'B', 'C', 'E'},
//                {'S', 'F', 'C', 'S'},
//                {'A', 'D', 'E', 'E'}
//        };
//        System.out.println(exist(array, "SEE"));
//    }

    public static boolean exist(char[][] board, String word) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (exist(board, word, i, j, 0)) return true;
                }
            }
        }
        return false;
    }

    private static boolean exist(char[][] board, String word, int row, int col, int wordIndex) {
        if (row < 0 || col < 0 || row >= board.length || col >= board[row].length || board[row][col] != word.charAt(wordIndex)) {
            return false;
        }
        if (wordIndex == word.length() - 1 && word.charAt(wordIndex) == board[row][col]) {
            return true;
        }
//         Temporarily mark the cell as visited
        char temp = board[row][col];
        board[row][col] = '#';

        boolean exist = exist(board, word, row - 1, col, wordIndex + 1) ||
                exist(board, word, row + 1, col, wordIndex + 1) ||
                exist(board, word, row, col + 1, wordIndex + 1) ||
                exist(board, word, row, col - 1, wordIndex + 1);

//         Restore the cell's original value
        board[row][col] = temp;

        return exist;

    }

}
