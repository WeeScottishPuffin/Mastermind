package Mastermind;

import java.util.Arrays;
import java.util.Scanner;

public class mastermind {

    private static void clear() {
        for (int j = 0; j < 50; ++j) {
            System.out.println();
        }
    }

    public static void main(String[] args) {
        //Init variables
        final String SPLASH = "\u001B[31m8b    d8 \u001B[32m   db    \u001B[33m.dP\"Y8 \u001B[34m888888 \u001B[35m888888 \u001B[36m88\"\"Yb\u001B[0m 8b    d8 88 88b 88 8888b.\n\u001B[31m88b  d88 \u001B[32m  dPYb   \u001B[33m`Ybo.\" \u001B[34m  88   \u001B[35m88__   \u001B[36m88__dP\u001B[0m 88b  d88 88 88Yb88  8I  Yb\n\u001B[31m88YbdP88 \u001B[32m dP__Yb  \u001B[33mo.`Y8b \u001B[34m  88   \u001B[35m88\"\"   \u001B[36m88\"Yb\u001B[0m  88YbdP88 88 88 Y88  8I  dY\n\u001B[31m88 YY 88 \u001B[32mdP\"\"\"\"Yb \u001B[33m8bodP' \u001B[34m  88   \u001B[35m888888 \u001B[36m88  Yb\u001B[0m 88 YY 88 88 88  Y8 8888Y\"  ";
        final int TURNS = 10;
        final int CODE_LENGTH = 4;
        Boolean won = false;
        Boolean quit = false;
        String[] solution = new String[CODE_LENGTH];
        String[] guess = new String[CODE_LENGTH];
        String[][] guesses = new String[TURNS][CODE_LENGTH];
        String[][] results = new String[TURNS][CODE_LENGTH];
        String guess_log;
        int guessNum = -1;
        String[] colours_short = colours.colourMap().keySet().toArray(new String[colours.colourMap().size()]);
        //Generate solution
        for (int i = 0; i < CODE_LENGTH; i++) {
            int choice = (int) (Math.random() * colours.colourMap().size());
            solution[i] = colours_short[choice];
        }
        //Initialise input stream
        Scanner inStream = new Scanner(System.in);
        //Intro
        clear();
        System.out.println(SPLASH);
        System.out.println("\nBy ScottishPuffin (Naut van der Winden)");
        System.out.print("Press <RETURN> to start");
        inStream.nextLine();
        //Mainloop
        for (int guessn = 0; guessn < TURNS; guessn++) {
            //Print old guesses
            //Guess
            for (int j = 0; j < CODE_LENGTH; j++) {
                String guess_ = "";
                guess_log = guessVisual.visualiseGuesses(CODE_LENGTH, guesses, results, guessn);
                while (!Arrays.asList(colours_short).contains(guess_) && !"e".equals(guess_)) {
                    clear();
                    System.out.println(guess_log);
                    System.out.println("Guess " + (guessn + 1) + "/" + TURNS + ":");
                    System.out.println("What colour for position " + (j + 1) + " (\u001B[31m[R]ed, \u001B[32m[G]reen, \u001B[33m[Y]ellow, \u001B[34m[B]lue, \u001B[35m[M]agenta, \u001B[36m[C]yan\u001B[0m or [E]xit):");
                    guess_ = inStream.nextLine().toLowerCase();
                }
                if ("e".equals(guess_)) {
                    quit = true;
                    break;
                }
                guess[j] = guess_;
                guesses[guessn][j] = guess_;
            }
            if (quit) {break;}
            //Check
            won = true;
            for (int i = 0; i < CODE_LENGTH; i++) {
                if (guess[i].equals(solution[i])) {
                    results[guessn][i] = colours.colourMap().get("g");
                } else if (Arrays.asList(solution).contains(guess[i])) {
                    won = false;
                    results[guessn][i] = colours.colourMap().get("y");
                } else {
                    results[guessn][i] = "o";
                    won = false;
                }
            }
            guessNum = guessn + 1;
            if (won) {
                break;
            }
            System.out.println();
        }
        //Check if you won or lost
        clear();
        guess_log = guessVisual.visualiseGuesses(CODE_LENGTH, guesses, results, guessNum);
        System.out.println(guess_log);
        if (won) {
            System.out.println("You won!");
            System.out.println("Guesses used: " + guessNum);
        } else {
            System.out.println("You lose!");
            System.out.println("The code was:");
            for (String p: solution){
                System.out.print(colours.colourMap().get(p));
            }
        }
        inStream.close();
    }
}
