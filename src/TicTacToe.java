public class TicTacToe {

    // 井字遊戲
    public static boolean validBoard(String[] board) {
        // X贏了  X-O=1
        // O贏了  X-O=0
        // 平手   X-O=1 or 0
        int xCount = 0, oCount =0;
        for (String row : board) {
            for (char c : row.toCharArray()) {
                if (c == 'X') {
                    xCount++;
                }
                if (c == 'O') {
                    oCount++;
                }
            }
        }
        if (xCount != oCount && xCount -oCount != 1) {
            return false;
        }
        if (win(board, "XXX") && xCount - oCount != 1) {
            return false;
        }
        if (win(board, "OOO") && xCount - oCount != 0) {
            return false;
        }
        return true;
    }

    static boolean win(String[] board, String flag) {
        for (int i =0; i < 3; i++) {
            // 縱向三連
            if (flag.equals("" + board[0].charAt(i) + board[1].charAt(i) + board[2].charAt(i))) {
                return true;
            }
            // 橫向三連
            if (flag.equals(board[i])) {
                return true;
            }
        }

        // 對角線
        if (flag.equals(flag.equals("" + board[0].charAt(0) + board[1].charAt(1) + board[2].charAt(2)))) {
            return true;
        }
        if (flag.equals(flag.equals("" + board[0].charAt(2) + board[1].charAt(1) + board[2].charAt(0)))) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(validBoard(new String[]{"XXX", " XO", "O O"}));
    }

}
