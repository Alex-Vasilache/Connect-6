package game.logic;

import edu.kit.informatik.Terminal;
import game.errors.Errors;
import game.errors.InvalidInputException;
import game.objects.Game;

public class Instructions {

    /**
     * Starts the game, by initializing the variables with the entered values in
     * the arguments
     * 
     * @param input
     *            represents the array entered as arguments, containing the type
     *            of the game, the size of the board and the number of players
     * @throws InvalidInputException
     *             In the cases when the inputs don't match the required pattern
     */
    public static void start(String[] input) throws InvalidInputException {
        if (Errors.start(input)) {
            throw new InvalidInputException();
        } else {

            if (input[0].equals("standard")) {
                Game.setStandard(true);
            } else {
                Game.setStandard(false);
            }
            Game.setSize(input[1]);
            Game.setPlayers(input[2]);
            Game.setBoard(new int[Game.getSize()][Game.getSize()]);

            while (Game.isEnd() == false) {

                Splitter.split(Terminal.readLine());

            }
        }
    }

    /**
     * Places 2 pieces for the player in turn on the entered rows and columns
     * 
     * @param input
     *            represents a String containing the rows and columns where the
     *            pieces needed to be placed
     * @throws InvalidInputException
     *             if the inputs are not valid
     */
    public static void place(String input) throws InvalidInputException {
        if (Errors.place(input) || !Game.canPlace()) {
            throw new InvalidInputException();
        } else {
            String[] numbers = input.split(";");

            int row1 = Instructions.mod(Integer.parseInt(numbers[0]));
            int col1 = Instructions.mod(Integer.parseInt(numbers[1]));
            int row2 = Instructions.mod(Integer.parseInt(numbers[2]));
            int col2 = Instructions.mod(Integer.parseInt(numbers[3]));

            Game.place(row1, col1, Game.getTurn() % Game.getPlayers() + 1);
            Game.place(row2, col2, Game.getTurn() % Game.getPlayers() + 1);
        }
    }

    /**
     * Resets the game
     */
    public static void reset() {
        Game.setEnd(false);
        Game.setTurn(0);
        Game.setBoard(new int[Game.getSize()][Game.getSize()]);
        Game.setCanPlace(true);
        Terminal.printLine("OK");
    }

    /**
     * Calculates the modulo value (referring to the game size) of a number. The
     * operation works on negative numbers as well.
     * 
     * @param number
     *            the number entered to get the modulo from
     * @return the number entered modulo the game size
     */
    public static int mod(int number) {

        while (number < 0) {
            number = number + Game.getSize();
        }
        number = number % Game.getSize();

        return number;
    }

}
