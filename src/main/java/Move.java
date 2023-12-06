package edu.curtin.app;

import java.util.Scanner;
import java.util.logging.Logger;

/*Player is moved after the user input */

public class Move {

    /* Constructor for class */
    public Move() {

    }

    /* Logger is created */
    private static final Logger LOG = Logger.getLogger(Move.class.getName());

    /* Player is moved according to user input */
    public void userInput(char[][] array, int row, int col) throws CustomException {

        ViewMovement print = new ViewMovement();
        Clear clear = new Clear();

        LOG.info(() -> "Getting input to move player");
        boolean check = false;
        boolean error = false;

        /* Prints maze before taking user input */
        print.print(array, row, col);
        try (Scanner sc = new Scanner(System.in)) {

            do {
                /* Screen is cleared before printing the maze after each movement */

                /* Character input taken from user to move the player */
                char c = sc.next().charAt(0);

                /*
                 * Player movement
                 * n: Player moves up/north
                 * s: Player moves downs/ south
                 * w: Player moves left/west
                 * e: Player moves right/east
                 * deafault: Allows user to re-enter the movement
                 */

                switch (c) {
                    case 'n':
                        LOG.info(() -> "Player moved up");
                        error = false;
                        Movement template = new Up(new Play());
                        check = template.move(array, row, col);

                        clear.clearScreen(); /* Terminal cleared before printing */
                        print.print(array, row, col);

                        break;

                    case 's':
                        LOG.info(() -> "Player moved down");
                        error = false;
                        Movement template1 = new Down(new Play());
                        check = template1.move(array, row, col);
                        clear.clearScreen(); /* Terminal cleared before printing */
                        print.print(array, row, col);

                        break;

                    case 'w':
                        LOG.info(() -> "Player moved left");
                        error = false;
                        Movement template2 = new Left(new Play());
                        check = template2.move(array, row, col);

                        clear.clearScreen(); /* Terminal cleared before printing */
                        print.print(array, row, col);

                        break;

                    case 'e':
                        LOG.info(() -> "Player moved right");
                        error = false;
                        Movement template3 = new Right(new Play());
                        check = template3.move(array, row, col);
                        /* Terminal cleared before printing */
                        clear.clearScreen();
                        print.print(array, row, col);

                        break;

                    default:
                        /* Invalid user input */
                        LOG.info(() -> "Invalid movement key entered");
                        error = true;
                        break;

                }

                if (check == true) /* If goal is reached, the following statement is printed */
                {
                    System.out.println("You win!\n");

                }

                if (error == true) {
                    System.out.println("Invalid Entry! Re-enter command to move\n");
                    System.out.println(
                            "n- Player moves up/north\ns- Player moves downs/ south\nw- Player moves left/west");
                    System.out.println("e- Player moves right/east\n");
                }

            } while (!check);

        }
    }

}
