package game.logic;

import edu.kit.informatik.Terminal;
import game.objects.Game;

public class Winner {

    /**
     * Checks for a winner depending on the type of the game
     * 
     * @return true if the game is finished (if someone won or if the game ended
     *         in a draw) and false instead
     */
    public static boolean check() {
        if (Game.isStandard()) {
            return Winner.standardCheck();
        } else {
            return Winner.torusCheck();
        }
    }

    /**
     * Checks for a winner in a standard game
     * 
     * @return true if the game is finished (if someone won or if the game ended
     *         in a draw) and false instead
     */
    private static boolean standardCheck() {
        // Searches for winner diagonally to the right
        for (int i = 0; i < Game.getSize() - 5; i++) {
            for (int j = 0; j < Game.getSize() - 5; j++) {
                if (Game.getBoard()[i][j] != 0) {
                    if ((Game.getBoard()[i][j] == Game.getBoard()[i + 1][j + 1])
                            && (Game.getBoard()[i + 1][j + 1] == Game.getBoard()[i + 2][j + 2])
                            && (Game.getBoard()[i + 2][j + 2] == Game.getBoard()[i + 3][j + 3])
                            && (Game.getBoard()[i + 3][j + 3] == Game.getBoard()[i + 4][j + 4])
                            && (Game.getBoard()[i + 4][j + 4] == Game.getBoard()[i + 5][j + 5])) {
                        Terminal.printLine(
                                "P" + Integer.toString(Game.getTurn() % Game.getPlayers() + 1) + " wins");
                        Game.setCanPlace(false);
                        return true;
                    }
                }
            }
        }
        // Searches for winner diagonally to the left
        for (int i = 0; i < Game.getSize() - 5; i++) {
            for (int j = 5; j < Game.getSize(); j++) {
                if (Game.getBoard()[i][j] != 0) {
                    if ((Game.getBoard()[i][j] == Game.getBoard()[i + 1][j - 1])
                            && (Game.getBoard()[i + 1][j - 1] == Game.getBoard()[i + 2][j - 2])
                            && (Game.getBoard()[i + 2][j - 2] == Game.getBoard()[i + 3][j - 3])
                            && (Game.getBoard()[i + 3][j - 3] == Game.getBoard()[i + 4][j - 4])
                            && (Game.getBoard()[i + 4][j - 4] == Game.getBoard()[i + 5][j - 5])) {
                        Terminal.printLine(
                                "P" + Integer.toString(Game.getTurn() % Game.getPlayers() + 1) + " wins");
                        Game.setCanPlace(false);
                        return true;
                    }
                }
            }
        }
        // Searches for winner horizontally
        for (int i = 0; i < Game.getSize(); i++) {
            for (int j = 0; j < Game.getSize() - 5; j++) {
                if (Game.getBoard()[i][j] != 0) {
                    if ((Game.getBoard()[i][j] == Game.getBoard()[i][j + 1])
                            && (Game.getBoard()[i][j + 1] == Game.getBoard()[i][j + 2])
                            && (Game.getBoard()[i][j + 2] == Game.getBoard()[i][j + 3])
                            && (Game.getBoard()[i][j + 3] == Game.getBoard()[i][j + 4])
                            && (Game.getBoard()[i][j + 4] == Game.getBoard()[i][j + 5])) {
                        Terminal.printLine(
                                "P" + Integer.toString(Game.getTurn() % Game.getPlayers() + 1) + " wins");
                        Game.setCanPlace(false);
                        return true;
                    }
                }
            }
        }
        // Searches for winner vertically
        for (int i = 0; i < Game.getSize() - 5; i++) {
            for (int j = 0; j < Game.getSize(); j++) {
                if (Game.getBoard()[i][j] != 0) {
                    if ((Game.getBoard()[i][j] == Game.getBoard()[i + 1][j])
                            && (Game.getBoard()[i + 1][j] == Game.getBoard()[i + 2][j])
                            && (Game.getBoard()[i + 2][j] == Game.getBoard()[i + 3][j])
                            && (Game.getBoard()[i + 3][j] == Game.getBoard()[i + 4][j])
                            && (Game.getBoard()[i + 4][j] == Game.getBoard()[i + 5][j])) {
                        Terminal.printLine(
                                "P" + Integer.toString(Game.getTurn() % Game.getPlayers() + 1) + " wins");
                        Game.setCanPlace(false);
                        return true;
                    }
                }
            }
        }
        // If the board is full and no winner has been found yet, that means
        // that the game ended in a draw
        if ((Game.getTurn() + 1) * 2 == Game.getSize() * Game.getSize()) {
            Terminal.printLine("draw");
            Game.setCanPlace(false);
            return true;
        }
        return false;
    }

    /**
     * Checks for a winner in a torus game
     * 
     * @return true if the game is finished (if someone won or if the game ended
     *         in a draw) and false instead
     */
    private static boolean torusCheck() {

        // Searches for winner diagonally to the right
        if (Winner.torusDiagRightCheck()) {
            return true;
        }
        // Searches for winner diagonally to the left
        if (Winner.torusDiagLeftCheck()) {
            return true;
        }
        // Searches for winner horizontally
        if (Winner.torusHorizontalCheck()) {
            return true;
        }
        // Searches for winner vertically
        if (Winner.torusVerticalCheck()) {
            return true;
        }

        // If the board is full and no winner has been found yet, that means
        // that the game ended in a draw
        if ((Game.getTurn() + 1) * 2 == Game.getSize() * Game.getSize()) {
            Terminal.printLine("draw");
            Game.setCanPlace(false);
            return true;
        }

        return false;
    }

