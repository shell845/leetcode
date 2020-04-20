package leetcodemainset;

/**
 * @author YC 03/22/2020
 */

public class _79_WorkSearch {
    /** Complexity O(MN3^k), Space O(MN) for system recursion call */
    public boolean exist(char[][] board, String word) {
        if (board == null || word == null) return false;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                // starting point
                if (dfs(board, i, j, word, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int k) {
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[i].length - 1 || board[i][j] != word.charAt(k)) return false;
        if (k == word.length() - 1) return true;
        char mask = board[i][j];
        board[i][j] = '*';
        boolean result = dfs(board, i - 1, j, word, k + 1) ||
                dfs(board, i + 1, j, word, k + 1) ||
                dfs(board, i, j - 1, word, k + 1) ||
                dfs(board, i, j + 1, word, k + 1);
        board[i][j] = mask;
        return result;
    }

    public static void main(String[] args) {
        /*char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};*/
        char[][] board = new char[][] {{'a','b'}};
        _79_WorkSearch w = new _79_WorkSearch();
        int b = 50;
        System.out.println("hi" + b);
    }
}
