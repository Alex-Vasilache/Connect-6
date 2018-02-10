package game.logic;

import edu.kit.informatik.Terminal;
import game.errors.InvalidInputException;
import game.io.GamePrint;

public class Game {

    private static boolean end = false;
    private static int turn = 0;
    private static boolean standard;
    private static int size;
    private static int players;
    private static int[][] board;

    public static void splitter(String input) {

        String[] parts = input.split(" ", 2);

        switch (parts[0]) {
        case "place": {

            try {
                Instructions.place(parts[1]);
                setTurn((getTurn() + 1));
                Terminal.printLine("OK");
            } catch (InvalidInputException e) {
                Terminal.printError("Invalid Inputs");
            }

            break;
        }
        case "rowprint": {

            try {
                GamePrint.rowPrint(parts[1]);
            } catch (InvalidInputException e) {
                Terminal.printError("WRITESOMETHING");
            }

            break;
        }
        case "colprint": {

            try {
                GamePrint.colPrint(parts[1]);
            } catch (InvalidInputException e) {
                Terminal.printError("WRITESOMETHING");
            }

            break;
        }
        case "print": {

            try {
                GamePrint.print(parts[1]);
            } catch (InvalidInputException e) {
                Terminal.printError("WRITESOMETHING");
            }

            break;
        }
        case "state": {

            try {
                GamePrint.state(parts[1]);
            } catch (InvalidInputException e) {
                Terminal.printError("WRITESOMETHING");
            }

            break;
        }
        case "reset": {
            Instructions.reset();
            break;
        }
        case "quit": {
            setEnd(true);
            break;
        }
        default:
            Terminal.printError("Instruction not valid");
        }
    }

    public static boolean isEnd() {
        return end;
    }

    public static void setEnd(boolean end) {
        Game.end = end;
    }

    public static int getTurn() {
        return turn;
    }

    public static void setTurn(int turn) {
        Game.turn = turn;
    }

    public static boolean isStandard() {
        return standard;
    }

    public static void setStandard(boolean standard) {
        Game.standard = standard;
    }

    public static int getSize() {
        return size;
    }

    public static void setSize(String size) {
        Game.size = Integer.parseInt(size);
    }

    public static int getPlayers() {
        return players;
    }

    public static void setPlayers(String players) {
        Game.players = Integer.parseInt(players);
    }

    public static int[][] getBoard() {
        return board;
    }

    public static void setBoard(int[][] board) {
        Game.board = board;
    }

    public static void place(int row, int col, int value) {
        Game.board[row][col] = value;
    }
}