    /**
     * Searches for winner diagonally to the right
     * 
     * @return true if a winner has been found and false instead
     */
    private static boolean torusDiagRightCheck() {

        for (int i = 0; i < Game.getSize(); i++) {
            for (int j = 0; j < Game.getSize(); j++) {
                if (Game.getBoard()[i][j] != 0) {
                    if ((Game.getBoard()[i][j] == Game.getBoard()[(i + 1) % Game.getSize()][(j + 1)
                            % Game.getSize()])
                            && (Game.getBoard()[(i + 1) % Game.getSize()][(j + 1)
                                    % Game.getSize()] == Game.getBoard()[(i + 2) % Game.getSize()][(j + 2)
                                            % Game.getSize()])
                            && (Game.getBoard()[(i + 2) % Game.getSize()][(j + 2)
                                    % Game.getSize()] == Game.getBoard()[(i + 3) % Game.getSize()][(j + 3)
                                            % Game.getSize()])
                            && (Game.getBoard()[(i + 3) % Game.getSize()][(j + 3)
                                    % Game.getSize()] == Game.getBoard()[(i + 4) % Game.getSize()][(j + 4)
                                            % Game.getSize()])
                            && (Game.getBoard()[(i + 4) % Game.getSize()][(j + 4)
                                    % Game.getSize()] == Game.getBoard()[(i + 5) % Game.getSize()][(j + 5)
                                            % Game.getSize()])) {
                        Terminal.printLine(
                                "P" + Integer.toString(Game.getTurn() % Game.getPlayers() + 1) + " wins");
                        Game.setCanPlace(false);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Searches for winner diagonally to the left
     * 
     * @return true if a winner has been found and false instead
     */
    private static boolean torusDiagLeftCheck() {

        for (int i = 0; i < Game.getSize(); i++) {
            for (int j = 5; j < Game.getSize() + 5; j++) {

                if (Game.getBoard()[i][j % Game.getSize()] != 0) {
                    if ((Game.getBoard()[i][j
                            % Game.getSize()] == Game.getBoard()[(i + 1) % Game.getSize()][(j - 1)
                                    % Game.getSize()])
                            && (Game.getBoard()[(i + 1) % Game.getSize()][(j - 1)
                                    % Game.getSize()] == Game.getBoard()[(i + 2) % Game.getSize()][(j - 2)
                                            % Game.getSize()])
                            && (Game.getBoard()[(i + 2) % Game.getSize()][(j - 2)
                                    % Game.getSize()] == Game.getBoard()[(i + 3) % Game.getSize()][(j - 3)
                                            % Game.getSize()])
                            && (Game.getBoard()[(i + 3) % Game.getSize()][(j - 3)
                                    % Game.getSize()] == Game.getBoard()[(i + 4) % Game.getSize()][(j - 4)
                                            % Game.getSize()])
                            && (Game.getBoard()[(i + 4) % Game.getSize()][(j - 4)
                                    % Game.getSize()] == Game.getBoard()[(i + 5) % Game.getSize()][(j - 5)
                                            % Game.getSize()])) {
                        Terminal.printLine(
                                "P" + Integer.toString(Game.getTurn() % Game.getPlayers() + 1) + " wins");
                        Game.setCanPlace(false);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Searches for winner horizontally
     * 
     * @return true if a winner has been found and false instead
     */
    private static boolean torusHorizontalCheck() {

        for (int i = 0; i < Game.getSize(); i++) {
            for (int j = 0; j < Game.getSize(); j++) {
                if (Game.getBoard()[i][j] != 0) {
                    if ((Game.getBoard()[i][j] == Game.getBoard()[i][(j + 1) % Game.getSize()])
                            && (Game.getBoard()[i][(j + 1) % Game.getSize()] == Game.getBoard()[i][(j + 2)
                                    % Game.getSize()])
                            && (Game.getBoard()[i][(j + 2) % Game.getSize()] == Game.getBoard()[i][(j + 3)
                                    % Game.getSize()])
                            && (Game.getBoard()[i][(j + 3) % Game.getSize()] == Game.getBoard()[i][(j + 4)
                                    % Game.getSize()])
                            && (Game.getBoard()[i][(j + 4) % Game.getSize()] == Game.getBoard()[i][(j + 5)
                                    % Game.getSize()])) {
                        Terminal.printLine(
                                "P" + Integer.toString(Game.getTurn() % Game.getPlayers() + 1) + " wins");
                        Game.setCanPlace(false);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Searches for winner vertically
     * 
     * @return true if a winner has been found and false instead
     */
    private static boolean torusVerticalCheck() {

        for (int i = 0; i < Game.getSize(); i++) {
            for (int j = 0; j < Game.getSize(); j++) {
                if (Game.getBoard()[i][j] != 0) {
                    if ((Game.getBoard()[i][j] == Game.getBoard()[(i + 1) % Game.getSize()][j])
                            && (Game.getBoard()[(i + 1) % Game.getSize()][j] == Game.getBoard()[(i + 2)
                                    % Game.getSize()][j])
                            && (Game.getBoard()[(i + 2) % Game.getSize()][j] == Game.getBoard()[(i + 3)
                                    % Game.getSize()][j])
                            && (Game.getBoard()[(i + 3) % Game.getSize()][j] == Game.getBoard()[(i + 4)
                                    % Game.getSize()][j])
                            && (Game.getBoard()[(i + 4) % Game.getSize()][j] == Game.getBoard()[(i + 5)
                                    % Game.getSize()][j])) {
                        Terminal.printLine(
                                "P" + Integer.toString(Game.getTurn() % Game.getPlayers() + 1) + " wins");
                        Game.setCanPlace(false);
                        return true;
                    }
                }
            }
        }
        return false;
    }
}