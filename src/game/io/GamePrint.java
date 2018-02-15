package game.io;

import edu.kit.informatik.Terminal;
import game.errors.Errors;
import game.errors.InvalidInputException;
import game.objects.Game;

public class GamePrint {

    /**
     * Prints the entered row
     * 
     * @param input
     *            represents the row to be printed
     * @throws InvalidInputException
     *             in case the inputs are not valid
     */
    public static void rowPrint(String input) throws InvalidInputException {
        if (Errors.rowPrint(input)) {
            throw new InvalidInputException();
        } else {
            int row = Integer.parseInt(input);
            String line = "";
            for (int col = 0; col < Game.getSize(); col++) {
                if (Game.getBoard()[row][col] == 0) {
                    line += "**";
                } else {
                    line += "P" + Integer.toString(Game.getBoard()[row][col]);
                }
                if (col != Game.getSize() - 1) {
                    line += " ";
                }
            }
            Terminal.printLine(line);
        }
    }

    /**
     * Prints the entered column
     * 
     * @param input
     *            represents the column to be printed
     * @throws InvalidInputException
     *             in case the inputs are not valid
     */
    public static void colPrint(String input) throws InvalidInputException {
        if (Errors.rowPrint(input)) {
            throw new InvalidInputException();
        } else {
            int col = Integer.parseInt(input);
            String line = "";
            for (int row = 0; row < Game.getSize(); row++) {
                if (Game.getBoard()[row][col] == 0) {
                    line += "**";
                } else {
                    line += "P" + Integer.toString(Game.getBoard()[row][col]);
                }
                if (row != Game.getSize() - 1) {
                    line += " ";
                }
            }
            Terminal.printLine(line);

        }
    }

    /**
     * Prints the entire game board
     */
    public static void print() {
        for (int row = 0; row < Game.getSize(); row++) {
            try {
                rowPrint(Integer.toString(row));
            } catch (InvalidInputException e) {
            }
        }
    }

    /**
     * Prints the state of a board cell
     * 
     * @param input
     *            represents the String containing the row and column of the
     *            place to be stated
     * @throws InvalidInputException
     *             in case the inputs are not valid
     */
    public static void state(String input) throws InvalidInputException {
        if (Errors.state(input)) {
            throw new InvalidInputException();
        } else {
            String[] numbers = input.split(";");
            int row = Integer.parseInt(numbers[0]);
            int col = Integer.parseInt(numbers[1]);
            if (Game.getBoard()[row][col] == 0) {
                Terminal.printLine("**");
            } else {
                Terminal.printLine("P" + Game.getBoard()[row][col]);
            }
        }
    }

}
