package edu.curtin.app;

import java.util.logging.Logger;

/*Displays the maze */

public class ViewMovement {

    /* Logger is created */
    private static final Logger LOG = Logger.getLogger(ViewMovement.class.getName());

    /* Constructor for class */
    public ViewMovement() {
    }

    /* Maze is printed */
    public boolean print(char[][] array, int row, int col) throws CustomException {
        LOG.info(() -> "Printing maze ");
        if (array == null) {
            throw new CustomException("Maze is empty");
        }

        /* Loops through the rows and columns of the array and prints the element */
        /* Terminal is cleared before printing the array */
        // clearScreen();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                System.out.print(array[i][j] + "  ");
            }
            System.out.println("\n");
        }
        return false;

    }

}
