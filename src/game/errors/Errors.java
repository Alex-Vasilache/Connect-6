package game.errors;

import game.logic.Game;
import game.logic.Instructions;

public class Errors {

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
                if (row1 == row2 && col1 == col2 % Game.getSize()) {
                    return true;
                }
            } catch (NumberFormatException e) {
                return true;
            }
        }

        return false;
    }

    public static boolean rowPrint(String string) {
        // TODO Auto-generated method stub
        return false;
    }

    public static boolean colPrint(String string) {
        // TODO Auto-generated method stub
        return false;
    }

    public static boolean print(String string) {
        // TODO Auto-generated method stub
        return false;
    }

    public static boolean state(String string) {
        // TODO Auto-generated method stub
        return false;
    }

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
