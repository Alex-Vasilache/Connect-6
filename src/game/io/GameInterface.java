package game.io;

import edu.kit.informatik.*;
import game.errors.InvalidInputException;
import game.logic.Game;
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
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
