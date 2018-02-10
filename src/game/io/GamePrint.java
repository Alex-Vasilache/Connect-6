package game.io;

import game.errors.Errors;
import game.errors.InvalidInputException;

public class GamePrint {

    public static void rowPrint(String input) throws InvalidInputException {
        if (Errors.rowPrint(input)) {
            throw new InvalidInputException();
        } else {
            // TODO Method

        }
    }

    public static void colPrint(String input) throws InvalidInputException {
        if (Errors.colPrint(input)) {
            throw new InvalidInputException();
        } else {
            // TODO Method

        }
    }

    public static void print(String input) throws InvalidInputException {
        if (Errors.print(input)) {
            throw new InvalidInputException();
        } else {
            // TODO Method

        }
    }

    public static void state(String input) throws InvalidInputException {
        if (Errors.state(input)) {
            throw new InvalidInputException();
        } else {
            // TODO Method

        }
    }

}
