package game.io;

import edu.kit.informatik.Terminal;
import game.errors.InvalidInputException;
import game.logic.Instructions;

public class GameInterface {

    /**
     * 
     * @param args
     *            Used to determine the type of the game, the size of the board
     *            and the number of players
     */
    public static void main(String[] args) {

        try {
            Instructions.start(args);
        } catch (InvalidInputException e) {
            Terminal.printError("Invalid inputs!");
        }
    }
}
