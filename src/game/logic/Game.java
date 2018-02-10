package game.logic;

import edu.kit.informatik.Terminal;
import game.errors.InvalidInputException;
import game.io.GamePrint;

public class Game {

    public static boolean end = false;
    public static int turn = 0;

    public static void splitter(String input) {

        String[] parts = input.split(" ", 2);

        switch (parts[0]) {
        case "place": {

            try {
                Instructions.place(parts[1]);
                turn++;
            } catch (InvalidInputException e) {
                Terminal.printError("WRITESOMETHING");
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
            end = true;
            break;
        }
        default:
            Terminal.printError("Instruction not valid");
        }
    }
}
