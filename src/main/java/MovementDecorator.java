package edu.curtin.app;

import java.util.logging.Logger;

/* Decoration Superclass */
public abstract class MovementDecorator implements Movement {

    /* Logger is created */
    private static final Logger LOG = Logger.getLogger(MovementDecorator.class.getName());

    protected Movement next;

    public MovementDecorator(Movement next) {
        this.next = next;
    }

    @Override
    public abstract boolean move(char[][] array, int row, int col) throws CustomException;

    public boolean movement(char[][] array, int row, int col) throws CustomException {

        return next.move(array, row, col);

    }

    /* Searches for row number of the player position */
    public int searchRow(char[][] array, int row, int col) throws CustomException {
        LOG.info(() -> "Searching row number of player");
        int rowV = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if ((array[i][j] == '\u0050')) {
                    rowV = i; /* row of the player position */

                }

            }
        }
        return rowV;

    }

    /* Searches for column number of the player position */
    public int searchCol(char[][] array, int row, int col) throws CustomException {
        LOG.info(() -> "Searching column number of player");
        int colV = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if ((array[i][j] == '\u0050')) {
                    colV = j; /* column of the player position */

                }

            }
        }
        return colV;

    }
}
