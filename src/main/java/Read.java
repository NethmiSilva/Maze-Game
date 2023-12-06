package edu.curtin.app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

/*Reads file and makes an array based on the row and column numbers mentioned in text file.
  Calls function to assigns unicode characters to the array based on the data on the text file.
  Calls the function to allow user input in order to play the game.*/

public class Read {

    /* Unicode characters used to build the maze */
    public static final char VERTICAL = '\u2502';
    public static final char HORIZONTAL = '\u2500';
    public static final char PLAYER = '\u0050';
    public static final char END = '\u0045';
    public static final char DOOR = '\u2592';
    public static final char KEY = '\u2555';

    /* Logger is created */
    private static final Logger LOG = Logger.getLogger(Read.class.getName());

    public void readFile(String fileName) throws CustomException {

        Move move = new Move();

        LOG.info(() -> "Reading info from file '" + fileName + "'");

        try (Scanner sc = new Scanner(new File(fileName))) {

            /* Checks if the file is empty */
            LOG.info(() -> "Checks if the file is empty");
            if (!sc.hasNextLine()) {
                throw new CustomException("File is empty");

            }

            /* Reads array size and creates a bigger array */
            int numRows = sc.nextInt();
            int numCol = sc.nextInt();

            int rowww = (numRows * 2) + 1;
            int colsss = (numCol * 4) + 1;
            char[][] map = new char[rowww][colsss];

            /* Borders are added to the maze */
            CreateGrid array = new Border();
            array.assignCharacters(map, rowww, colsss);

            LOG.info(() -> "Array made");

            sc.nextLine(); /* Skips the first line */

            int lineNum = 0;

            /*
             * Loops till there are lines in the text file
             * lineNum integer is incremented each times the loop runs to get the count of
             * the lines present
             * lineNum is used to loop through and assign characters to the maze
             */
            while (sc.hasNextLine()) {
                LOG.info(() -> "Text file read and characters added to array");
                lineNum++;

                /* Text file line is split by a space and added to an array */
                String[] line = sc.nextLine().split(" ");

                String check = line[0];
                int row = Integer.parseInt(line[1]);
                int col = Integer.parseInt(line[2]);
                int r;
                int c;

                for (int i = 0; i < lineNum; i++) {

                    switch (check) {
                        case "WH": /* Horizontal line added to the north of the row and column position */
                            LOG.info(() -> "Horizontal walls to the north");

                            r = (row * 2) + 1;
                            c = (col * 4) + 2;

                            /* Assigns four horizontal lines in the same row */
                            map[r - 1][c] = HORIZONTAL;
                            map[r - 1][c - 1] = HORIZONTAL;
                            map[r - 1][c + 1] = HORIZONTAL;
                            // map[r - 1][c + 2] = HORIZONTAL;

                            break;

                        case "WV": /* Horizontal line added to the west of the row and column position */
                            LOG.info(() -> "Vertical walls to the left");
                            r = (row * 2) + 1;
                            c = (col * 4) + 2;

                            /* Assigns three vertical lines in the same column */
                            map[r][c - 2] = VERTICAL;
                            map[r - 1][c - 2] = VERTICAL;

                            /* Checks if the vertical line is on the last row and assigns unicode ┴ */
                            if (map[r + 1][c - 2] == map[rowww - 1][c - 2]) {
                                map[r + 1][c - 2] = '\u2534';

                            } else {
                                map[r + 1][c - 2] = VERTICAL;
                            }
                            break;

                        case "S": /* Player 'P' is added to the maze */
                            LOG.info(() -> "Player is added");
                            r = (row * 2) + 1;
                            c = (col * 4) + 2;

                            map[r][c] = PLAYER;

                            break;

                        case "K": /* Key '╕' is added to the maze */
                            LOG.info(() -> "Key is added");
                            r = (row * 2) + 1;
                            c = (col * 4) + 2;

                            map[r][c] = KEY;

                            break;

                        case "E": /* End position is added'E' */
                            LOG.info(() -> "End(winning) point added");
                            r = (row * 2) + 1;
                            c = (col * 4) + 2;

                            map[r][c] = END;

                            break;

                        case "DV": /* Vertical door ▒ added to the west of the position */
                            LOG.info(() -> "Vertical door to the west added");
                            r = (row * 2) + 1;
                            c = (col * 4) + 2;
                            map[r][c - 2] = DOOR;

                            /* Vertical lines are added to above and below the door */
                            // map[r - 1][c - 1] = VERTICAL;
                            // map[r + 1][c - 1] = VERTICAL;

                            break;

                        case "DH": /* Horizontal door ▒▒▒ added to the north of the position */
                            LOG.info(() -> "Horizontal doors to the north added");
                            r = (row * 2) + 1;
                            c = (col * 4) + 2;

                            /* Three vertical doors added to the same row to create a horizontal door */
                            map[r - 1][c] = DOOR;
                            map[r - 1][c - 1] = DOOR;
                            map[r - 1][c + 1] = DOOR;

                            if (map[r - 1][c + 2] == VERTICAL) {
                                map[r - 1][c + 2] = '\u2524';
                            }
                            break;

                        case "M":
                            LOG.info(() -> "Messages");
                            // r = (row * 2) + 1;
                            // c = (col * 4) + 2;

                            break;

                        default:
                            LOG.info(() -> "Default switch case");
                            break;

                    }

                }

            }

            CreateGrid newMaze = new Link(); /* Joining characters are added */
            newMaze.assignCharacters(map, rowww, colsss);
            move.userInput(map, rowww, colsss); /* Function to call user input to move player */

        } catch (FileNotFoundException e) {

            throw new CustomException("File not found", e);
        } catch (InputMismatchException | NumberFormatException ee) {

            throw new CustomException("Invalid input from text file", ee);
        } catch (ArrayIndexOutOfBoundsException eee) {

            throw new CustomException("Acecssing out of array bounds", eee);
        }

    }

}
