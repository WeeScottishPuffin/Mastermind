package Mastermind;

public class guessVisual {

    public static String visualiseGuesses(int length, String[][] guesses, String[][] results, int currentGuess) {
        String guess_log = "";
        guess_log += "┌";
        guess_log += new String(new char[(2 * length + 3)]).replace("\0", "─");
        guess_log += "┐\n";
        int index = 0;
        for (String[] g : guesses) {
            // if (index == currentGuess){break;}
            guess_log += "│";
            for (int i = 0; i < length; i++) {
                guess_log += (g[i] != null) ? colours.colourMap().get(g[i]) : "o";
            }
            guess_log += " " + ((index + 1) % 10) + " ";
            for (int i = 0; i < length; i++) {
                guess_log += (results[index][i] != null) ? results[index][i] : "o";
            }
            guess_log += "│\n";
            index++;
        }
        guess_log += "└";
        guess_log += new String(new char[(2 * length + 3)]).replace("\0", "─");
        guess_log += "┘";
        return guess_log;
    }
}
