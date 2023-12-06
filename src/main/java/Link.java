package edu.curtin.app;

import java.util.logging.Logger;

/*Assigns linking characters to join the doors and walls of the maze */
/*Template pattern used */
public class Link extends CreateGrid {

    /* Unicodes that create walls and doors */
    public static final char VERTICAL = '\u2502';
    public static final char HORIZONTAL = '\u2500';
    public static final char DOOR = '\u2592';

    /* Logger is created */
    private static final Logger LOG = Logger.getLogger(Link.class.getName());

    /* Hook method implemented */
    @Override
    protected void assignCharacters(char[][] array, int row, int col) throws CustomException {
        LOG.info(() -> "Adds joining characters to link characters in the maze");
        try {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {

                    /* Searches elements around a vertical wall and assigns chracters to link */
                    if (array[i][j] == VERTICAL) {

                        if (array[i][j] != array[0][j]) {
                            if (array[i - 1][j] == ' ') {
                                if ((array[i][j - 1] == HORIZONTAL) && (array[i][j + 1] == ' ')) {
                                    array[i][j] = '\u2510'; /* Adds ┐ */
                                    LOG.info(() -> "Adds ┐");
                                }

                                if ((array[i][j - 1] == ' ') && (array[i][j + 1] == HORIZONTAL)) {
                                    array[i][j] = '\u250c'; /* Adds ┌ */
                                    LOG.info(() -> "Adds ┌ ");
                                }

                            }

                            if (array[i - 1][j] == HORIZONTAL) {
                                if (array[i - 1][j + 1] == ' ') {
                                    array[i - 1][j] = '\u2510'; /* Adds ┐ */
                                    LOG.info(() -> "Adds ┐");
                                }

                            }

                            if (array[i + 1][j] == HORIZONTAL) {
                                if ((array[i + 1][j + 1] == HORIZONTAL) || (array[i + 1][j + 1] == DOOR)) {
                                    if ((array[i + 1][j - 1] == HORIZONTAL) || (array[i + 1][j - 1] == DOOR)) {
                                        array[i + 1][j] = '\u2534'; /* Adds ┴ */
                                        LOG.info(() -> "Adds ┴ ");
                                    }
                                }
                            }

                            if (array[i - 1][j] == HORIZONTAL) {
                                if ((array[i - 1][j + 1] == HORIZONTAL) || (array[i - 1][j + 1] == DOOR)) {
                                    if ((array[i - 1][j - 1] == HORIZONTAL) || (array[i - 1][j - 1] == DOOR)) {
                                        array[i - 1][j] = '\u252c'; /* Adds ┬ */
                                        LOG.info(() -> "Adds ┬");
                                    }
                                }
                            }

                            if (array[i][j] != array[row - 1][j]) {
                                if (array[i][j] == array[i][0]) {

                                    if (array[i][1] == HORIZONTAL) {
                                        array[i][j] = '\u251c'; /* Adds ├ */
                                        LOG.info(() -> "Adds ├ ");
                                    }

                                }
                            }
                        }

                        if (array[i + 1][j] == ' ') {
                            if ((array[i][j - 1] == HORIZONTAL) && (array[i][j + 1] == ' ')) {
                                array[i][j] = '\u2518'; /* Adds ┘ */
                                LOG.info(() -> "Adds ┘");
                            }

                            if ((array[i][j - 1] == ' ') && (array[i][j + 2] == HORIZONTAL)) {
                                array[i][j] = '\u2514'; /* Adds └ */
                                LOG.info(() -> "Adds └");
                            }

                        }

                        if (array[i][j] == array[0][j]) {
                            array[i][j] = '\u252c'; /* Adds ┬ */
                            LOG.info(() -> "Adds ┬");
                        }

                        if ((array[i][j] != array[i][0]) && (array[i][j] != array[i][col - 1])) {
                            if ((array[i][j] != array[0][j]) && (array[i][j] != array[row - 1][j])) {

                                if ((array[i][j + 1] == HORIZONTAL) && (array[i][j - 1] == HORIZONTAL)) {
                                    if ((array[i + 1][j] == VERTICAL) && (array[i - 1][j] == VERTICAL)) {

                                        array[i][j] = '\u253c'; /* Adds ┼ */
                                        LOG.info(() -> "Adds ┼");
                                    }
                                }
                            }
                        }

                        if ((array[i + 1][j] == HORIZONTAL) && (array[i + 2][j] == VERTICAL)) {
                            array[i + 1][j] = '\u253c';
                        }

                    }

                    if (array[i][j] == DOOR) {

                        if ((array[i][j - 1] == VERTICAL) && (array[i][j - 2] == HORIZONTAL)) {
                            if (array[i + 1][j - 1] == ' ') {
                                array[i][j - 1] = '\u2534';
                            }

                            if (array[i - 1][j - 1] == ' ') {
                                array[i][j - 1] = '\u252c';
                            }

                            if ((array[i - 1][j - 1] == VERTICAL) || (array[i - 1][j - 1] == DOOR)) {
                                if ((array[i + 1][j - 1] == VERTICAL) || (array[i + 1][j - 1] == DOOR)) {
                                    array[i][j - 1] = '\u253c';
                                }

                            }

                        }

                        if ((array[i][j + 1] == VERTICAL) && (array[i][j + 2] == HORIZONTAL)) {
                            if (array[i - 1][j + 1] == ' ') {
                                array[i][j + 1] = '\u252c';
                            }
                        }

                        if ((array[i - 1][j - 1] == HORIZONTAL) && (array[i - 1][j + 1] == ' ')) {
                            array[i - 1][j] = '\u2510';
                        }

                        if (array[i - 1][j] == HORIZONTAL) {
                            if (array[i - 1][j + 1] == ' ') {
                                array[i - 1][j] = '\u2510';
                            }

                            if (array[i - 1][j] == array[0][j]) {
                                array[i - 1][j] = '\u252c';
                            }

                        }

                        if (array[i + 1][j] == HORIZONTAL) {
                            if (array[i + 1][j + 1] == ' ') {
                                array[i + 1][j] = '\u2518';
                            }

                            if (array[i + 1][j] == array[row - 1][j]) {
                                array[i + 1][j] = '\u2534';
                            }

                        }

                        if (array[i + 1][j + 1] == HORIZONTAL) {
                            array[i + 1][j] = '\u2514';
                            if (array[i + 1][j] == array[row - 1][j]) {
                                array[i + 1][j] = '\u2534';
                            }
                        }

                        if ((array[i][j - 1] == HORIZONTAL) && (array[i - 1][j - 1] == VERTICAL)) {
                            array[i][j - 1] = '\u2534';
                        }
                    }

                    if (array[i][j] == HORIZONTAL) {
                        if (array[i][j] == array[i][col - 1]) {
                            array[i][j] = '\u2524';
                        }

                        /*
                         * if ((array[i][j + 1] == VERTICAL) && (array[i][j + 2] == HORIZONTAL)) {
                         * if (array[i - 1][j + 1] == ' ') {
                         * array[i][j + 1] = '\u252c';
                         * }
                         * }
                         */
                    }

                }

            }
        } catch (ArrayIndexOutOfBoundsException e) {
            LOG.warning(() -> "Elements out of array bounds are accessed" + e);

        }

    }

}
