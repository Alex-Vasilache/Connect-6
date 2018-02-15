package game.logic;

import edu.kit.informatik.Terminal;
import game.errors.InvalidInputException;
import game.io.GamePrint;
import game.objects.Game;

public class Splitter {

    /**
     * This method is used to split every line entered by the user in order to
     * extract every command
     * 
     * @param input
     *            Represents the line entered by the user
     * 
     */
    public static void split(String input) {

        String[] parts = input.split(" ", 2);

        switch (parts[0]) {
        case "place": {

            try {
                Instructions.place(parts[1]);
                if (Winner.check() == false) {
                    Terminal.printLine("OK");
                }
                Game.setTurn((Game.getTurn() + 1));

            } catch (InvalidInputException e) {
                if (Game.canPlace() == false) {
                    Terminal.printError("Cannot use <<place>> instruction! Game already finished!");
                } else {
                    Terminal.printError("Invalid Inputs");
                }
            }

            break;
        }
        case "rowprint": {

            try {
                GamePrint.rowPrint(parts[1]);
            } catch (InvalidInputException e) {
                Terminal.printError("Invalid inputs!");
            }

            break;
        }
        case "colprint": {

            try {
                GamePrint.rowPrint(parts[1]);
            } catch (InvalidInputException e) {
                Terminal.printError("Invalid inputs!");
            }

            break;
        }
        case "print": {

            try {
                String s = parts[1];
                Terminal.printError("Invalid inputs!");

            } catch (ArrayIndexOutOfBoundsException e) {

                GamePrint.print();
            }

            break;
        }
        case "state": {

            try {
                GamePrint.state(parts[1]);
            } catch (InvalidInputException e) {
                Terminal.printError("Invalid inputs");
            }

            break;
        }
        case "reset": {
            Instructions.reset();
            break;
        }
        case "quit": {
            Game.setEnd(true);
            break;
        }
        default:
            Terminal.printError("Instruction not valid");
        }
    }
}