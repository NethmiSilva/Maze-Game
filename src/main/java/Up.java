package edu.curtin.app;

import java.util.logging.Logger;

/*Base implementations of Decorator pattern */
/*Implements Template pattern by using the hook methods created in the abstract class */
/*Moves player Up */
public class Up extends MovementDecorator {

    /* Logger is created */
    private static final Logger LOG = Logger.getLogger(Up.class.getName());

    /* Decorator */
    public Up(Movement next) {
        super(next);
    }

    @Override
    public boolean move(char[][] array, int row, int col) throws CustomException {
        LOG.info(() -> "Moving player up");
        boolean check = false;

        /* Row and column position of the player is taken */
        int rowV = searchRow(array, row, col);
        int colV = searchCol(array, row, col);

        /* If player is in the top border exception thrown */
        if (array[rowV][colV] == array[0][colV]) {
            throw new CustomException("Cant move player out of maze");
        }

        /*
         * Checks if the element above is a space or a wall and allows the user to move
         * if it is a space
         */
        if (array[rowV - 1][colV] == ' ') {
            array[rowV][colV] = ' ';
            array[rowV - 1][colV] = '\u0050';
            check = false;

        }

        if (array[rowV - 1][colV] == '\u0045') /* moves the player to the goal */
        {

            array[rowV][colV] = ' ';
            array[rowV - 1][colV] = '\u0050';
            check = true; /* boolean is set to true if goal is reached */
            LOG.info(() -> "Player reached the goal");
        }

        return check;
    }

}
