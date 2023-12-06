package edu.curtin.app;

import java.util.logging.Logger;

/*Assigns vertical and horizontal characters to the maze to create the maze border */
/*Template pattern used */
public class Border extends CreateGrid {

    /* Unicode characters for vertical and horizontal characters */
    public static final char VERTICAL = '\u2502';
    public static final char HORIZONTAL = '\u2500';

    /* Logger is created */
    private static final Logger LOG = Logger.getLogger(Border.class.getName());

    /* Hook Method Implementation */
    @Override
    protected void assignCharacters(char[][] array, int row, int col) throws CustomException {
        LOG.info(() -> "Creates the borders for the maze");

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                /* Spaces are assigned to each element of the array */
                array[i][j] = ' ';

                /* First and last column contains | */
                if ((j == 0) || (j == col - 1)) {
                    array[i][j] = VERTICAL;

                }
                /* First and last row contains ─ */
                if ((i == 0) || (i == row - 1)) {
                    array[i][j] = HORIZONTAL;
                }

            }
        }

        /* Corners of the borders are made */
        array[0][0] = '\u250c';
        array[0][col - 1] = '\u2510';
        array[row - 1][0] = '\u2514';
        array[row - 1][col - 1] = '\u2518';

    }

}
