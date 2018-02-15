package game.objects;

public class Game {

    private static boolean end = false;
    private static int turn = 0;
    private static boolean standard;
    private static int size;
    private static int players;
    private static int[][] board;
    private static boolean canPlace = true;

    /**
     * 
     * @return the variable end
     */
    public static boolean isEnd() {
        return end;
    }

    /**
     * 
     * @param end
     *            the value to be placed in the variable end
     */
    public static void setEnd(boolean end) {
        Game.end = end;
    }

    /**
     * 
     * @return the variable turn
     */
    public static int getTurn() {
        return turn;
    }

    /**
     * 
     * @param turn
     *            the value to be placed in the variable turn
     */
    public static void setTurn(int turn) {
        Game.turn = turn;
    }

    /**
     * 
     * @return the variable standard
     */
    public static boolean isStandard() {
        return standard;
    }

    /**
     * 
     * @param standard
     *            the boolean value to be placed in the variable standard
     */
    public static void setStandard(boolean standard) {
        Game.standard = standard;
    }

    /**
     * 
     * @return the variable size
     */
    public static int getSize() {
        return size;
    }

    /**
     * 
     * @param size
     *            the value to be placed in the variable standard
     */
    public static void setSize(String size) {
        Game.size = Integer.parseInt(size);
    }

    /**
     * 
     * @return the variable players
     */
    public static int getPlayers() {
        return players;
    }

    /**
     * 
     * @param players
     *            the value to be placed in the variable players
     */
    public static void setPlayers(String players) {
        Game.players = Integer.parseInt(players);
    }

    /**
     * 
     * @return the game board
     */
    public static int[][] getBoard() {
        return board;
    }

    /**
     * 
     * @param board
     *            set the game board
     */
    public static void setBoard(int[][] board) {
        Game.board = board;
    }

    /**
     * 
     * @param row
     *            the row where the value should be placed
     * @param col
     *            the column where the value should be placed
     * @param value
     *            the value that needs to be placed
     */
    public static void place(int row, int col, int value) {
        Game.board[row][col] = value;
    }

    /**
     * 
     * @return the variable canPlace
     */
    public static boolean canPlace() {
        return canPlace;
    }

    /**
     * 
     * @param canPlace
     *            the value to be placed in the variable canPlace
     */
    public static void setCanPlace(boolean canPlace) {
        Game.canPlace = canPlace;
    }
}
