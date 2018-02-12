package game.logic;

import edu.kit.informatik.Terminal;
import game.errors.Errors;
import game.errors.InvalidInputException;

public class Instructions {

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

                Game.splitter(Terminal.readLine());

            }
        }
    }

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

    public static void reset() {
        // TODO Auto-generated method stub

    }

    public static int mod(int number) {

        while (number < 0) {
            number = number + Game.getSize();
        }
        number = number % Game.getSize();

        return number;
    }

}
