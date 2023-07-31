import java.util.Scanner;

public class TicTacToe {

    private static final int ROW = 3;
    private static final int COL = 3;
    private static String board[][] = new String[ROW][COL];
    private static String player = "X";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        clearBoard();
        display();

        while(true) {
            int row;
            int col;
            do {
                row = SafeInput.getRangedInt(in, "Player " + player + " Please choose which row 0-2", 0, 2);
                col = SafeInput.getRangedInt(in, "Player " + player + " Please choose which column 0-2", 0, 2);

            } while (!isValidMove(row, col));
            board[row][col] = player;
            display();

            if (isWin(player)) {
                System.out.println("Player " + player + " wins!");
                break;
            } else if (isTie()) {
                System.out.println("CAT GAME");
                break;
            }

            if (player.equals("X")) {
                player = "O";
            }
            else {
                player = "X";
            }
        }

    }

    private static void clearBoard() {
        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                board[row][col] = " ";
            }
        }
    }
    private static void display() {
        System.out.println("-------------");
        for (int row = 0; row < ROW; row++) {
            System.out.print("| ");
            for (int col = 0; col < COL; col++) {
                System.out.print(board[row][col] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    private static boolean isValidMove(int row, int col){
        if (row < 0 || row >= ROW || col < 0 || col >= COL) {
            System.out.println("Invalid move. Row and column must be between 0 and 2.");
            return false;
        }
        if (!board[row][col].equals(" ")) {
            System.out.println("Invalid move. Cell already taken.");
            return false;
        }
        return true;
    }


    private static boolean isWin(String player){
        return (isRowWin(player) || isColWin(player) || isDiagonalWin(player));
    }
    private static boolean isColWin(String player){
        for (int col = 0; col < COL; col++) {
            if (board[0][col].equals(player) && board[1][col].equals(player) && board[2][col].equals(player)) {
                return true;
            }
        }
        return false;

    }
    private static boolean isRowWin(String player){
        for (int row = 0; row < ROW; row++) {
            if (board[row][0].equals(player) && board[row][1].equals(player) && board[row][2].equals(player)) {
                return true;
            }
        }
        return false;

    }
    private static boolean isDiagonalWin(String player){
        return ((board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) ||
                (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player)));
    }
    private static boolean isTie(){
        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                if (board[row][col] == " ") {
                    return false;
                }
            }
        }
        return true;
   }
}


