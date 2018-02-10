package game.logic;

import edu.kit.informatik.Terminal;
import game.errors.Errors;
import game.errors.InvalidInputException;

public class Instructions {

    public static void start(String[] input) throws InvalidInputException {
        if (Errors.start(input)) {
            throw new InvalidInputException();
        } else {
            while (Game.end == false) {

                Game.splitter(Terminal.readLine());

            }
        }
    }

    public static void place(String input) throws InvalidInputException {
        if (Errors.place(input)) {
            throw new InvalidInputException();
        } else {
            // TODO Method
        }
    }

    public static void reset() {
        // TODO Auto-generated method stub

    }

}
