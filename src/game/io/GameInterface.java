package game.io;

import edu.kit.informatik.Terminal;
import game.errors.InvalidInputException;
import game.logic.Instructions;

public class GameInterface {

    /**
     * @param args
     *            not used throughout the program
     */
    public static void main(String[] args) {

        try {
            Instructions.start(args);
        } catch (InvalidInputException e) {
            Terminal.printError("Invalid inputs!");
        }
    }
}
