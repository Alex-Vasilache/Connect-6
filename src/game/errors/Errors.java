package game.errors;

import game.logic.Instructions;
import game.objects.Game;

public class Errors {

    /**
     * Checks for errors for a <<place>> instruction
     * 
     * @param input
     *            represents the entered data after the <<place>> command
     * @return true, if the input contains errors and false instead
     */
    public static boolean place(String input) {
        char[] parts = input.toCharArray();
        int numberOfSemiColums = 0;
        for (int i = 0; i < parts.length; i++) {
            if (parts[i] == ';') {
                numberOfSemiColums++;
            }
        }
        if (numberOfSemiColums != 3) {
            return true;
        } else {
            String[] numbers = input.split(";");
            try {
                int row1 = Integer.parseInt(numbers[0]);
                int col1 = Integer.parseInt(numbers[1]);
                int row2 = Integer.parseInt(numbers[2]);
                int col2 = Integer.parseInt(numbers[3]);

                if (Game.isStandard()) {
                    if (row1 < 0 || row1 > Game.getSize() - 1) {
                        return true;
                    }
                    if (col1 < 0 || col1 > Game.getSize() - 1) {
                        return true;
                    }
                    if (row2 < 0 || row2 > Game.getSize() - 1) {
                        return true;
                    }
                    if (col2 < 0 || col2 > Game.getSize() - 1) {
                        return true;
                    }
                } else {
                    row1 = Instructions.mod(row1);
                    col1 = Instructions.mod(col1);
                    row2 = Instructions.mod(row2);
                    col2 = Instructions.mod(col2);
                }
                if (Game.getBoard()[row1][col1] != 0 || Game.getBoard()[row2][col2] != 0) {
                    return true;
                }
                if (row1 == row2 && col1 == col2) {
                    return true;
                }
            } catch (NumberFormatException e) {
                return true;
            }
        }

        return false;
    }

    /**
     * Checks for errors for a <<rowprint>> or a <<colprint>> instruction
     * 
     * @param input
     *            represents the entered data after the <<rowprint>> and the <
     *            <colprint>> commands
     * @return true, if the input contains errors and false instead
     */
    public static boolean rowPrint(String input) {
        try {
            int row = Integer.parseInt(input);
            if (row < 0 || row > Game.getSize() - 1) {
                return true;
            }
        } catch (NumberFormatException e) {
            return true;
        }
        return false;
    }

    /**
     * Checks for errors for a <<state>> instruction
     * 
     * @param input
     *            represents the entered data after the <<state>> command
     * @return true, if the input contains errors and false instead
     */
    public static boolean state(String input) {
        try {
            String[] numbers = input.split(";");
            try {
                int row = Integer.parseInt(numbers[0]);
                int col = Integer.parseInt(numbers[1]);

                if (row < 0 || row > Game.getSize() - 1) {
                    return true;
                }
                if (col < 0 || col > Game.getSize() - 1) {
                    return true;
                }

            } catch (NumberFormatException e) {
                return true;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return true;
        }

        return false;
    }

    /**
     * Checks for errors for in the arguments of the game
     * 
     * @param input
     *            represents the array containing the arguments, referring to
     *            the details about the game (type, size, players)
     * @return true, if the input contains errors and false instead
     */
    public static boolean start(String[] input) {
        if (input.length != 3) {
            return true;
        } else if (input[0].equals("standard") == false && input[0].equals("torus") == false) {
            return true;
        } else if (input[1].equals("18") == false && input[1].equals("20") == false) {
            return true;
        } else if (input[2].equals("2") == false && input[2].equals("3") == false
                && input[2].equals("4") == false) {
            return true;
        } else {
            return false;
        }
    }

}
