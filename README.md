# Mastermind

**An ASCII implementation of the simple guessing game, mastermind.**

This is my first real project that I've written using Java and the first casus for my CS course. The objective was to simply recreate this elementary game, without many restrictions.

This being my first experience with Java programming, the code may be a bit messy or unoptimised. However, I do still reckon that I've succeeded with programming the casus.

## How it works

After starting up the program `mastermind.java`, a simple splash screen will display. Pressing `<RETURN>` on your keyboard will start the game. In the code, there are two `final` variables controlling the length of the code and the amount of guesses you get to crack said code.

At the start of the game, the computer randomly generates a code consisting of random colours (which are stored in the `colours.java` file). After this, you will be able to submit your guesses every turn by entering the first letter of any of the colours.

After every turn, the computer will show you how accurate your guess is. It will display this in the form of yellow and green pins. A yellow pin means that the colour at the given positions occurs at least once in the code, but not on this specific position. A green pin is place when the colour occurs at that specific position. That colour may however occur more times in the complete code.

If you correctly guess the code within the turn limit, you win.

## File Structure

```
REPO                                    #
├Mastermind                             #
│    ├colours.java                      #   Stores the values of all possible colours
│    ├guessVisual.java                  #   Method to visualise the board using ANSI/ascii art
│    └mastermind.java                   #   Main code
├readme.md                              #   README
└.gitignore                             #   Standard .gitignore

```
